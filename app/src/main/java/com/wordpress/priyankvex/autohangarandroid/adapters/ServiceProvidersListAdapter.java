package com.wordpress.priyankvex.autohangarandroid.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.models.ServiceProvider;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 17/2/16.
 */
public class ServiceProvidersListAdapter extends ArrayAdapter<ServiceProvider>{

    private Context mContext;
    private ArrayList<ServiceProvider> mServiceProviders;
    private LayoutInflater inflater;

    public ServiceProvidersListAdapter(Context context, ArrayList<ServiceProvider> serviceProviders){
        super(context, 0, serviceProviders);
        mContext = context;
        mServiceProviders = serviceProviders;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ServiceProvider serviceProvider = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_service_provider, parent, false);
            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.textViewAddress = (TextView) convertView.findViewById(R.id.textViewAddress);
            viewHolder.ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textViewName.setText(serviceProvider.getName());
        viewHolder.textViewAddress.setText(serviceProvider.getAddress());
        viewHolder.ratingBar.setRating(serviceProvider.getRating());

        return convertView;
    }

    private class ViewHolder{
        TextView textViewName;
        TextView textViewAddress;
        RatingBar ratingBar;
    }
}
