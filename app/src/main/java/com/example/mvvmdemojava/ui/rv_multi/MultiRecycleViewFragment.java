package com.example.mvvmdemojava.ui.rv_multi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.example.mvvmdemojava.BR;
import com.example.mvvmdemojava.R;
import com.example.mvvmdemojava.databinding.FragmentMultiRvBinding;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：RecycleView多布局实现
 */

public class MultiRecycleViewFragment extends BaseFragment<FragmentMultiRvBinding, MultiRecycleViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_multi_rv;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
