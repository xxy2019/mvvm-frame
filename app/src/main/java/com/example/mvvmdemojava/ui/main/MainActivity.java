package com.example.mvvmdemojava.ui.main;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvmdemojava.BR;
import com.example.mvvmdemojava.R;
import me.goldze.mvvmhabit.base.data.ProxyRepository;
import com.example.mvvmdemojava.databinding.ActivityMainBinding;
import me.goldze.mvvmhabit.base.activity.BaseActivity;
import me.goldze.mvvmhabit.base.data.ViewModelFactory;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        ViewModelFactory<ProxyRepository> factory = ViewModelFactory.getInstance(getApplication(), ProxyRepository.getInstance());
        return  new ViewModelProvider(this, factory).get(MainViewModel.class);
    }
}