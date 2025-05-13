package two.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import two.dto.MessageDTO;
import two.entities.Message;
import two.utils.MessageStore;
import two.utils.MessageTransformer;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final MessageTransformer transformer;
    private final MessageStore messageStore;

    public KafkaConsumerService(MessageTransformer transformer, MessageStore messageStore) {
        this.transformer = transformer;
        this.messageStore = messageStore;
    }

    @KafkaListener(topics = "demo-topic", groupId = "group-service-two")
    public void consume(MessageDTO messageDTO) {
        logger.info("📥 Objet reçu: {}", messageDTO);
        messageStore.storeDTO(messageDTO);

        Message message = transformer.toEntity(messageDTO);
        messageStore.storeEntity(message);
    }
}
