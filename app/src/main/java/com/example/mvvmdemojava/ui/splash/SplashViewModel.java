package com.example.mvvmdemojava.ui.splash;

import android.app.Application;
import androidx.annotation.NonNull;
import me.goldze.mvvmhabit.base.data.ProxyRepository;
import com.example.mvvmdemojava.ui.main.MainActivity;
import me.goldze.mvvmhabit.base.viewmodel.BaseViewModel;

public class SplashViewModel extends BaseViewModel<ProxyRepository> {

    public SplashViewModel(@NonNull Application application, ProxyRepository repository) {
        super(application, repository);
    }

    /**
     * 启动页结束后的动作
     */
    public void onSplashFinished(){
        startActivity(MainActivity.class);
        finish();
    }
}
