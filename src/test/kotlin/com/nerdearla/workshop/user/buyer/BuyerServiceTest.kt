package com.nerdearla.workshop.user.buyer

import com.nerdearla.workshop.`when`
import com.nerdearla.workshop.given
import com.nerdearla.workshop.then
import com.nerdearla.workshop.user.buyer.client.BuyerClient
import com.nerdearla.workshop.user.buyer.error.BuyerRetrievingError
import com.nerdearla.workshop.user.buyer.error.DisabledBuyerError
import com.nerdearla.workshop.user.buyer.validator.BuyerValidator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe
import io.mockk.*

class BuyerServiceTest : FeatureSpec({

    feature("get buyer") {

        val client = mockk<BuyerClient>()
        val validator = mockk<BuyerValidator>()

        val service = BuyerService(
            client = client,
            validator = validator
        )

        beforeEach {
            clearAllMocks()
        }

        scenario("get valid buyer") {
            lateinit var result: Buyer
            val aBuyer = aBuyer()

            given("mocked dependencies") {
                every { client.getBy(aBuyer.id) } returns aBuyer
                every { validator.validate(aBuyer) } just runs
            }

            `when`("getting buyer") {
                result = service.getBy(aBuyer.id)
            }

            then("user found") {
                result shouldBe aBuyer
            }
        }

        scenario("non existent user") {
            val aBuyer = aBuyer()

            given("mocked dependencies") {
                every { client.getBy(aBuyer.id) } throws BuyerRetrievingError()
            }

            then("getting buyer throws buyer retrieving error") {
                shouldThrow<BuyerRetrievingError> {
                    service.getBy(aBuyer.id)
                }
            }
        }

        scenario("not valid user") {
            val aBuyer = aBuyer()

            given("mocked dependencies") {
                every { client.getBy(aBuyer.id) } returns aBuyer
                every { validator.validate(aBuyer) } throws DisabledBuyerError()
            }

            then("getting buyer throws disabled buyer error") {
                shouldThrow<DisabledBuyerError> {
                    service.getBy(aBuyer.id)
                }
            }
        }

    }
})
