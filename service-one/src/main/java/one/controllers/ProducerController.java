package one.controllers;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import one.dto.MessageDTO;
import one.kafka.KafkaProducerService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/producer")
public class ProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public String publish(@RequestBody MessageDTO message) {
        kafkaProducerService.sendMessage("demo-topic", message);
        return "🕊️ Message objet envoyé à Kafka: " + message;
    }
} 
