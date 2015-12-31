package com.example.helios.calendarview.calendar.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helios.calendarview.R;
import com.example.helios.calendarview.calendar.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class CreateEventActivity extends BaseActivity {

    private static final String TAG = CreateEventActivity.class.getSimpleName();
    @ViewInject(R.id.id_back)
    private TextView mBack;
    @ViewInject(R.id.id_title)
    private TextView mTitle;
    @ViewInject(R.id.id_right)
    private TextView mRight;
    @ViewInject(R.id.id_content)
    private EditText content;
    @ViewInject(R.id.id_date)
    private TextView date;
    @ViewInject(R.id.id_time)
    private TextView time;
    @ViewInject(R.id.id_duration)
    private TextView duration;
    @ViewInject(R.id.id_repeat)
    private TextView repeat;
    @ViewInject(R.id.id_recommend)
    private TextView recommend;
    @ViewInject(R.id.id_location)
    private EditText location;
    @ViewInject(R.id.id_direction)
    private EditText direction;
    @ViewInject(R.id.id_staff)
    private EditText staff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_layout);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.id_back,R.id.id_right,R.id.id_content,R.id.id_date,R.id.id_time,
    R.id.id_duration,R.id.id_repeat,R.id.id_recommend,R.id.id_location,R.id.id_direction,R.id.id_staff})
    public void onTestButton(View view){
        int id = view.getId();
        switch (id){
            case R.id.id_date:
                break;
            case R.id.id_time:
                break;
            case R.id.id_duration:
//                showPopup(R.layout.popup_dialog_layout, ViewGroup.LayoutParams.WRAP_CONTENT);
                showPopup(R.layout.popup_dialog_layout,duration,400,250,R.id.id_duration,0,10);
                break;
            case R.id.id_repeat:
                break;
            case R.id.id_recommend:
                break;
        }
    }
}
