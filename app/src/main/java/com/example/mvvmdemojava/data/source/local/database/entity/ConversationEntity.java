package com.example.mvvmdemojava.data.source.local.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.mvvmdemojava.data.source.local.database.converter.EntityConverter;

@Entity(tableName = "conversation")
@TypeConverters(EntityConverter.class)
public class ConversationEntity {

    //会话id，如果是单聊，则存储userId，如果是群聊，存储groupId
    @PrimaryKey
    private long id;

    //会话类型，分为单聊/群聊（single/group/appMessage）
    private String type;

    //会话中未读的消息数量
    private int unreadMsgCount;

    //会话是否置顶
    private Boolean isTopping;

    //会话中最后一条消息的id
    private long lastMsgId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUnreadMsgCount() {
        return unreadMsgCount;
    }

    public void setUnreadMsgCount(int unreadMsgCount) {
        this.unreadMsgCount = unreadMsgCount;
    }

    public Boolean getTopping() {
        return isTopping;
    }

    public void setTopping(Boolean topping) {
        isTopping = topping;
    }

    public long getLastMsgId() {
        return lastMsgId;
    }

    public void setLastMsgId(long lastMsgId) {
        this.lastMsgId = lastMsgId;
    }

    @Override
    public String toString() {
        return "ConversationEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", unreadMsgCount=" + unreadMsgCount +
                ", isTopping=" + isTopping +
                ", lastMsgId=" + lastMsgId +
                '}';
    }
}
