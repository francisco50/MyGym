package com.example.mygym;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment
{

//define the interface listener to respond to item clicked.
    //we want any activity that will implement the listener interface to respond to clicks
    //This method contains only one Id of the item that was clicked
   interface Listener
    {
        void itemClicked(long id);
    }
    //add the listener to the fragment

    private Listener listener;
//the code here creates a basic list fragment, amd since it is a list, iy needs to extend ListFragment
    @Override
    //this onCreateView is optional as it is created only when the fragment starts.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
            String [] names = new String[Workout.workouts.length];

            for(int i= 0; i < names.length ; i++)
            {
                names[i] = Workout.workouts[i].getName();
            }
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
                    setListAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //This gets called when a fragment gets attached to any activity.
    //the activity class is a subclass of context
    //This method also registers the listener.
    //This is the context in this case (The activity) the fragment is attached to it
    @Override
    public void onAttach(Context context)
    {
           super.onAttach(context);
           this.listener=(Listener)context;

    }

    //Before the itemClicked gets called, this method gets called first when an item is clicked.
    //with the item's position, the itemView and Id passed.
    //since it tasked an Id, we can pass the listener Id here.
    public void onListItemClick(ListView listView, View itemView,int position, long id)
    {
        if(listener != null)
        {
            //tell the listener when an item is the ListView gets clicked.
            listener.itemClicked(id);
        }

    }



}
