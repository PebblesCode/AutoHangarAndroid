package com.wordpress.priyankvex.autohangarandroid.seed;

import com.wordpress.priyankvex.autohangarandroid.models.Notification;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by @priyankvex on 15/2/16.
 * Seed class to get dummy notifications.
 * Remove this in development copy.
 */
public class NotificationSeed {

    public static ArrayList<Notification> getNotification(){
        ArrayList<Notification> notifications = new ArrayList<>();
        // Create a dummy notification
        Notification notification = new Notification();
        notification.setTitle("Lorem ipsum dolor sit amet, pri aperiri");
        notification.setBody("Lorem ipsum dolor sit amet, pri aperiri vivendo comprehensam te, everti aperiri pericula at est, probo graeco scripta an mei. Te erant aliquam eam. At sit illum decore saperet");
        Calendar calendar = Calendar.getInstance();
        notification.setTime(calendar.getTimeInMillis() - 123456);
        // add to array
        notifications.add(notification);
        notifications.add(notification);
        notifications.add(notification);
        notifications.add(notification);
        notifications.add(notification);
        return notifications;
    }
}
