import java.util.*;

public class ChatRoom {
    private List<Message> messages;

    public ChatRoom() {
        this.messages = new ArrayList<>();
    }

    public synchronized void addMessage(Message message) {
        messages.add(message);
    }

    public synchronized List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }
}
