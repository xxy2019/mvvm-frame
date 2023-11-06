/*
 * Copyright 2014-2017 Eduard Ereza Martínez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.goldze.mvvmhabit.crash;

import android.app.Activity;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Modifier;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CrashConfig implements Serializable {

    @IntDef({BACKGROUND_MODE_CRASH, BACKGROUND_MODE_SHOW_CUSTOM, BACKGROUND_MODE_SILENT})
    @Retention(RetentionPolicy.SOURCE)
    private @interface BackgroundMode {
        //I hate empty blocks
    }

    public static final int BACKGROUND_MODE_SILENT = 0;
    public static final int BACKGROUND_MODE_SHOW_CUSTOM = 1;
    public static final int BACKGROUND_MODE_CRASH = 2;

    private int backgroundMode = BACKGROUND_MODE_SHOW_CUSTOM;
    private boolean enabled = true;
    private boolean showErrorDetails = true;
    private boolean showRestartButton = true;
    private boolean trackActivities = false;
    private int minTimeBetweenCrashesMs = 3000;
    private Integer errorDrawable = null;
    private Class<? extends Activity> errorActivityClass = null;
    private Class<? extends Activity> restartActivityClass = null;
    private CustomActivityOnCrash.EventListener eventListener = null;

    @BackgroundMode
    public int getBackgroundMode() {
        return backgroundMode;
    }

    public void setBackgroundMode(@BackgroundMode int backgroundMode) {
        this.backgroundMode = backgroundMode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isShowErrorDetails() {
        return showErrorDetails;
    }

    public void setShowErrorDetails(boolean showErrorDetails) {
        this.showErrorDetails = showErrorDetails;
    }

    public boolean isShowRestartButton() {
        return showRestartButton;
    }

    public void setShowRestartButton(boolean showRestartButton) {
        this.showRestartButton = showRestartButton;
    }

    public boolean isTrackActivities() {
        return trackActivities;
    }

    public void setTrackActivities(boolean trackActivities) {
        this.trackActivities = trackActivities;
    }

    public int getMinTimeBetweenCrashesMs() {
        return minTimeBetweenCrashesMs;
    }

    public void setMinTimeBetweenCrashesMs(int minTimeBetweenCrashesMs) {
        this.minTimeBetweenCrashesMs = minTimeBetweenCrashesMs;
    }

    @Nullable
    @DrawableRes
    public Integer getErrorDrawable() {
        return errorDrawable;
    }

    public void setErrorDrawable(@Nullable @DrawableRes Integer errorDrawable) {
        this.errorDrawable = errorDrawable;
    }

    @Nullable
    public Class<? extends Activity> getErrorActivityClass() {
        return errorActivityClass;
    }

    public void setErrorActivityClass(@Nullable Class<? extends Activity> errorActivityClass) {
        this.errorActivityClass = errorActivityClass;
    }

    @Nullable
    public Class<? extends Activity> getRestartActivityClass() {
        return restartActivityClass;
    }

    public void setRestartActivityClass(@Nullable Class<? extends Activity> restartActivityClass) {
        this.restartActivityClass = restartActivityClass;
    }

    @Nullable
    public CustomActivityOnCrash.EventListener getEventListener() {
        return eventListener;
    }

    public void setEventListener(@Nullable CustomActivityOnCrash.EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public static class Builder {
        private CrashConfig config;

        @NonNull
        public static Builder create() {
            Builder builder = new Builder();
            CrashConfig currentConfig = CustomActivityOnCrash.getConfig();

            CrashConfig config = new CrashConfig();
            config.backgroundMode = currentConfig.backgroundMode;
            config.enabled = currentConfig.enabled;
            config.showErrorDetails = currentConfig.showErrorDetails;
            config.showRestartButton = currentConfig.showRestartButton;
            config.trackActivities = currentConfig.trackActivities;
            config.minTimeBetweenCrashesMs = currentConfig.minTimeBetweenCrashesMs;
            config.errorDrawable = currentConfig.errorDrawable;
            config.errorActivityClass = currentConfig.errorActivityClass;
            config.restartActivityClass = currentConfig.restartActivityClass;
            config.eventListener = currentConfig.eventListener;

            builder.config = config;

            return builder;
        }

        /**
         * 此方法定义当应用程序在后台崩溃时是否应启动错误活动。有以下三种模式：
         * BackgroundMode.BACKGROUND_MODE_SHOW_CUSTOM: 即使应用程序处于后台，也会启动错误活动。
         * BackgroundMode.BACKGROUND_MODE_CRASH: 应用程序在后台时启动默认系统错误。
         * BackgroundMode.BACKGROUND_MODE_SILENT: 当应用程序在后台运行时，会悄无声息地崩溃。
         * 默认为BackgroundMode.BACKGROUND_MODE_SHOW_CUSTOM
         */
        @NonNull
        public Builder backgroundMode(@BackgroundMode int backgroundMode) {
            config.backgroundMode = backgroundMode;
            return this;
        }

        /**
         * 定义是否启用 CustomActivityOnCrash 崩溃拦截机制
         * 如果您希望 CustomActivityOnCrash 拦截崩溃设置为true
         * false或者希望将它们视为未安装库，请将其设置为false
         * 这可用于根据风格或构建类型启用或禁用库，默认为true
         */
        @NonNull
        public Builder enabled(boolean enabled) {
            config.enabled = enabled;
            return this;
        }

        /**
         * 此方法定义错误活动是否必须显示包含错误详细信息的按钮。
         * 如果将其设置为false，则默认错误活动上的按钮将消失，从而使用户无法查看堆栈跟踪。默认为true.
         */
        @NonNull
        public Builder showErrorDetails(boolean showErrorDetails) {
            config.showErrorDetails = showErrorDetails;
            return this;
        }

        /**
         * 此方法定义错误活动是否必须显示“重新启动应用程序”按钮或“关闭应用程序”按钮。
         * 如果将其设置为false，则默认错误活动上的按钮将关闭应用程序而不是重新启动。
         * 如果您将其设置为true并且您的应用程序没有启动活动，它仍然会显示“关闭应用程序”按钮！
         * 默认为true.
         */
        @NonNull
        public Builder showRestartButton(boolean showRestartButton) {
            config.showRestartButton = showRestartButton;
            return this;
        }

        /**
         * 此方法定义库是否必须跟踪用户访问的活动及其生命周期调用。
         * 这作为错误详细信息的一部分显示在默认错误活动上。默认为false.
         */
        @NonNull
        public Builder trackActivities(boolean trackActivities) {
            config.trackActivities = trackActivities;
            return this;
        }

        /**
         * 定义应用程序崩溃之间必须经过的时间，以确定我们不处于崩溃循环中。
         * 如果发生的崩溃少于此时间，则不会启动错误活动，并且将调用系统崩溃屏幕。默认为3000.
         */
        @NonNull
        public Builder minTimeBetweenCrashesMs(int minTimeBetweenCrashesMs) {
            config.minTimeBetweenCrashesMs = minTimeBetweenCrashesMs;
            return this;
        }

        /**
         * 此方法允许使用您选择的图像更改默认的颠倒错误图像。
         * 您可以传递可绘制对象或 mipmap 的资源 ID。默认值是null（使用错误图像）
         */
        @NonNull
        public Builder errorDrawable(@Nullable @DrawableRes Integer errorDrawable) {
            config.errorDrawable = errorDrawable;
            return this;
        }

        /**
         * 此方法允许您设置要启动的自定义错误活动，而不是默认活动。
         * 如果您需要进一步的自定义，而不仅仅是字符串、颜色或主题（见下文），请使用它。
         * 如果您不设置它（或将其设置为 null），则库将使用清单上第一个具有带有 action 的意图过滤器的活动，
         * 如果没有，则使用库中的默认 cat.ereza.customactivityoncrash.ERROR错误活动。
         * 如果您使用此功能，则必须在您的 中声明该活动AndroidManifest.xml，并将process其设置为:error_activity。
         */
        @NonNull
        public Builder errorActivity(@Nullable Class<? extends Activity> errorActivityClass) {
            config.errorActivityClass = errorActivityClass;
            return this;
        }

        /**
         * 此方法设置当用户按下按钮重新启动应用程序时必须由错误活动启动的活动。
         * 如果您不设置它（或将其设置为 null），库将使用清单上第一个具有带有 action 的意图过滤器的活动，
         * 如果没有，则使用 cat.ereza.customactivityoncrash.RESTART应用程序上的默认可启动活动。
         * 如果找不到可启动的活动并且您没有指定任何活动，则“重新启动应用程序”按钮将变成“关闭应用程序”按钮，即使showRestartButton设置为true。
         */
        @NonNull
        public Builder restartActivity(@Nullable Class<? extends Activity> restartActivityClass) {
            config.restartActivityClass = restartActivityClass;
            return this;
        }

        /**
         * 此方法允许您指定事件侦听器，以便在库显示错误活动、重新启动或关闭应用程序时收到通知。
         * 您提供的EventListener不能是匿名或非静态内部类，因为它需要由库序列化。
         * 如果您尝试设置无效的类，库将引发异常。
         * 如果将其设置为null，则不会调用任何事件侦听器。默认为null.
         *
         * @param eventListener The event listener.
         * @throws IllegalArgumentException if the eventListener is an inner or anonymous class
         */
        @NonNull
        public Builder eventListener(@Nullable CustomActivityOnCrash.EventListener eventListener) {
            if (eventListener != null && eventListener.getClass().getEnclosingClass() != null && !Modifier.isStatic(eventListener.getClass().getModifiers())) {
                throw new IllegalArgumentException("The event listener cannot be an inner or anonymous class, because it will need to be serialized. Change it to a class of its own, or make it a static inner class.");
            } else {
                config.eventListener = eventListener;
            }
            return this;
        }

        @NonNull
        public CrashConfig get() {
            return config;
        }

        public void apply() {
            CustomActivityOnCrash.setConfig(config);
        }
    }


}
