package com.example.mvvmdemojava.binding.titlebar;

import androidx.databinding.BindingAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by goldze on 2017/6/16.
 */

public class ViewAdapter {
    /**
     * @param bindingCommand //绑定监听
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"testTitle"}, requireAll = false)
    public static void setTestTitle(final TitleBar titleBar, final BindingCommand<Boolean> bindingCommand) {
        titleBar.setCenterClickListener(view ->
                bindingCommand.execute());
    }

    @BindingAdapter(value = {"testLeft"}, requireAll = false)
    public static void setTestLeft(final TitleBar titleBar, final BindingCommand<Boolean> bindingCommand) {
        titleBar.setLeftClickListener(view ->
                bindingCommand.execute());
    }
}
