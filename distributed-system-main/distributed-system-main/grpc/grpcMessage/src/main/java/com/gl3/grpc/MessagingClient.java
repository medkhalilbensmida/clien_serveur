package com.gl3.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import com.gl3.messaging.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SuppressWarnings("unused")
public class MessagingClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50000)
        .usePlaintext()
        .build();
    MessagingServiceGrpc.MessagingServiceBlockingStub stub = MessagingServiceGrpc.newBlockingStub(channel);

   
    MessagingServiceOuterClass.SendMessageRequest sendRequest = MessagingServiceOuterClass.SendMessageRequest.newBuilder()
        .setRecipient("user1")
        .setMessage("Hello, user1!")
        .build();
    MessagingServiceOuterClass.SendMessageResponse sendResponse = stub.sendMessage(sendRequest);
    System.out.println("Message sent: " + sendResponse.getSuccess());

 
    MessagingServiceOuterClass.GetMessagesRequest getRequest = MessagingServiceOuterClass.GetMessagesRequest.newBuilder()
        .setUser("user1")
        .build();
    MessagingServiceOuterClass.GetMessagesResponse getResponse = stub.getMessages(getRequest);
    System.out.println("Messages for user1: " + getResponse.getMessagesList());

    channel.shutdown();
  }
}