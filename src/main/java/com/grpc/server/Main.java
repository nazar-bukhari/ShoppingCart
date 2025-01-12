package com.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 50051;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new ShopServerImpl())
                .build();
        server.start();
        System.out.println("Server Started");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown");
            server.shutdown();
            System.out.println("Server Stopped");
        }));

        server.awaitTermination();
    }
}