package com.grpc.client;

import com.proto.shop.OrderRequest;
import com.proto.shop.OrderResponse;
import com.proto.shop.OrderServiceGrpc;
import com.proto.shop.Product;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ShopClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);
        Product product = Product.newBuilder()
                .setId(1)
                .setName("Laptop")
                .setPrice(100000)
                .build();
        OrderRequest request = OrderRequest.newBuilder()
                .setId(1)
                .setProduct(product)
                .build();
        OrderResponse response = stub.placeOrder(request);
        System.out.println("Got Response: "+ response);
        System.out.println("Shutting Down");
        channel.shutdown();
    }
}
