package com.example.mvvmdemojava.data.source.local.database.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.mvvmdemojava.data.source.local.database.converter.EntityConverter;

@Entity(tableName = "message")
@TypeConverters(EntityConverter.class)
public class MessageEntity {

    //消息id
    @PrimaryKey
    private long id;

    //消息发送的时间
    private long timestamp;

    //消息标题
    private String title;

    //消息类型，用户自定义消息类型，用于区分图片、视频、文本(image/video/text)等消息
    private String msgAction;

    //消息类容，与action 组合为任何类型消息，content 根据 format 可表示为 text,json ,xml数据格式
    private String content;

    //content 内容格式，可表示为text，json，xml数据格式
    private String format;

    //附加内容，可以看作预留字段
    private String extra;

    //消息发送者账号，存储用户的userid
    private long sender;

    //消息接收者账号，存储用户的userid，如果是群聊消息，接收者信息可以为保存为已读消息人数
    private long receiver;

    //消息的方向，发送或者接收(SEND/RECEIVE)，主要保存在本地，用于界面展示
    private String direct;

    //会话ID，用户查询当前会话对象下的消息列表，如果是单聊，则存储userId，如果是群聊，存储groupId
    private long conversationId;

    //消息是否已读，用于展示
    private Boolean unread;

    //文件消息的下载状态（downing， success， fail）
    private String downStatus;

    public MessageEntity(long id, long timestamp, String title, String msgAction, String content,
                         String format, String extra, long sender, long receiver, String direct,
                        long conversationId, Boolean unread) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.msgAction = msgAction;
        this.content = content;
        this.format = format;
        this.extra = extra;
        this.sender = sender;
        this.receiver = receiver;
        this.direct = direct;
        this.conversationId = conversationId;
        this.unread = unread;
    }
//
//    /**
//     * 将Message解析为MessageEntity
//     * @param message
//     * @return
//     */
//    @Ignore
//    public static MessageEntity parseMessage(Message message, String direct, long conversationId){
//        MessageEntity messageEntity = new MessageEntity(message.getId(), message.getTimestamp(), message.getTitle(),
//                message.getAction(), message.getContent(), message.getFormat(), message.getExtra(), Long.parseLong(message.getSender()),
//                Long.parseLong(message.getReceiver()), direct, conversationId, false);
//        return messageEntity;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsgAction() {
        return msgAction;
    }

    public void setMsgAction(String msgAction) {
        this.msgAction = msgAction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public long getConversationId() {
        return conversationId;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public String getDownStatus() { return downStatus; }

    public void setDownStatus(String downStatus) { this.downStatus = downStatus; }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", title='" + title + '\'' +
                ", msgAction='" + msgAction + '\'' +
                ", content='" + content + '\'' +
                ", format='" + format + '\'' +
                ", extra='" + extra + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", direct='" + direct + '\'' +
                ", conversationId=" + conversationId +
                ", unread=" + unread +
                ", downStatus='" + downStatus + '\'' +
                '}';
    }
}
