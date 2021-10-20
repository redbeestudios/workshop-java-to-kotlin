package com.nerdearla.workshop.authorization.mapper;

import com.nerdearla.workshop.authorization.PaymentAuthorization;
import com.nerdearla.workshop.authorization.client.PaymentAuthorizationRequest;
import com.nerdearla.workshop.authorization.client.PaymentAuthorizationResponse;
import com.nerdearla.workshop.operation.PaymentOperation;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMapper {

    public PaymentAuthorizationRequest mapOperationToAuthorizationRequest(PaymentOperation operation) {
        PaymentAuthorizationRequest request = new PaymentAuthorizationRequest();
        request.setPaymentMethodToken(operation.getPaymentMethod().getToken());
        request.setPaymentMethodSecurityCode(operation.getPaymentMethod().getSecurityCode());
        request.setHolderIdentification(operation.getBuyer().getIdentification());
        request.setEstablishmentId(operation.getPaymentRequest().getTerminalData().getEstablishmentId());
        request.setTerminalNumber(operation.getPaymentRequest().getTerminalData().getTerminalNumber());
        request.setTicketNumber(operation.getPaymentRequest().getTerminalData().getTicketNumber());
        request.setTraceNumber(operation.getPaymentRequest().getTerminalData().getTraceNumber());
        request.setTransactionDatetime(operation.getPaymentRequest().getTerminalData().getTraceNumber());
        return request;
    }

    public PaymentAuthorization mapAuthorizationResponseToAuthorization(PaymentAuthorizationResponse response) {
        PaymentAuthorization authorization = new PaymentAuthorization();
        authorization.setId(response.getId());
        authorization.setTraceNumber(response.getTraceNumber());
        authorization.setStatus(response.getStatus());
        return authorization;
    }
}
