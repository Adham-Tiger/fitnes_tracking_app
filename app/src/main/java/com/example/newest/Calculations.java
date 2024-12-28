package com.example.newest;



// calculating formulas in one place to make it easier
//MET is a factor needed to calculate calories
public class Calculations {
    static double weight=0;


    //calculating calories of walking
    public static double walking_calories(int steps){
        return steps*0.57*weight/1000;
    }
    //calculating calories of running
    public static double running_calories(double distance,double time){

        return time*weight;
    }
    //calculating calories of cycling
    public static double cycling_calories(double distance,double time){
        double MET=0;
        if((distance/time)<16) MET=4;
        else if((distance*0.06/time)>=16 && (distance/time)<19) MET=6;
        else if((distance*0.06/time)>=19 && (distance/time)<22 ) MET=8;
        else if((distance*0.06/time)>=22) MET=10;

        return weight*MET*time/60;
    }

    //calculating calories of swimming
    public static double swimming_calories(double distance,double time){
        double MET=0;
        if(distance*0.06/time<=1)MET=5;
        else if(distance*0.06/time<=3)MET=8;
        else if(distance*0.06/time>3)MET=11;

        return weight*MET*time/60;
    }
    //calculating calories of jumping rope
    public static double jumping_rope_calories(double loops,double time){
        double MET=0;
        if(loops/time<=10)MET=2;
        else if(loops/time<=40)MET=6;
        else if(loops/time>=40)MET=11;
        return weight*MET*time/60;
    }
}
