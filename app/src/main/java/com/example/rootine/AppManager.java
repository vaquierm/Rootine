package com.example.rootine;

import com.applandeo.materialcalendarview.EventDay;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//singleton class that keeps track of the app activity
public class AppManager {

    private static AppManager instance = null;

    private List<EventDay> noMeatDays = new ArrayList<>();

    private Calendar currentDate;

    private int goal;
    private int numAnimals;

    private AppManager(){
        goal = 0;
        //SET THIS TO 0 LATER
        numAnimals = 5;

        this.currentDate = Calendar.getInstance();
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
        this.currentDate.add(Calendar.DATE, 1);
    }

    public List<EventDay> getNoMeatDays() {
        return noMeatDays;
    }
}
