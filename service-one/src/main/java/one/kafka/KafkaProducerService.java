package one.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import one.dto.MessageDTO;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, MessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, MessageDTO message) {
        kafkaTemplate.send(topic, message);
        System.out.println("✅ Message objet envoyé au topic: " + message);
    }
}
