package com.wipro.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.wipro.R;

/**
 * Created by Digvijay Singh on 11/5/19.
 */
public class CustomViewBindings {

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            if (imageView.getTag(R.id.imageViewId) == null || !imageView.getTag(R.id.imageViewId).equals(imageUrl)) {
                imageView.setImageBitmap(null);
                imageView.setTag(R.id.imageViewId, imageUrl);
                Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
            }
        } else {
            imageView.setTag(R.id.imageViewId, null);
            imageView.setImageBitmap(null);
        }
    }
    /*@BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }*/
}
