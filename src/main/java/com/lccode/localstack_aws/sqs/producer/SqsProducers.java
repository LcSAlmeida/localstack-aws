package com.lccode.localstack_aws.sqs.producer;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsProducers {

    private final SqsTemplate sqsTemplate;

    private static final String SQS_QUEUE_NAME = "first-queue";

    public void sendMessage(String content) {
        sqsTemplate.send(SQS_QUEUE_NAME, content);
    }
}
