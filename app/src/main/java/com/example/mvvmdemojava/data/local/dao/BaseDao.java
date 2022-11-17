package com.example.mvvmdemojava.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T... entityList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<T> entityList);

    @Update
    void update(T... entityList);

    @Delete
    void delete(T... entityList);
}
