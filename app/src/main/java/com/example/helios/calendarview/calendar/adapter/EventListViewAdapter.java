package com.example.helios.calendarview.calendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.helios.calendarview.R;
import com.example.helios.calendarview.calendar.bean.CalendarEvent;
import com.example.helios.calendarview.calendar.utils.DateUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.Date;
import java.util.List;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class EventListViewAdapter extends BaseAdapter{

    private static final String TAG = EventListViewAdapter.class.getSimpleName();
    private Context mContext;
    private List<CalendarEvent> mEvents;
    private LayoutInflater mInflater;

    public EventListViewAdapter(Context context, List<CalendarEvent> events) {
        this.mContext = context;
        this.mEvents = events;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return mEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        CalendarEvent event = mEvents.get(position);
        if(convertView == null){
            //note listview ---if parent != null && attachToRoot is true will exception
            convertView = mInflater.inflate(R.layout.event_item_layout,parent,false);
            ViewUtils.inject(this,convertView);
            holder = new ViewHolder();
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        if(event != null){
            holder.contentText.setText(event.getContent());
            String startTime = DateUtil.formatTime(new Date(event.getStartTime()));
            holder.startText.setText(startTime);
            String endTime = DateUtil.formatTime(new Date(event.getStartTime()+event.getDuration()));
            holder.endText.setText(endTime);
        }
        return convertView;
    }

    private final class ViewHolder{
        @ViewInject(R.id.start_time)
        TextView startText;
        @ViewInject(R.id.end_time)
        TextView endText;
        @ViewInject(R.id.content)
        TextView contentText;
    }
}
