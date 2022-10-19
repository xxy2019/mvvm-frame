package com.example.mvvmdemojava.data.source.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.mvvmdemojava.data.source.local.database.dao.ConversationDao;
import com.example.mvvmdemojava.data.source.local.database.dao.FriendUserDao;
import com.example.mvvmdemojava.data.source.local.database.dao.GroupDao;
import com.example.mvvmdemojava.data.source.local.database.dao.MessageDao;
import com.example.mvvmdemojava.data.source.local.database.entity.ConversationEntity;
import com.example.mvvmdemojava.data.source.local.database.entity.FriendUserEntity;
import com.example.mvvmdemojava.data.source.local.database.entity.GroupEntity;
import com.example.mvvmdemojava.data.source.local.database.entity.MessageEntity;

@Database(entities = {MessageEntity.class, ConversationEntity.class, FriendUserEntity.class,
        GroupEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MessageDao messageDao();

    public abstract ConversationDao conversationDao();

    public abstract FriendUserDao friendUserDao();

    public abstract GroupDao groupDao();
}
