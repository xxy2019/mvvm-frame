package com.example.mvvmdemojava.data.local.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.Room;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.mvvmdemojava.data.local.dao.TestDao;

import java.security.spec.EncodedKeySpec;

public class DbHelper{

    private static final String TAG = "DbHelper";
    private static DbHelper instance;
    private Context mContext;
    private String currentUser;
    private AppDatabase mDatabase;
    private Boolean mIsDatabaseCreated = false;

    private DbHelper(Context context){
        this.mContext = context.getApplicationContext();
    }

    public static DbHelper getInstance(Context context) {
        if(instance == null) {
            synchronized (DbHelper.class) {
                if(instance == null) {
                    instance = new DbHelper(context);
                }
            }
        }
        return instance;
    }

    /**
     * 初始化数据库
     * @param user
     */
    public void initDb(String user) {
        if(currentUser != null) {
            if(TextUtils.equals(currentUser, user)) {
                Log.d(TAG, "you have opened the db");
                return;
            }
            closeDb();
        }
        this.currentUser = user;
        String userMd5 = EncryptUtils.encryptMD5ToString(user).toLowerCase();
        // 以下数据库升级设置，为升级数据库将清掉之前的数据，如果要保留数据，慎重采用此种方式
        // 可以采用addMigrations()的方式，进行数据库的升级
        String dbName = String.format("em_%1$s.db", userMd5);
        Log.d(TAG, "db name = "+dbName);
        mDatabase = Room.databaseBuilder(mContext, AppDatabase.class, dbName)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
        mIsDatabaseCreated = true;
    }

    public Boolean getDatabaseCreatedObservable() {
        return mIsDatabaseCreated;
    }

    /**
     * 关闭数据库
     */
    public void closeDb() {
        if(mDatabase != null) {
            mDatabase.close();
            mDatabase = null;
        }
        currentUser = null;
    }

    public TestDao getTestDao() {
        if(mDatabase != null) {
            return mDatabase.testDao();
        }
        return null;
    }
}
