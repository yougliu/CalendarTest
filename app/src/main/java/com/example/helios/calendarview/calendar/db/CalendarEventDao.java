package com.example.helios.calendarview.calendar.db;

import com.example.helios.calendarview.calendar.bean.CalendarEvent;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class CalendarEventDao {

    private static final String TAG = CalendarEventDao.class.getSimpleName();
    private DatabaseHelper mHelper;//application
    private Dao<CalendarEvent,Integer> mDaoOpera;

    public CalendarEventDao(DatabaseHelper helper) {
        this.mHelper = helper;
        mDaoOpera = mHelper.getDao(CalendarEvent.class);
    }

    /**
     * 插入数据
     * @param event
     * @return
     */
    public int addEvent(CalendarEvent event){
        if(event != null){
            return -1;
        }
        try {
            int i = mDaoOpera.create(event);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询所有
     */
    public List<CalendarEvent> queryEvent(){
        try {
            List<CalendarEvent> events = mDaoOpera.queryForAll();
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CalendarEvent> queryDateEvent(String date){
        List<CalendarEvent> events = null;
        try {
            events = mDaoOpera.queryBuilder().where().eq("curDate", date).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    /**
     * 删除一条记录，返回1,表示操作成功
     * @param event
     * @return
     */
    public int deleteEvent(CalendarEvent event){
        int i = 0;
        try {
            i = mDaoOpera.delete(event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 根据对应id进行更改
     * @param event
     * @return
     */
    public int updateEvent(CalendarEvent event){
        int i = 0;
        try {
            i = mDaoOpera.update(event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
