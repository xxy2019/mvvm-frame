package com.example.mvvmdemojava.data.source.local.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import com.example.mvvmdemojava.data.source.local.database.entity.FriendUserEntity;

import java.util.List;

@Dao
public interface FriendUserDao extends BaseDao<FriendUserEntity>{

    @Query("update friend_user set userType = :userType where id = :id")
    void updateUserTypeById(String userType, long id);

    @Query("delete from friend_user where userType != 'apply' and userType != 'operate' and userType != 'refused'")
    void deleteAll();

    @Query("delete from friend_user where id = :id")
    void deleteById(long id);

    @Query("select * from friend_user where userType != 'apply' and userType != 'operate' and userType != 'refused'")
    LiveData<List<FriendUserEntity>> loadAll();

    @Query("select * from friend_user where userType = 'operate'")
    LiveData<List<FriendUserEntity>> loadOperateFriend();

    @Query("select * from friend_user where id = :id")
    FriendUserEntity loadById(long id);

}
