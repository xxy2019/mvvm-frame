package me.goldze.mvvmhabit.base.viewmodel;


import androidx.annotation.NonNull;

/**
 * ItemViewModel
 */
public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
