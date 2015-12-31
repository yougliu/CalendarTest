package com.example.helios.calendarview.calendar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;

/**
 * Created by Bonus Liu on 12/30/15.
 * email : wumumawl@163.com
 */
public class BaseActivity extends Activity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    private LayoutInflater mInflater;
    protected PopupWindow mPopups;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = LayoutInflater.from(this);
    }

    /**
     * 关闭输入法
     */
    public void closeInputMethod(){
        View view = getWindow().peekDecorView();
        if(view != null){
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    /**
     * dialog
     * @param layoutId
     * @param style
     */
    protected void showDialog(int layoutId,int style){

    }

    /**
     * show popupwindow ----- bottom
     * @param layoutView
     * @param height
     */
    protected void showPopup(View layoutView,int height){
        if(height == 0){
            height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
        mPopups = new PopupWindow(layoutView, ViewGroup.LayoutParams.MATCH_PARENT,height);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        mPopups.setBackgroundDrawable(dw);
        mPopups.setOutsideTouchable(true);
        mPopups.setFocusable(true);
        mPopups.showAtLocation(this.findViewById(android.R.id.content), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
    }

    /**
     * show drop down dropDownId
     * @param layoutView
     * @param width
     * @param height
     * @param dropDownId
     */
    protected void showPopup(View layoutView,View anchor,int width,int height,int dropDownId,int xOff,int yOff){
        mPopups = new PopupWindow(layoutView,width,height);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        mPopups.setBackgroundDrawable(dw);
        mPopups.setOutsideTouchable(true);
        mPopups.setFocusable(true);
        int xPos = anchor.getWidth()/2 - mPopups.getWidth()/2;
        mPopups.showAsDropDown(anchor,xPos,yOff);
    }

    protected void showPopup(int layoutId,View anchor,int width,int height,int dropDownId,int xOff,int yOff){
        View view = mInflater.inflate(layoutId,null);
        showPopup(view,anchor,width,height,dropDownId,xOff,yOff);
    }


    /**
     * @param layoutId
     * @param height
     */
    public void showPopup(int layoutId,int height){
        View view = mInflater.inflate(layoutId,null);
        showPopup(view,height);
    }


}
