package com.sisw.alexpopa.clientgrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Alex Daniel Popa
 */
public class GrpcChannelFactory {

    private ManagedChannel channel;

    public GrpcChannelFactory(String host, int port) throws InterruptedException {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public GrpcChannelFactory(ManagedChannelBuilder<?> channelBuilder) throws InterruptedException {
        channel = channelBuilder.build();
    }

    public ManagedChannel getChannel() {
        return channel;
    }
}
