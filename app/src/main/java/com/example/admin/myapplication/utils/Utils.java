package com.example.admin.myapplication.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

public class Utils {

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    public static  boolean isAppOnForeground(Context  mContext) {
        ActivityManager activityManager = (ActivityManager)mContext.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = mContext.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

}
