package com.lccode.localstack_aws.sqs.controller;

import com.lccode.localstack_aws.sqs.producer.SqsProducers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sqs")
@AllArgsConstructor
public class SqsController {

    private final SqsProducers sqsProducers;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String content) {
        sqsProducers.sendMessage(content);
        return ResponseEntity.ok("Message send successfully!");
    }

}
