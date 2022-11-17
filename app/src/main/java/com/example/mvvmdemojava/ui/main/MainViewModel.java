package com.example.mvvmdemojava.ui.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.goldze.mvvmhabit.utils.lifecycleManager.AppManager;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint("CheckResult")
    public BindingCommand testClickCommand = new BindingCommand(() -> {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) AppManager.getAppManager().currentActivity());
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(aBoolean -> {
            if (aBoolean) {
                ToastUtils.showShort("权限已经打开");
            } else {
                ToastUtils.showShort("权限被拒绝");
            }
        });
    });

    public BindingCommand testClickCommand1 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Log.d("TagTest", "标题");
        }
    });

    public BindingCommand testClickCommand2 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Log.d("TagTest", "左边");
        }
    });
}
