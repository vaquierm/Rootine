package com.example.rootine;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public ImageButton calBtn;
    public ImageButton aniBtn;
    public Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calBtn = (ImageButton) findViewById(R.id.calenderButton);
        this.aniBtn = (ImageButton) findViewById(R.id.animalsButton);
        this.spn = (Spinner) findViewById(R.id.spinner);

        calBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(i);
                }
            }
        );

        aniBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, AnimalActivity.class);
                    startActivity(i);
                }
            }
        );
    }
}
