package com.example.mygym;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;



public class DetailActivity extends AppCompatActivity
{
    //we are using a constant to pass the ID from mainActivity
    // to DetailActivity to avoid hardcoding
public static final String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //This is a reference to the fragment class, because the fragment is not a view
        // so it must be referenced and called in here, with a method
        Fragment_workout_detail frag = (Fragment_workout_detail)
                //we can create a while statement or a for loop to iterate the workouts or
                // introduce all the workouts on the activity
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //frag.setWorkoutId(1);
        int workoutId = (int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        frag.setWorkoutId(workoutId);
    }
}
