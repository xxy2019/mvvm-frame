package me.goldze.mvvmhabit.binding.viewadapter.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import androidx.databinding.BindingAdapter;
import me.goldze.mvvmhabit.utils.ConvertUtils;

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

    @BindingAdapter(value = {"imgRes"}, requireAll = false)
    public static void setImageRes(ImageView imageView, int imgRes) {
        if(imgRes != -1)
            imageView.setImageResource(imgRes);
        else
            imageView.setImageDrawable(null);
    }

    @BindingAdapter(value = {"imgDraw"}, requireAll = false)
    public static void setImageDraw(ImageView imageView, Drawable imgDraw) {
        if(imgDraw != null)
            imageView.setImageDrawable(imgDraw);
        else
            imageView.setImageDrawable(null);
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

    @BindingAdapter(value = {"videoUrl", "videoPlaceholderRes", "videoUrlSize"}, requireAll = false)
    public static void setVideoUrl(ImageView imageView, String url, int placeholderRes, int urlSize) {
        //使用Glide框架加载视频封面
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(Uri.parse(url))
                //设置固定的  宽高尺寸 单位为像素
                .override(ConvertUtils.dp2px(urlSize))
                .placeholder(placeholderRes)
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(imageView);
    }
}

