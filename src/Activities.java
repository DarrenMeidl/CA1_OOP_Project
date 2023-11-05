import java.util.ArrayList;
import java.util.Collections;
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
    public void sortByActivityDurationAscending(){
        Collections.sort(activityList, new ActivityDurationAscendingComparator());
    }


}