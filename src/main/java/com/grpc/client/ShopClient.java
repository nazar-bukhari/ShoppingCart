package com.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ShopClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Shutting Down");
        channel.shutdown();
    }
}
