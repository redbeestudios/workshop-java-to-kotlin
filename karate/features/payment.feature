# Created by joaco at 15/10/21

Feature: process QR payment

  Scenario: payment

    Given url 'http://localhost:8080'
    And path '/api/payments'
    And header x-api-key = 'dso4UMgSxh6cZx4ZfcW946r1ZpPN6Peu4MkUyHna'
    And header content-type = 'application/json'
    And request
    """
    {
        "qr_id": "13123123141",
        "buyer_identification": "12345678",
        "buyer_id": "1",
        "seller_id": "2",
        "amount": 1000.00,
        "installments": 3,
        "terminal_data": {
            "establishment_id": "010",
            "terminal_number": "03305",
            "trace_number": "111432545",
            "ticket_number": "11340566",
            "transaction_datetime": "2021-09-29T07:36:09+0000"
        },
        "payment_method_data": {
            "token": "dGVzdDEyM2tna2ZrMzExMzQ",
            "security_code": "123"
        }
    }
    """
    When method post
    Then status 201
    And match response contains
    """
    {
      "payment_id": "#string"
    }
    """