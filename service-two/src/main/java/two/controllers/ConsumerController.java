package two.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import two.entities.Message;
import two.kafka.KafkaConsumerService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consumer")
public class ConsumerController {

    private final KafkaConsumerService kafkaConsumerService;

    @GetMapping
    public List<Message> getMessages() {
        return kafkaConsumerService.getReceivedMessages();
    }
}
