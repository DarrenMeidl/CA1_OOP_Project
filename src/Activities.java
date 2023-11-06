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


}