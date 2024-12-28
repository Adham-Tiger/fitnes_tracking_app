package com.example.newest;

public class Records {



             private String days;
             private String calories;
    private String steps;
    private String water;
    private  String sleeping;

    public Records(String days, String calories, String steps, String water, String sleeping) {
        this.days = days;
        this.calories = calories;
        this.steps = steps;
        this.water = water;
        this.sleeping = sleeping;

    }

    public String getDays() {
        return days;
    }

    public String getCalories() {
        return calories;
    }

    public String getSteps() {
        return steps;
    }

    public String getWater() {
        return water;
    }

    public String getSleeping() {
        return sleeping;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public void setSleeping(String sleeping) {
        this.sleeping = sleeping;
    }
}
