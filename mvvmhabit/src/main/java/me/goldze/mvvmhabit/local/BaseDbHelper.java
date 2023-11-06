package me.goldze.mvvmhabit.local;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.RoomDatabase;

public abstract class BaseDbHelper<T extends RoomDatabase> {

    protected static final String TAG = "BaseDbHelper";
    protected Context mContext;
    protected String currentUser;
    protected T mDatabase;

    protected BaseDbHelper(Context context){
        this.mContext = context.getApplicationContext();
    }

    /**
     * 继承的类需要重写该方法
     * @param user
     * @return
     */
    protected abstract T initDatabase(String user);

    /**
     * 初始化数据库
     * @param user 用户名
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
        mDatabase = initDatabase(user);
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
}
