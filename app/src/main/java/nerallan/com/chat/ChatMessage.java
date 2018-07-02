package nerallan.com.chat;

/**
 * Created by Nerallan on 7/2/2018.
 */

public class ChatMessage {
    private String messageText;
    private String messageUser;
    private String messageUserId;
    private String messageTime;


    public ChatMessage(String messageText, String messageUser, String messageUserId, String messageTime) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageUserId = messageUserId;
        this.messageTime = messageTime;
    }

    public ChatMessage(){}

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(String messageUserId) {
        this.messageUserId = messageUserId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
