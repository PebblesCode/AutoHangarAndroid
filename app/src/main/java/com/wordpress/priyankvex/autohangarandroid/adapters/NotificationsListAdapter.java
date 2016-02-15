package com.wordpress.priyankvex.autohangarandroid.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.Utilities;
import com.wordpress.priyankvex.autohangarandroid.models.Notification;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 15/2/16.
 * Adapter for notifications list view.
 */
public class NotificationsListAdapter extends ArrayAdapter<Notification>{

    private Context mContext;
    private ArrayList<Notification> mNotifications;
    private LayoutInflater inflater;

    public NotificationsListAdapter(Context context, ArrayList<Notification> notifications){
        super(context, 0, notifications);
        mContext = context;
        mNotifications = notifications;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Notification notification = getItem(position);
        Log.d("test", notification.getTitle());
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_notification, parent, false);
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            viewHolder.textViewBody = (TextView) convertView.findViewById(R.id.textViewBody);
            viewHolder.textViewTime = (TextView) convertView.findViewById(R.id.textViewTime);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textViewTitle.setText(notification.getTitle());
        viewHolder.textViewBody.setText(notification.getBody());
        viewHolder.textViewTime.setText(Utilities.getRelativeTime(notification.getTime()));

        return convertView;
    }

    private class ViewHolder{
        TextView textViewTitle;
        TextView textViewBody;
        TextView textViewTime;
    }
}
