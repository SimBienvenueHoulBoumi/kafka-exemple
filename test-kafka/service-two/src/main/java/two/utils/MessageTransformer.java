package two.utils;

import org.springframework.stereotype.Component;

import two.dto.MessageDTO;
import two.entities.Message;

@Component
public class MessageTransformer {

    public Message toEntity(MessageDTO dto) {
        return new Message(dto.getTitle(), dto.getContent());
    }
}
