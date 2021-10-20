package com.nerdearla.workshop.payment;

import com.nerdearla.workshop.operation.PaymentOperation;
import com.nerdearla.workshop.payment.mapper.PaymentResponseMapper;
import com.nerdearla.workshop.payment.service.model.Payment;
import com.nerdearla.workshop.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("payments")
public class PaymentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsController.class);

    private final PaymentService paymentsService;
    private final PaymentResponseMapper paymentResponseMapper;

    public PaymentsController(PaymentService paymentsService, PaymentResponseMapper paymentResponseMapper) {
        this.paymentsService = paymentsService;
        this.paymentResponseMapper = paymentResponseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse processPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        PaymentOperation operation = new PaymentOperation(paymentRequest);
        return mapToResponse(process(operation));
    }

    private Payment process(PaymentOperation operation) {
        Payment payment = paymentsService.processPayment(operation);
        LOGGER.info("payment processed {}", payment.toString());
        return payment;
    }

    private PaymentResponse mapToResponse(Payment payment) {
        PaymentResponse paymentResponse = paymentResponseMapper.map(payment);
        LOGGER.info("payment response {}", payment);
        return paymentResponse;
    }
}
