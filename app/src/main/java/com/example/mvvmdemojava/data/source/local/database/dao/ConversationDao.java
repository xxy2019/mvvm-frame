package com.example.mvvmdemojava.data.source.local.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import com.example.mvvmdemojava.data.source.local.database.entity.ConversationEntity;
import com.example.mvvmdemojava.entity.ConversationInfoEntity;
import java.util.List;

@Dao
public interface ConversationDao extends BaseDao<ConversationEntity>{

    @Query("select conversation.id,type,unreadMsgCount,isTopping," +
            "msgAction as lastMsgAction,timestamp as lastMsgTime," +
            "content as lastMsgContent,nickname,username as conversationName," +
            "avatarUrl,friend_user.id as memberNumber from conversation,message,friend_user " +
            "where conversation.lastMsgId = message.id and conversation.id = friend_user.id union " +
            "select conversation.id,type,unreadMsgCount,isTopping,msgAction as lastMsgAction," +
            "timestamp as lastMsgTime,content as lastMsgContent,nickName,groupName as conversationName," +
            "avatarUrl,memberNumber from conversation,message,group_chat " +
            "where conversation.lastMsgId = message.id and conversation.id = group_chat.id " +
            "ORDER BY timestamp DESC")
    LiveData<List<ConversationInfoEntity>> loadConversation();

    @Query("select * from conversation where id = :id")
    ConversationEntity loadById(long id);

    @Query("update conversation set unreadMsgCount = 0 where id = :id")
    void updateUnReadById(long id);

    @Query("delete from conversation where id = :id")
    void deleteById(long id);

}
