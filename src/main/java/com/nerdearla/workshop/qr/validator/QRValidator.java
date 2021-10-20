package com.nerdearla.workshop.qr.validator;

import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.qr.error.DisabledQrError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QRValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRValidator.class);

    public void validate(QR qr) {
        if(!qr.getEnabled()) {
            LOGGER.error("qr {} disabled", qr.getId());
            throw new DisabledQrError();
        }

        LOGGER.info("qr {} is enabled", qr.getId());
    }
}
