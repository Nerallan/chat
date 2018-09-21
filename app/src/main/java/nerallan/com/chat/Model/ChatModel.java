package nerallan.com.chat.Model;

/**
 * Created by Nerallan on 7/2/2018.
 */

public class ChatModel {
    private String message;
    private String userName;
    private String userId;
    private String messageTime;


    public ChatModel(String message, String userName, String userId, String messageTime) {
        this.message = message;
        this.userName = userName;
        this.userId = userId;
        this.messageTime = messageTime;
    }

    public ChatModel(){}

    public String getMessageText() {
        return message;
    }

    public void setMessageText(String text) {
        this.message = message;
    }

    public String getMessageUser() {
        return userName;
    }

    public void setMessageUser(String userName) {
        this.userName = userName;
    }

    public String getMessageUserId() {
        return userId;
    }

    public void setMessageUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
