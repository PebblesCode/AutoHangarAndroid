package com.wordpress.priyankvex.autohangarandroid;

import java.util.Calendar;

/**
 * Created by @priyankvex on 15/2/16.
 * Class to hold various utility methods.
 */
public class Utilities {

    /**
     * Returns relative time in format of ex 1 hour ago, 2 days age etc
     * @param pastTime past time which needs to be relative to the current time
     * @return string having the relative time in format ex 1 hour ago, 2 days ago etc.
     */
    public static String getRelativeTime(Long pastTime){
        String relativeTime;

        long currentTime  = Calendar.getInstance().getTimeInMillis();
        // time difference in milliseconds
        long timeDifference = currentTime - pastTime;

        int minutesPassed = (int)timeDifference/60000;
        int hoursPassed = minutesPassed/60;
        int daysPassed = hoursPassed/24;

        // We         will check the biggest time unit first

        if (daysPassed != 0){
            // one or more days has passed
            relativeTime= String.valueOf(daysPassed);
            if (daysPassed == 1)
                relativeTime += " day";
            else
                relativeTime += " days";

        }
        else if (hoursPassed != 0){
            // one or more hours has passed
            relativeTime = String.valueOf(hoursPassed);
            if (hoursPassed == 1)
                relativeTime += " hour";
            else
                relativeTime += " hours";
        }
        else{
            // one or more minutes has passed
            relativeTime = String.valueOf(minutesPassed);
            if (minutesPassed == 1)
                relativeTime += " minute";
            else
                relativeTime += " minutes";
        }

        relativeTime += " ago";

        return relativeTime;
    }
}
