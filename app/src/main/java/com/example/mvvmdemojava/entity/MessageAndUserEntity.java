package com.example.mvvmdemojava.entity;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.example.mvvmdemojava.data.source.local.database.entity.FriendUserEntity;
import com.example.mvvmdemojava.data.source.local.database.entity.MessageEntity;

public class MessageAndUserEntity {
    @Embedded
    public MessageEntity messageEntity;
    @Relation(
        parentColumn = "sender",
        entityColumn = "id"
    )
    public FriendUserEntity friendUserEntity;

    @Override
    public String toString() {
        return "MessageAndUserEntity{" +
                "messageEntity=" + messageEntity +
                ", userEntity=" + friendUserEntity +
                '}';
    }
}
