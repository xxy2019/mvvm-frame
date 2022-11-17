package com.example.mvvmdemojava.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.example.mvvmdemojava.data.local.entity.TestEntity;

import java.util.List;

@Dao
public interface TestDao extends BaseDao<TestEntity> {

    @Query("select * from test")
    List<TestEntity> loadAll();
}