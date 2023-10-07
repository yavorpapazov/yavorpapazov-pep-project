package Service;
import Model.Message;
import DAO.MessageDAO;
import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message addMessage(Message message) {
        if(message.getMessage_text() == "" || message.getMessage_text().length() >= 255) {
            return null;
        } else {
            return messageDAO.insertMessage(message);
        } 
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageById(int message_id) {
        return messageDAO.getMessageById(message_id);
    }

    public int deleteMessageById(int message_id) {
        return messageDAO.deleteMessageById(message_id);
    }

    public Message updateMessage(int message_id, Message message){
        if(message.getMessage_text() == "" || message.getMessage_text().length() >= 255) {
            return null;
        } else if(messageDAO.getMessageById(message_id) != null) {
            messageDAO.updateMessage(message_id, message);
            return messageDAO.getMessageById(message_id);
        }
        return null;
    }
}
