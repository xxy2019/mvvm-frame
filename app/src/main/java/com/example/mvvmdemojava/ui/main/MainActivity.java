package com.example.mvvmdemojava.ui.main;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.example.mvvmdemojava.BR;
import com.example.mvvmdemojava.R;
import com.example.mvvmdemojava.data.DemoRepository;
import com.example.mvvmdemojava.data.Injection;
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
        ViewModelFactory<DemoRepository> factory = ViewModelFactory.getInstance(getApplication(), Injection.provideDemoRepository());
        return  new ViewModelProvider(this, factory).get(MainViewModel.class);
    }
}