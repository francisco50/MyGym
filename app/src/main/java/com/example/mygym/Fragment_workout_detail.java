package com.example.mygym;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_workout_detail extends Fragment
{
    //This is the Id the user choose, it will be used to set the value of the fragments views with the workout details
    private long workoutId;


    public Fragment_workout_detail()
    {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_workout_detail, container, false);

    }
    @Override
    //This code will run ones the activity gets online, to make the activity visible
    public void onStart()
    {
        super.onStart();
        // fragments are distinct from activities, and therefore don’t have all the methods that an activity does.
        // Fragments don’t include a findViewById() method, for instance.
        // To get a reference to a fragment’s views, we first have to get a reference to
        // the fragment’s root view using the getView() method, and use that to find its child views
        View view = getView();
        if(view != null)
        {
            TextView title = view.findViewById(R.id.textTitle);
            //we need to initialize or make a method also for workout so as to be able to use it.
            Workout workout = Workout.workouts[(int)workoutId];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescriptions);
            description.setText(workout.getDescription());

        }
    }

    //This is the setter method for the workout ID, the activity will use this method to set the value of the workout ID.
    public void setWorkoutId(long Id)
    {
        this.workoutId = Id;
    }

}
