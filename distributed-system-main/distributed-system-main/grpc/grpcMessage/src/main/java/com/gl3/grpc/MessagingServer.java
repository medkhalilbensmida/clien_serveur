package com.gl3.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SuppressWarnings("unused")
public class MessagingServer {
  public static void main(String[] args) throws Exception {
    Server server = ServerBuilder.forPort(50000)
        .addService(new MessagingServiceImpl())
        .build()
        .start();
    System.out.println("Server started, listening on port 50000");
    server.awaitTermination();
  }
}