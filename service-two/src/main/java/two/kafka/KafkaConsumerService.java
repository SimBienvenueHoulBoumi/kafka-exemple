package two.kafka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import two.dto.MessageDTO;
import two.entities.Message;

@Service
public class KafkaConsumerService {

    private final List<Message> receivedMessages = new ArrayList<>();
    private final List<MessageDTO> receivedMessageDTOs = new ArrayList<>();

    @KafkaListener(topics = "demo-topic", groupId = "group-service-two")
    public void consume(MessageDTO messageDTO) {
        System.out.println("📥 Objet reçu: " + messageDTO);

        synchronized (receivedMessageDTOs) {
            receivedMessageDTOs.add(messageDTO);
        }

        Message message = new Message(messageDTO.getTitle(), messageDTO.getContent());

        synchronized (receivedMessages) {
            receivedMessages.add(message);
        }
    }

    public List<Message> getReceivedMessages() {
        synchronized (receivedMessages) {
            return new ArrayList<>(receivedMessages);
        }
    }

}
