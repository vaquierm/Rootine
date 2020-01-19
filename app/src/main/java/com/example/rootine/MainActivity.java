package com.example.rootine;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public ImageButton calBtn;
    public ImageButton aniBtn;
    public Spinner spn;
    public AppManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        this.calBtn = (ImageButton) findViewById(R.id.calenderButton);
        this.aniBtn = (ImageButton) findViewById(R.id.animalsButton);
        this.spn = (Spinner) findViewById(R.id.spinner);
        this.manager = AppManager.getInstance();

        calBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    updateGoal();
                    Intent i = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(i);
                }
            }
        );

        aniBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    updateGoal();
                    Intent i = new Intent(MainActivity.this, AnimalActivity.class);
                    startActivity(i);
                }
            }
        );

    }

    private void updateGoal(){
        String spinnerContents = spn.getSelectedItem().toString();
        int goal = Integer.parseInt(spinnerContents);
        manager.setGoal(goal);
    }

}
