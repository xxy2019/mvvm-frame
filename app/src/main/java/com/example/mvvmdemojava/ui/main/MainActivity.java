package com.example.mvvmdemojava.ui.main;

import android.os.Bundle;
import com.example.mvvmdemojava.BR;
import com.example.mvvmdemojava.R;
import com.example.mvvmdemojava.databinding.ActivityMainBinding;
import me.goldze.mvvmhabit.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}