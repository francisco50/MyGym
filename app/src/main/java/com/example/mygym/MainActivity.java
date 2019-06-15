package com.example.mygym;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements  WorkoutListFragment.Listener
{

    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }



    //This gets called to inflate the menu, adds items that has been
    // added to the menu_main resource file to the appBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //get a reference to the share action and assign it to the private variable. Then call the setShareActionIntent() method.
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("What's up Bro ? ");
        return super.onCreateOptionsMenu(menu);


    }

    //it creates an intent and passes it to the share action provider using setShareIntent() method.
    private void setShareActionIntent(String text)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    //gets the item from the appBar that was clicked and starts the activity to add a new workout
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_create_workout:
                Intent intent = new Intent(this, CreateWorkout.class);
                startActivity(intent);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    //This method defines the interface , so we need to implement it.
    //pass the Id of the workout to DetailActivity
    //Extra Id is the contact in DetailActivity
    @Override
    public void itemClicked(long id)
    {
        //get reference to the frame layout that will contain workoutDetailFragment,
        // this will run only on devices with large screens
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null)
        {
            Fragment_workout_detail details = new Fragment_workout_detail();
            //starts the fragment transaction
            FragmentTransaction fragT = getSupportFragmentManager().beginTransaction();
            details.setWorkoutId(id);
           //each time the user clicks on a workout, we'll replace the fragment with a new instance of it
           fragT.replace(R.id.fragment_container, details);
           //Set Fragment to fade in and Out
           fragT.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
           fragT.addToBackStack(null);
           fragT.commit();

        }
        else
            {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }

    }
}
