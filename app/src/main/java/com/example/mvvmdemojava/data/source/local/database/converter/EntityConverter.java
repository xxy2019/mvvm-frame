package com.example.mvvmdemojava.data.source.local.database.converter;


import androidx.room.TypeConverter;

public class EntityConverter {

    //String与Boolean的互转
    @TypeConverter
    public static String toSting(Boolean res){
        return res ? "true" : "false";
    }

    @TypeConverter
    public static Boolean toBoolean(String res){
        return res.equalsIgnoreCase("true");
    }
}
