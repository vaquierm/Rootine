package com.example.rootine;

import com.applandeo.materialcalendarview.EventDay;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

//singleton class that keeps track of the app activity
public class AppManager {

    private static AppManager instance = null;

    private List<EventDay> noMeatDays = new ArrayList<>();

    private Calendar currentDate;

    private int noMeatDaysThisWeek;
    private boolean loggedNoMeatToday;

    private int goal;
    private int numAnimals;

    private AppManager(){
        goal = 2;

        numAnimals = 0;

        this.currentDate = Calendar.getInstance();

        noMeatDaysThisWeek = 0;
        loggedNoMeatToday = false;
    }
    static AppManager getInstance(){
        if (instance == null){
            instance = new AppManager();

        }
        return instance;
    }

    public void setGoal(int goal){
        this.goal = goal;
    }

    public int getGoal(){
        return this.goal;
    }

    public void incNumAnimals(){
        this.numAnimals ++;
    }


    int getNumAnimals(){
        return this.numAnimals;
    }

    public Calendar getCurrentDate(){
        return this.currentDate;
    }

    public void incrementDate() {
        loggedNoMeatToday = false;
        int oldWeek = currentDate.get(Calendar.WEEK_OF_YEAR);

        currentDate.add(Calendar.DATE, 1);

        if (oldWeek != currentDate.get(Calendar.WEEK_OF_YEAR)) {
            noMeatDaysThisWeek = 0;
        }
    }

    public List<EventDay> getNoMeatDays() {
        return noMeatDays;
    }

    public void noMeatToday() {
        if (!loggedNoMeatToday) {
            noMeatDaysThisWeek++;
            loggedNoMeatToday = true;

            if (noMeatDaysThisWeek == goal) {
                numAnimals++;
            }
        }
    }

    private int getCurrentWeek() {
        return this.currentDate.get(Calendar.WEEK_OF_YEAR);
    }

    public int getNoMeatDaysThisWeek() {
        return noMeatDaysThisWeek;
    }

    public boolean getLoggedToday() {
        return this.loggedNoMeatToday;
    }
}
