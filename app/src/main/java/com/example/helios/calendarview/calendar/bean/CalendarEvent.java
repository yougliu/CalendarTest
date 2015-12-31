package com.example.helios.calendarview.calendar.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
@DatabaseTable(tableName = "tb_event")
public class CalendarEvent {
    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField(columnName = "content")
    private String content;
    @DatabaseField(columnName = "startTime")
    private long startTime;
    @DatabaseField(columnName = "duration")
    private long duration;
    @DatabaseField(columnName = "curDate")
    private String curDate;
    @DatabaseField(columnName = "repeat")
    private int repeat;
    @DatabaseField(columnName = "recommend")
    private int recommend;
    @DatabaseField(columnName = "location")
    private String location;
    @DatabaseField(columnName = "direction")
    private String direction;
    @DatabaseField(columnName = "staff")
    private String staff;

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }
}
