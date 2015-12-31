package com.example.helios.calendarview.calendar;

import android.app.Application;
import android.content.Context;

import com.example.helios.calendarview.R;
import com.example.helios.calendarview.calendar.db.DatabaseHelper;

import cn.qqtheme.framework.popup.Popup;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class BaseApplication extends Application{

    private Context context;
    private DatabaseHelper mHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mHelper = DatabaseHelper.getInstance(context);
        Popup.setAnimation(R.style.Animation_Popup);
    }
}
