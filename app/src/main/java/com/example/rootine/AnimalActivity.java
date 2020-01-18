package com.example.rootine;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalActivity extends AppCompatActivity {

    private static final String TAG = "AnimalActivity";

    //vars
    private ArrayList<String> animalNames = new ArrayList<>();
    private ArrayList<Integer> animalImages = new ArrayList<>();
    AppManager manager;
    int numAnimals;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Log.d(TAG, "onCreate: started");
        manager = AppManager.getInstance();
        numAnimals = manager.getNumAnimals();
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        animalImages.add(R.mipmap.chicken);
        animalNames.add("Chicken");
        animalImages.add(R.mipmap.kangaroo);
        animalNames.add("Kangaroo");
        animalImages.add(R.mipmap.bee);
        animalNames.add("Bumblebee");
        animalImages.add(R.mipmap.cat);
        animalNames.add("Cat");
        animalImages.add(R.mipmap.horse);
        animalNames.add("Horse");
        animalImages.add(R.mipmap.crab);
        animalNames.add("Crab");
        animalImages.add(R.mipmap.caterpillar);
        animalNames.add("Caterpillar");
        animalImages.add(R.mipmap.dolphin);
        animalNames.add("Dolphin");
        animalImages.add(R.mipmap.duck);
        animalNames.add("Duck");
        animalImages.add(R.mipmap.elephant);
        animalNames.add("Elephant");
        animalImages.add(R.mipmap.falcon);
        animalNames.add("Falcon");
        animalImages.add(R.mipmap.frog);
        animalNames.add("Frog");
        animalImages.add(R.mipmap.gorilla);
        animalNames.add("Gorilla");
        animalImages.add(R.mipmap.mite);
        animalNames.add("Mite");
        animalImages.add(R.mipmap.mosquito);
        animalNames.add("Mosquito");
        animalImages.add(R.mipmap.octopus);
        animalNames.add("Octopus");
        animalImages.add(R.mipmap.pig);
        animalNames.add("Pig");
        animalImages.add(R.mipmap.rabbit);
        animalNames.add("Rabbit");
        animalImages.add(R.mipmap.seahorse);
        animalNames.add("Seahorse");
        animalImages.add(R.mipmap.sheep);
        animalNames.add("Sheep");
        animalImages.add(R.mipmap.snail);
        animalNames.add("Snail");
        animalImages.add(R.mipmap.starfish);
        animalNames.add("Starfish");
        animalImages.add(R.mipmap.turtle);
        animalNames.add("Turtle");
        animalImages.add(R.mipmap.wasp);
        animalNames.add("Wasp");
        animalImages.add(R.mipmap.whale);
        animalNames.add("Whale");

        int totalNumAnimals = animalImages.size();
        //get a sublist equal to the number of animals the user as earned
        if (numAnimals != 0) {
            animalImages.subList((numAnimals - 1), (totalNumAnimals - 1)).clear();
            animalNames.subList((numAnimals - 1), (totalNumAnimals - 1)).clear();
        }else{
            animalImages.clear();
            animalNames.clear();
        }

        initRecyclerView();

        //add images to thing
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(animalNames, animalImages, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
