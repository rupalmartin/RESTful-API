package rupal.ibm.service;

import rupal.ibm.database.DatabaseClass;
import rupal.ibm.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    private static Map<Long, Message> messages;

    public MessageService(){
        messages = DatabaseClass.getMessages();
    }

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values());

    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() +1);
        messages.put(message.getId(),message);
        return message;
    }


    public Message updateMessage(Message message){
        if(message.getId() <=0){
            return null;
        }
        messages.put(message.getId(),message);
        return message;
    }

    public void removeMessage(long id){
         messages.remove(id);
    }
}
