package me.goldze.mvvmhabit.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * 常用工具类
 */
public final class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("should be initialized in application");
    }

    /**
     * 释放图片资源
     *
     * @param view 控件
     */
    public static void recycleBackground(View view) {
        Drawable d = view.getBackground();
        //别忘了把背景设为null，避免onDraw刷新背景时候出现used a recycled bitmap错误
        view.setBackgroundResource(0);
        if (d != null && d instanceof BitmapDrawable) {
            Bitmap bmp = ((BitmapDrawable) d).getBitmap();
            if (bmp != null && !bmp.isRecycled()) {
                bmp.recycle();
            }
        }
        if (d != null) {
            d.setCallback(null);
        }
    }

    /**
     * View设备背景
     *
     * @param view    控件
     * @param resId   资源id
     */
    public static void setBackground(View view, int resId) {
        if (view == null) {
            return;
        }
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), resId);
        BitmapDrawable bd = new BitmapDrawable(context.getResources(), bm);
        view.setBackground(bd);
    }

    /**
     * 检查是否为空指针
     *
     * @param object
     * @param hint
     */
    public static void checkNull(Object object, String hint) {
        if (null == object) {
            throw new NullPointerException(hint);
        }
    }

    /**
     * 检查是否为空指针
     *
     * @param t
     * @param message
     */
    public static <T> T checkNotNull(T t, String message) {
        if (t == null) {
            throw new NullPointerException(message);
        }
        return t;
    }
}