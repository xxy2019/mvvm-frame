package me.goldze.mvvmhabit.base.viewmodel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import me.goldze.mvvmhabit.R;
import me.goldze.mvvmhabit.utils.Utils;

public class EmptyItemViewModel<VM extends BaseViewModel> extends MultiItemViewModel<VM> {

    //无数据图片
    public ObservableField<Integer> noDataImg = new ObservableField<>(R.drawable.ic_no_data);
    //提示信息
    public ObservableField<String> content = new ObservableField<>(Utils.getContext().getString(R.string.empty_item_content));

    public void setText(String text) {
       content.set(text);
    }

    public void setImg(Integer imgRes){noDataImg.set(imgRes);}

    public EmptyItemViewModel(@NonNull VM viewModel) {
        super(viewModel);
    }
}
