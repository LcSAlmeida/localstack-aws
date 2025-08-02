package com.lccode.localstack_aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
public class SqsConfig {

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        //Localstack configuration for messaging
        return SqsAsyncClient.builder()
                .endpointOverride(URI.create("https://localhost.localstack.cloud:4566"))
                .region(Region.US_EAST_1)
                .build();
    }

    @Bean
    public SqsClient sqsClient() {
        //Localstack configuration for queue creation
        return SqsClient.builder()
                .endpointOverride(URI.create("https://localhost.localstack.cloud:4566"))
                .region(Region.US_EAST_1)
                .build();
    }
}
