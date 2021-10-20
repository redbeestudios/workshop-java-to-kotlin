package com.nerdearla.workshop.payment.service;

import com.nerdearla.workshop.authorization.AuthorizationService;
import com.nerdearla.workshop.authorization.PaymentAuthorization;
import com.nerdearla.workshop.operation.PaymentOperation;
import com.nerdearla.workshop.payment.service.model.Payment;
import com.nerdearla.workshop.payment.provider.PaymentIdProvider;
import com.nerdearla.workshop.payment.repository.PaymentRepository;
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod;
import com.nerdearla.workshop.paymentMethod.PaymentMethodService;
import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.qr.QRService;
import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.buyer.BuyerService;
import com.nerdearla.workshop.user.seller.Seller;
import com.nerdearla.workshop.user.seller.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentIdProvider paymentIdProvider;
    private final PaymentMethodService paymentMethodService;
    private final AuthorizationService authorizationService;
    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final QRService qrService;
    private final PaymentRepository paymentRepository;

    public PaymentService(
            PaymentIdProvider paymentIdProvider,
            PaymentMethodService paymentMethodService,
            AuthorizationService gatewayService,
            BuyerService buyerService,
            SellerService sellerService,
            PaymentRepository paymentRepository,
            QRService qrService
    ) {
        this.paymentIdProvider = paymentIdProvider;
        this.paymentMethodService = paymentMethodService;
        this.authorizationService = gatewayService;
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.paymentRepository = paymentRepository;
        this.qrService = qrService;
    }

    public Payment processPayment(PaymentOperation operation) {
        String id = paymentIdProvider.getNext();
        operation.setPaymentId(id);

        QR qr = qrService.getBy(operation.getPaymentRequest().getQrId());
        operation.setQr(qr);
        LOGGER.info("qr found: {}", qr.toString());

        Buyer buyer = buyerService.findBuyer(operation.getPaymentRequest().getBuyerId());
        operation.setBuyer(buyer);
        LOGGER.info("buyer found: {}", buyer.toString());

        BuyerPaymentMethod buyerPaymentMethod = paymentMethodService.getBy(buyer.getId(), operation.getPaymentRequest().getPaymentMethodData());
        operation.setPaymentMethod(buyerPaymentMethod);
        LOGGER.info("payment method found: {}", buyerPaymentMethod.toString());

        Seller seller = sellerService.findSeller(operation.getPaymentRequest().getSellerId());
        operation.setSeller(seller);
        LOGGER.info("seller found: {}", seller.toString());

        PaymentAuthorization authorization = authorizationService.authorize(operation);
        LOGGER.info("authorization response: {}", authorization.toString());

        Payment payment = new Payment.PaymentBuilder(operation, authorization).build();
        paymentRepository.save(payment);
        LOGGER.info("payment {} saved", payment.getPaymentId());

        return payment;
    }
}
