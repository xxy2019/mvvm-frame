package me.goldze.mvvmhabit.utils.lifecycleManager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * 专门用于维护声明周期
 */
public class LifecycleManager implements Application.ActivityLifecycleCallbacks{

    private String TAG = "LifecycleManager";

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.e(TAG, "onActivityCreated " + activity.getLocalClassName());
        AppManager.getAppManager().addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e(TAG, "onActivityStarted " + activity.getLocalClassName());
        AppManager.getAppManager(). addResumeActivity(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.e(TAG, "onActivityResumed" + activity.getLocalClassName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e(TAG, "onActivityPaused " + activity.getLocalClassName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e(TAG, "onActivityStopped " + activity.getLocalClassName());
        AppManager.getAppManager().removeResumeActivity(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.e(TAG, "onActivitySaveInstanceState " + activity.getLocalClassName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG, "onActivityDestroyed " + activity.getLocalClassName());
        AppManager.getAppManager().removeActivity(activity);
    }
}
