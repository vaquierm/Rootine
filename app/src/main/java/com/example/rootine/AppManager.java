package com.example.rootine;

//singleton class that keeps track of the app activity
public class AppManager {

    private static AppManager instance = null;

    private int goal;
    private int numAnimals;

    private AppManager(){
        goal = 0;
        //SET THIS TO 0 LATER
        numAnimals = 0;
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

}
