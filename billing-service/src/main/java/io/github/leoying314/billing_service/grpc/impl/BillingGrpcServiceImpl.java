package io.github.leoying314.billing_service.grpc.impl;

import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import org.apache.coyote.Response;

@Slf4j
@GrpcService
public class BillingGrpcServiceImpl extends BillingServiceImplBase {

    @Override
    public void createBillingAccount(
            billing.BillingRequest billingRequest,
            StreamObserver<BillingResponse> responseObserver
    ) {
        log.info("createBillingAccount request received {}", billingRequest.toString());

        BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }
}
