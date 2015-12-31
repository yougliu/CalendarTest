package com.example.helios.calendarview.calendar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.helios.calendarview.calendar.bean.CalendarEvent;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DB_NAME = "calendar.db";
    private static final int DB_VERSION = 1;
    //单例
    private static DatabaseHelper mInstance;
    private Map<String,Dao> maps = new HashMap<>();

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, CalendarEvent.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,CalendarEvent.class,false);
            TableUtils.createTable(connectionSource,CalendarEvent.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 此处尽量使用application context，防止内存泄漏
     * 采用double check
     * @param context
     * @return
     */
    public static DatabaseHelper getInstance(Context context){
        if(mInstance == null){
            synchronized (DatabaseHelper.class){
                if(mInstance == null){
                    mInstance = new DatabaseHelper(context);
                }
            }
        }
        return mInstance;
    }

    public synchronized Dao getDao(Class clazz){
        Dao dao = null;
        String className = clazz.getSimpleName();
        if(maps.containsKey(className)){
            dao = maps.get(className);
        }else{
            try {
                dao = super.getDao(clazz);
                maps.put(className,dao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : maps.keySet()){
            Dao dao = maps.get(key);
            dao = null;
        }
    }
}
