package com.wordpress.priyankvex.autohangarandroid.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.models.ServiceCategory;

import java.util.ArrayList;

/**
 * Created by priyank on 13/2/16.
 */
public class CategoriesListAdapter extends ArrayAdapter<ServiceCategory>{

    ArrayList<ServiceCategory> mCategories;
    Context mContext;
    private DisplayImageOptions options;
    private LayoutInflater inflater;

    public CategoriesListAdapter(Context context, ArrayList<ServiceCategory> categories) {
        super(context, 0, categories);
        this.mContext = context;
        this.mCategories = categories;
        inflater = LayoutInflater.from(context);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.maintenance)
                .showImageForEmptyUri(R.drawable.maintenance)
                .showImageOnFail(R.drawable.maintenance)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ServiceCategory category= getItem(position);
        // Using ViewHolder pattern for smooth scrolling
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_category, parent, false);
            mViewHolder.imageViewService = (ImageView) convertView.findViewById(R.id.imageViewService);
            mViewHolder.textViewService = (TextView) convertView.findViewById(R.id.textViewService);
            MaterialRippleLayout.on(mViewHolder.imageViewService)
                    .rippleColor(Color.WHITE)
                    .rippleHover(true)
                    .rippleAlpha(0.2f)
                    .rippleOverlay(true)
                    .create();
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.textViewService.setText(category.getServiceName());
        ImageLoader.getInstance()
                .displayImage("drawable://" + category.getSeriveImageId(), mViewHolder.imageViewService, options);


        return convertView;
    }

    private class ViewHolder{
        TextView textViewService;
        ImageView imageViewService;
    }
}
