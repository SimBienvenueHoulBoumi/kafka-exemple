package two.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import two.dto.MessageDTO;
import two.entities.Message;

@Component
public class MessageStore {

    private final List<Message> receivedMessages = new ArrayList<>();
    private final List<MessageDTO> receivedMessageDTOs = new ArrayList<>();

    public synchronized void storeDTO(MessageDTO dto) {
        receivedMessageDTOs.add(dto);
    }

    public synchronized void storeEntity(Message entity) {
        receivedMessages.add(entity);
    }

    public synchronized List<Message> getReceivedMessages() {
        return new ArrayList<>(receivedMessages);
    }

    public synchronized List<MessageDTO> getReceivedMessageDTOs() {
        return new ArrayList<>(receivedMessageDTOs);
    }
}
