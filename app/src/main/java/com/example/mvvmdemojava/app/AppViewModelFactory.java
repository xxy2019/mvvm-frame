package com.example.mvvmdemojava.app;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvmdemojava.data.DemoRepository;
import com.example.mvvmdemojava.ui.main.MainViewModel;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, DemoRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(MainViewModel.class)) {
//            return (T) new MainViewModel(mApplication, mRepository);
//        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
