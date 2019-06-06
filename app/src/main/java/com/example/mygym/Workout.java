package com.example.mygym;

public class Workout
{
    //Each wokout has a description
    private String name;
    private String description;

    //Workouts is an array for 4 workouts.
    public static final Workout[] workouts = {new Workout("Chest DumbBell Push-Ups", "10 Forward hand push-ups\n10 side hand Push-ups\n10 reverse hand Push-ups"),
            new Workout("One hand chest push-Ups", "4 Forward hand push-ups\n4 One hand chest push-ups\n20 Knee to ankles plank"),
            new Workout("DumbBell Squats", "10 DumbBell squats\n10 Single Knee Squats\n10 Knee to ankle plank"),
            new Workout("5K Run", "Run for 3.3 miles\nDo 30 Knee to ankle plank\nStretch for 10 minutes"),
            new Workout("10K Run", "Run for 6.3 miles\nDo 30 Knee to ankle plank\nStretch for 10 minutes")};


//Each workout has a name and description
    private Workout(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}