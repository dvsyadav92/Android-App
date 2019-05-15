package com.dvs.binding;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.dvs.R;

/**
 * Created by Digvijay Singh on 11/5/19.
 */
public class CustomViewBindings {

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            if (imageView.getTag(R.id.imageViewId) == null || !imageView.getTag(R.id.imageViewId).equals(imageUrl)) {
                imageView.setTag(R.id.imageViewId, imageUrl);
                Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
            }
        } else {
            imageView.setTag(R.id.imageViewId, null);
            imageView.setImageBitmap(null);
        }
    }
}
