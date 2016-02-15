package com.wordpress.priyankvex.autohangarandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.wordpress.priyankvex.autohangarandroid.R;
import com.wordpress.priyankvex.autohangarandroid.adapters.NotificationsListAdapter;
import com.wordpress.priyankvex.autohangarandroid.models.Notification;
import com.wordpress.priyankvex.autohangarandroid.seed.NotificationSeed;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 14/2/16.
 * Activity to show notifications
 */
public class NotificationsActivity extends AppCompatActivity{

    ListView listViewNotifications;
    ArrayList<Notification> mNotifications;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Notifications");
        }
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        initListView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void initListView(){
        listViewNotifications = (ListView) findViewById(R.id.listViewNotifications);
        mNotifications = NotificationSeed.getNotification();
        NotificationsListAdapter adapter = new NotificationsListAdapter(NotificationsActivity.this,
                mNotifications);
        listViewNotifications.setAdapter(adapter);
    }
}
