package com.example.mvvmdemojava.data.source.local.database.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.mvvmdemojava.data.source.local.database.entity.MessageEntity;
import com.example.mvvmdemojava.entity.MessageAndUserEntity;

import java.util.List;

@Dao
public interface MessageDao extends BaseDao<MessageEntity>{

    @Transaction
    @Query("SELECT * FROM message where conversationId = :conversationId ORDER BY timestamp ASC limit :pageSize offset :offset")
    List<MessageAndUserEntity> loadByConversationId(int pageSize, int offset, long conversationId);

    @Transaction
    @Query("select * from message where id = :id")
    MessageAndUserEntity loadById(long id);

    @Query("select extra from message where msgAction = :msgAction and downStatus = 'success'")
    List<String> loadByMsgAction(String msgAction);

    @Query("SELECT COUNT(*) FROM message where conversationId = :conversationId")
    int messagesByDateAndConversationIdPageCount(long conversationId);

    @Query("delete from message where conversationId = :conversationId")
    void deleteByConversationId(long conversationId);

    @Query("update message set unread = 'false' where conversationId = :conversationId")
    void updateUnreadByConversationId(long conversationId);

}
