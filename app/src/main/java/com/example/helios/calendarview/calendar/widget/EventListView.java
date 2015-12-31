package com.example.helios.calendarview.calendar.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class EventListView extends BaseListView{

    public EventListView(Context context) {
        this(context,null);
    }

    public EventListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EventListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
