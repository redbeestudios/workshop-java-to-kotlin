# Workshop

`POST` /v1/payments

```json
{
  "qrId": "1312312314klsdfs1",
  "buyerIdentification": "12345678",
  "buyerGender": "M",
  "buyerId": "1",
  "sellerId": "2",
  "amount": 1000.00,
  "installments": 3,
  "terminalData": {
    "establishmentId": "010",
    "terminalNumber": "03305",
    "traceNumber": "666186ff-39bb-4e30-8574-d11f27bb7b69",
    "ticketNumber": "11340566",
    "transactionDatetime": "2021-09-29T07:36:09+0000"
  },
  "paymentMethodData": {
    "token": "dGVzdDEyM2tna2ZrMzExMzQ",
    "securityCode": "123"
  }
}
```
