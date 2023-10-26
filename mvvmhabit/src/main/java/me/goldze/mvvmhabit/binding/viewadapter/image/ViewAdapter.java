package me.goldze.mvvmhabit.binding.viewadapter.image;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.othershe.combinebitmap.CombineBitmap;
import com.othershe.combinebitmap.layout.WechatLayoutManager;
import androidx.databinding.BindingAdapter;
import me.goldze.mvvmhabit.utils.ConvertUtils;

/**
 * Created by goldze on 2017/6/18.
 */
public final class ViewAdapter {
    @BindingAdapter(value = {"url", "placeholderRes", "urlSize"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String url, int placeholderRes, int urlSize) {
        //使用Glide框架加载图片
        Glide.with(imageView.getContext())
                .load(url)
                //设置固定的  宽高尺寸 单位为像素
                .override(ConvertUtils.dp2px(urlSize))
                .placeholder(placeholderRes)
                .into(imageView);
    }

    @BindingAdapter(value = {"imgBitmap"}, requireAll = false)
    public static void setImageBitmap(ImageView imageView, Bitmap imgBitmap) {
        if(imgBitmap != null)
            imageView.setImageBitmap(imgBitmap);
        else
            imageView.setImageDrawable(null);
    }

    @BindingAdapter(value = {"urls", "placeholderResList"}, requireAll = false)
    public static void setImgUrls(ImageView imageView, String[] urls, int placeholderResList) {
        if(urls != null){
            CombineBitmap.init(imageView.getContext())
                    .setLayoutManager(new WechatLayoutManager()) // 必选， 设置图片的组合形式，支持 WechatLayoutManager、DingLayoutManager
                    .setSize(50) // 必选，组合后 Bitmap 的尺寸，单位 dp
                    .setUrls(urls) // 要加载的图片 url 数组
                    .setPlaceholder(placeholderResList)
                    .setImageView(imageView) // 直接设置要显示图片的 ImageView
                    .build();
        }else{
            imageView.setImageDrawable(imageView.getContext().getDrawable(placeholderResList));
        }
    }

    @BindingAdapter(value = {"avatarUrl", "avatarPlaceholderRes", "otherPlaceholderRes"}, requireAll = false)
    public static void setAvatarUrl(ImageView imageView, String avatarUrl, int avatarPlaceholderRes, int otherPlaceholderRes) {
        if(avatarUrl != null && avatarUrl.equals("showIconMore")){
            imageView.setImageDrawable(imageView.getContext().getDrawable(otherPlaceholderRes));
        }else{
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(avatarUrl)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .apply(new RequestOptions().override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL))
                    .placeholder(avatarPlaceholderRes)
                    .into(imageView);
        }
    }
}

