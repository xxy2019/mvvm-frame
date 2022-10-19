package com.example.mvvmdemojava.ui.main;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.example.mvvmdemojava.entity.FormEntity;
import com.example.mvvmdemojava.ui.form.FormFragment;
import com.example.mvvmdemojava.ui.network.NetWorkFragment;
import com.example.mvvmdemojava.ui.rv_multi.MultiRecycleViewFragment;
import com.example.mvvmdemojava.ui.tab_bar.activity.TabBarActivity;
import com.example.mvvmdemojava.ui.viewpager.activity.ViewPagerActivity;
import com.example.mvvmdemojava.ui.vp_frg.ViewPagerGroupFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * Created by goldze on 2017/7/17.
 */

public class DemoViewModel extends BaseViewModel {
    //使用Observable
    public SingleLiveEvent<Boolean> requestCameraPermissions = new SingleLiveEvent<>();
    //使用LiveData
    public SingleLiveEvent<String> loadUrlEvent = new SingleLiveEvent<>();

    public DemoViewModel(@NonNull Application application) {
        super(application);
    }

    //网络访问点击事件
    public BindingCommand netWorkClick = new BindingCommand(() ->
            startContainerActivity(NetWorkFragment.class.getCanonicalName()));
    //RecycleView多布局
    public BindingCommand rvMultiClick = new BindingCommand(() ->
            startContainerActivity(MultiRecycleViewFragment.class.getCanonicalName()));
    //进入TabBarActivity
    public BindingCommand startTabBarClick = new BindingCommand(() ->
            startActivity(TabBarActivity.class));
    //ViewPager绑定
    public BindingCommand viewPagerBindingClick = new BindingCommand(() ->
            startActivity(ViewPagerActivity.class));
    //ViewPager+Fragment
    public BindingCommand viewPagerGroupBindingClick = new BindingCommand(() ->
            startContainerActivity(ViewPagerGroupFragment.class.getCanonicalName()));
    //表单提交点击事件
    public BindingCommand formSbmClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(FormFragment.class.getCanonicalName());
        }
    });
    //表单修改点击事件
    public BindingCommand formModifyClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //模拟一个修改的实体数据
            FormEntity entity = new FormEntity();
            entity.setId("12345678");
            entity.setName("goldze");
            entity.setSex("1");
            entity.setBir("xxxx年xx月xx日");
            entity.setMarry(true);
            //传入实体数据
            Bundle mBundle = new Bundle();
            mBundle.putParcelable("entity", entity);
            startContainerActivity(FormFragment.class.getCanonicalName(), mBundle);
        }
    });
    //权限申请
    public BindingCommand permissionsClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            requestCameraPermissions.call();
        }
    });

    //全局异常捕获
    public BindingCommand exceptionClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //伪造一个异常
            Integer.parseInt("goldze");
        }
    });
    //文件下载
    public BindingCommand fileDownLoadClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadUrlEvent.setValue("http://gdown.baidu.com/data/wisegame/dc8a46540c7960a2/baidushoujizhushou_16798087.apk");
        }
    });
}
