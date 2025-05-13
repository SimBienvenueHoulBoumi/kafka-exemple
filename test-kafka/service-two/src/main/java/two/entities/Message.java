package two.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Message {

    public Message(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
    }

    @Id
    private String id;
    private String title;
    private String content;
}
