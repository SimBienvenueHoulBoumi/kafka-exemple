package two.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import two.entities.Message;
import two.utils.MessageStore;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consumer")
public class ConsumerController {

    private final MessageStore messageStore;

    @GetMapping
    public List<Message> getMessages() {
        return messageStore.getReceivedMessages();
    }
}
