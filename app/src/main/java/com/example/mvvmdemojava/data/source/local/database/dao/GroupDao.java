package com.example.mvvmdemojava.data.source.local.database.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.example.mvvmdemojava.data.source.local.database.entity.GroupEntity;

import java.util.List;

@Dao
public interface GroupDao extends BaseDao<GroupEntity> {

    @Query("select * from group_chat")
    List<GroupEntity> loadAll();
}
