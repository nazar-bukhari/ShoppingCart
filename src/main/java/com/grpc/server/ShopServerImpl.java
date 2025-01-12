package com.grpc.server;

import com.proto.shop.OrderRequest;
import com.proto.shop.OrderResponse;
import com.proto.shop.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ShopServerImpl extends OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void placeOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {

        responseObserver.onNext(OrderResponse.newBuilder()
                .setOrderId(1)
                .setStatus(3)
                .build());
        responseObserver.onCompleted();

    }
}
