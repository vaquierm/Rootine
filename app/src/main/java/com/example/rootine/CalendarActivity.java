package com.example.rootine;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    private TextView daysLeftText;
    private MaterialCalendarView calendarView;

    private AppManager manager = AppManager.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Calendar");

        daysLeftText = findViewById(R.id.daysLeftText);

        updateTextBox();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (manager.getLoggedToday()) {
                    displayMessage(view, "You already logged your entry today! You have to wait till tomorrow");
                    return;
                }

                // Alert the manager that no meat was eaten today
                manager.noMeatToday();

                if (manager.getNoMeatDaysThisWeek() == manager.getGoal()) {
                    displayMessage(view, "You reached your goal! Go find your new animal in your wildlife reserve!");
                }

                // Display how many noMeatDays left
                updateTextBox();

                Calendar managerDate = manager.getCurrentDate();

                Calendar today = Calendar.getInstance();
                today.set(managerDate.get(Calendar.YEAR), managerDate.get(Calendar.MONTH), managerDate.get(Calendar.DATE));

                // Add today as a no meat day
                manager.getNoMeatDays().add(today);

                refreshDecorators();
            }
        });

        FloatingActionButton next_day = findViewById(R.id.next_day);
        next_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.incrementDate();
                updateTextBox();

                refreshDecorators();
            }
        });

        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);

        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_NONE);

        refreshDecorators();
    }

    public void displayMessage(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private void updateTextBox() {
        String message = "Meatless days this week: " + manager.getNoMeatDaysThisWeek() + "\n";

        int goal = manager.getGoal();
        int noMeatThisWeek = manager.getNoMeatDaysThisWeek();

        if (goal == noMeatThisWeek) {
            message += "You reached yor goal this week!";
        }
        else if (goal > noMeatThisWeek) {
            message += (goal - noMeatThisWeek) + " meatless day" + ((goal - noMeatThisWeek == 1) ? "" : "s") + " left this week!";
        }
        else {
            message += "Wow! You went over your goal by " + (noMeatThisWeek - goal) + " day" + ((noMeatThisWeek - goal == 1) ? "" : "s") + " this week!";
        }

        daysLeftText.setText(message);
    }

    private void refreshDecorators() {
        calendarView.removeDecorators();
        calendarView.addDecorator(new CurrentDayDecorator());
        calendarView.addDecorator(new CarrotDecorator(this));
        calendarView.addDecorator(new CarrotTodayDecorator(this));
    }
}
