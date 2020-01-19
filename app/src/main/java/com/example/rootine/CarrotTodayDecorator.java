package com.example.rootine;

import android.app.Activity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.List;

public class CarrotTodayDecorator implements DayViewDecorator {

    private Activity activity;

    public CarrotTodayDecorator(Activity activity){
        this.activity = activity;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        if(!day.equals(CalendarDay.from(AppManager.getInstance().getCurrentDate()))) {
            return false;
        }

        List<Calendar> meatlessDays = AppManager.getInstance().getNoMeatDays();

        for (Calendar d : meatlessDays){
            if (day.equals(CalendarDay.from(d))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(activity.getResources().getDrawable( R.mipmap.carrot_back ));
    }
}
