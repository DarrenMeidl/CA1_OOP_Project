import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Activities Container Class
public class Activities {
    ArrayList<Activity> activityList; //ArrayList field called activityList - Darren
    public Activities(){ this.activityList = new ArrayList<>(); } //Sets this activityList field to a new ArrayList

    //Prints the arraylist, some fields purposely excluded - Darren
    public void printList(){
        System.out.printf("%17s%17s%17s%17s%17s%17s\n", "ACTIVITY TYPE", "DURATION", "DATE", "DISTANCE", "AVG HEART RATE", "CALS BURNED");
        for (int i = 0; i < activityList.size(); i++){
            System.out.printf("%17s%17f%17s%17f%17f%17f\n",  activityList.get(i).getType(),activityList.get(i).getDuration(), activityList.get(i).getDate(), activityList.get(i).getDistance(), activityList.get(i).getAvgHeartRate(), activityList.get(i).getCaloriesBurned());
        }
    }
    //Adds object to activityList method - Darren
    public void add(Activity act){
        activityList.add(act);
    }
    //Sort method - Darren
    public void sort(){
        Collections.sort(activityList); //Sorts by natural ordering - Darren
    }
    public void sortByCaloriesBurnedDescending(){
        Collections.sort(activityList, new CaloriesBurnedDescendingComparator());
    }

    //ACTIVITY DURATION
    public void sortByActivityDurationAscending(){
        Collections.sort(activityList, new ActivityDurationAscendingComparator());
    }
    public void sortByActivityDurationDescending(){
        Collections.sort(activityList, new ActivityDurationDescendingComparator());
    }

    //DATE
    public void sortByActivityDateAscending(){
        Collections.sort(activityList, new Comparator<Activity>() { //Sorts by using Anonymous Inner Class - Tomas
            @Override
            public int compare(Activity act1, Activity act2) {
                return act1.getDate().compareTo((act2).getDate());
            }
        });
    }
    public void sortByActivityDateDescending(){
        Collections.sort(activityList, new ActivityDateDescendingComparator());
    }

    public void sortByActivityType() {
        Collections.sort(activityList, new Comparator<Activity>() { //Sorts by using Anonymous Inner Class - Tomas
            @Override
            public int compare(Activity act1, Activity act2) {
                return act1.getType().compareTo(act2.getType());
            }
        });
    }

    //DISTANCE
    public void sortByActivityDistanceAscending(){
        activityList.sort((Activity act1, Activity act2) -> Double.compare(act1.getDistance(), act2.getDistance())); //Sorts using lambda where arraylist implements the list interface
    }
    public void sortByActivityDistanceDescending(){
        activityList.sort((act1, act2) -> Double.compare(act2.getDistance(), act1.getDistance())); //Using the same logic as previous lambda comparator, but descending order
    }


    //VIEW SUBSET: ACTIVITY TYPE
    public void viewByActivityType(String input){
        System.out.printf("%17s%17s%17s%17s%17s%17s\n", "ACTIVITY TYPE", "DURATION", "DATE", "DISTANCE", "AVG HEART RATE", "CALS BURNED");
        for (int i = 0; i < activityList.size(); i++){
            if (activityList.get(i).getType().equalsIgnoreCase(input)){ //If strings are the same, print the current activity object in arraylist - Darren
                System.out.printf("%17s%17f%17s%17f%17f%17f\n",  activityList.get(i).getType(),activityList.get(i).getDuration(), activityList.get(i).getDate(), activityList.get(i).getDistance(), activityList.get(i).getAvgHeartRate(), activityList.get(i).getCaloriesBurned());
            }
        }
    }

    //VIEW SUBSET: ABOVE MINIMUM ACTIVITY DISTANCE
    public void viewByActivityDistance(double input){
        System.out.printf("%17s%17s%17s%17s%17s%17s\n", "ACTIVITY TYPE", "DURATION", "DATE", "DISTANCE", "AVG HEART RATE", "CALS BURNED");
        for (int i = 0; i < activityList.size(); i++){
            if (activityList.get(i).getDistance() > input){ //If current object distance is greater than minimum input double, print the current activity object in arraylist - Darren
                System.out.printf("%17s%17f%17s%17f%17f%17f\n",  activityList.get(i).getType(),activityList.get(i).getDuration(), activityList.get(i).getDate(), activityList.get(i).getDistance(), activityList.get(i).getAvgHeartRate(), activityList.get(i).getCaloriesBurned());
            }
        }
    }

    //VIEW SUBSET: ACTIVITY ENERGY EXPENDED TYPE
    public void viewByActivityIntensityType(String input){
        System.out.printf("%17s%17s%17s%17s%17s%17s\n", "ACTIVITY TYPE", "DURATION", "DATE", "DISTANCE", "AVG HEART RATE", "CALS BURNED");
        for (int i = 0; i < activityList.size(); i++){
            activityList.get(i).calculateIntensityType();
            if (activityList.get(i).getIntensityType().equalsIgnoreCase(input)){ //If strings are the same, print the current activity object in arraylist - Darren
                System.out.printf("%17s%17f%17s%17f%17f%17f\n",  activityList.get(i).getType(),activityList.get(i).getDuration(), activityList.get(i).getDate(), activityList.get(i).getDistance(), activityList.get(i).getAvgHeartRate(), activityList.get(i).getCaloriesBurned());
            }
            /*else {
                System.out.println("SKIPPED THIS ACTIVITY"); //Testing Purposes, if object doesn't match type it won't get printed - Darren
            }*/
        }
    }

    //VIEW SUBSET: ABOVE MINIMUM ACTIVITY DURATION
    public void viewByActivityDuration(double input){
        System.out.printf("%17s%17s%17s%17s%17s%17s\n", "ACTIVITY TYPE", "DURATION", "DATE", "DISTANCE", "AVG HEART RATE", "CALS BURNED");
        for (int i = 0; i < activityList.size(); i++){
            if (activityList.get(i).getDuration() > input){ //If current object duration is greater than minimum input double, print the current activity object in arraylist - Darren
                System.out.printf("%17s%17f%17s%17f%17f%17f\n",  activityList.get(i).getType(),activityList.get(i).getDuration(), activityList.get(i).getDate(), activityList.get(i).getDistance(), activityList.get(i).getAvgHeartRate(), activityList.get(i).getCaloriesBurned());
            }
        }
    }

    //VIEW STATISTICS: AVERAGE DISTANCE PER ACTIVITY


    //VIEW STATISTICS: AVERAGE CALORIES BURNED
    public double calculateAverageCaloriesBurned(){
        double calTotal = 0;
        double avgCalBurned = 0;
        for (int i = 0; i < activityList.size(); i++){
            calTotal = (calTotal + activityList.get(i).getCaloriesBurned());
        }
        avgCalBurned = (calTotal/activityList.size());
        return avgCalBurned;
    }

}