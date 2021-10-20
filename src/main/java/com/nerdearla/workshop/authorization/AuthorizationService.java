package com.nerdearla.workshop.authorization;

import com.nerdearla.workshop.authorization.client.AuthorizationClient;
import com.nerdearla.workshop.authorization.client.PaymentAuthorizationRequest;
import com.nerdearla.workshop.authorization.mapper.AuthorizationMapper;
import com.nerdearla.workshop.authorization.validator.PaymentAuthorizationValidator;
import com.nerdearla.workshop.operation.PaymentOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationService.class);

    private final AuthorizationClient client;
    private final PaymentAuthorizationValidator validator;
    private final AuthorizationMapper mapper;

    public AuthorizationService(
            AuthorizationClient client,
            PaymentAuthorizationValidator validator,
            AuthorizationMapper mapper) {
        this.client = client;
        this.validator = validator;
        this.mapper = mapper;
    }

    public PaymentAuthorization authorize(PaymentOperation operation) {
        PaymentAuthorization authorization = mapper
                .mapAuthorizationResponseToAuthorization(
                        client.authorize(mapOperationToRequest(operation)));
        validator.validate(authorization);
        LOGGER.info("Payment authorization validated");
        return authorization;
    }

    private PaymentAuthorizationRequest mapOperationToRequest(PaymentOperation operation) {
        return mapper.mapOperationToAuthorizationRequest(operation);
    }
}
