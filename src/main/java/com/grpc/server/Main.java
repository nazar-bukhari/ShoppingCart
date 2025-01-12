package com.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Shop.Order order = Shop.Order.newBuilder()
//                .addAllProduct(
//                        Arrays.asList(
//                                newProduct(1, 10, "milk"),
//                                newProduct(2, 15, "egg")
//                        )
//                ).build();
//        System.out.println(order);

        int port = 50051;
        Server server = ServerBuilder.forPort(port).build();
        server.start();
        System.out.println("Server Started");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown");
            server.shutdown();
            System.out.println("Server Stopped");
        }));

        server.awaitTermination();
    }

//    private static Shop.Product newProduct(int id, long price, String name) {
//        return Shop.Product.newBuilder()
//                .setId(id)
//                .setPrice(price)
//                .setName(name)
//                .build();
//    }
}