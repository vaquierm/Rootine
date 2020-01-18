package com.example.rootine;

//singleton class that keeps track of the app activity
public class AppManager {

    private static AppManager instance = null;

    private int goal;

    private AppManager(){

    }
    public AppManager getInstance(){
        if (instance == null){
            instance = new AppManager();
            goal = 0;
        }
        return instance;
    }

    public void setGoal(int goal){
        this.goal = goal;
    }

    public int getGoal(){
        return this.goal;
    }
}
