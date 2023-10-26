package me.goldze.mvvmhabit.base;

import android.app.Application;
import androidx.annotation.NonNull;
import me.goldze.mvvmhabit.utils.Utils;
import me.goldze.mvvmhabit.utils.lifecycleManager.LifecycleManager;

/**
 * Created by goldze on 2017/6/15.
 */

public class BaseApplication extends Application {
    private static Application sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
        //注册监听每个activity的生命周期,便于堆栈式管理
        registerActivityLifecycleCallbacks(getLifecycleCallbacks());
    }

    /**
     * 当主工程没有继承BaseApplication时，可以使用setApplication方法初始化BaseApplication
     *
     * @param application
     */
    public static synchronized void setApplication(@NonNull Application application) {
        sInstance = application;
        //初始化工具类
        Utils.init(application);
    }

    /**
     * 获得当前app运行的Application
     */
    public static Application getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("please inherit BaseApplication or call setApplication.");
        }
        return sInstance;
    }

    public LifecycleManager getLifecycleCallbacks() {
        return new LifecycleManager();
    }
}
