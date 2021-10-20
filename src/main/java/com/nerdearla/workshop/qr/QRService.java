package com.nerdearla.workshop.qr;

import com.nerdearla.workshop.qr.client.QRClient;
import com.nerdearla.workshop.qr.validator.QRValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QRService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRService.class);

    private final QRClient client;
    private final QRValidator validator;

    public QRService(QRClient qrClient, QRValidator validator) {
        this.client = qrClient;
        this.validator = validator;
    }

    public QR getBy(String qrId) {
        QR qr = client.getById(qrId);
        LOGGER.info("qr found: {}", qr.toString());
        validator.validate(qr);
        LOGGER.info("qr {} validated", qr.getId());
        return qr;
    }
}
