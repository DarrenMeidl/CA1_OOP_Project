import java.time.LocalDate;
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
    //SORT: NATURAL ORDERING - Darren
    public void sort(){
        Collections.sort(activityList); //Sorts by natural ordering - Darren
    }


    //SORT: CALORIES BURNED
    public void sortByCaloriesBurnedDescending(){
        Collections.sort(activityList, new CaloriesBurnedDescendingComparator());
    }
    //SORT: ACTIVITY DURATION
    public void sortByActivityDurationAscending(){
        Collections.sort(activityList, new ActivityDurationAscendingComparator());
    }
    public void sortByActivityDurationDescending(){
        Comparator<Activity> comparator = (act1, act2) -> Double.compare(act1.getDuration(), act2.getDuration()); //Lambda comparator with reverse helper
        activityList.sort(comparator.reversed());
    }
    //SORT: ACTIVITY DATE
    public void sortByActivityDateAscending(){
        Collections.sort(activityList, new Comparator<Activity>() { //Sorts by using Anonymous Inner Class - Tomas
            @Override
            public int compare(Activity act1, Activity act2) {
                return act1.getDate().compareTo((act2).getDate());
            }
        });
    }
    public void sortByActivityDateDescending(){
        activityList.sort(Activity::compareDateDescending);
    }
    //SORT: ACTIVITY TYPE
    public void sortByActivityType() {
        Collections.sort(activityList, new ActivityTypeComparator());
    }
    //SORT: DISTANCE
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
    public void calculateAverageDistancePerActivity() {
        //Fields
        double totalSwimDistance = 0;
        double totalRunningDistance = 0;
        double totalCyclingDistance = 0;
        double avgDistanceSwim = 0;
        double avgDistanceRun = 0;
        double avgDistanceCycle = 0;
        int listSizeSwim = 0;
        int listSizeRun = 0;
        int listSizeCycle = 0;

        //Calculates Average for Swimming activities
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).getType().equalsIgnoreCase("Swimming")) { //Ignores capital letters when getting String
                totalSwimDistance = (totalSwimDistance + activityList.get(i).getDistance()); //Gathers number from each instance from the for loop and calculates total
                listSizeSwim++; //Calculates the number of instances in each activity
            }
        }
        avgDistanceSwim = totalSwimDistance / listSizeSwim;
        //Calculates Average for Running activities
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).getType().equalsIgnoreCase("Running")) {
                totalRunningDistance = (totalRunningDistance + activityList.get(i).getDistance());
                listSizeRun++;
            }
        }
        avgDistanceRun = totalRunningDistance / listSizeRun;
        //Calculates Average for Cycling activities
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).getType().equalsIgnoreCase("Cycling")) {
                totalCyclingDistance = (totalCyclingDistance + activityList.get(i).getDistance());
                listSizeCycle++;
            }
        }
        avgDistanceCycle = totalCyclingDistance / listSizeCycle;
        //Prints results
        System.out.printf("AVERAGE DISTANCE IN SWIMMING ACTIVITY IS: %.3f\n", avgDistanceSwim);
        System.out.printf("AVERAGE DISTANCE IN RUNNING ACTIVITY IS: %.3f\n", avgDistanceRun);
        System.out.printf("AVERAGE DISTANCE IN CYCLING ACTIVITY IS: %.3f\n", avgDistanceCycle);
    }
    //VIEW STATISTICS: AVERAGE CALORIES BURNED
    public void calculateAverageCaloriesBurned(){
        double calTotal = 0;
        double avgCalBurned = 0;
        for (int i = 0; i < activityList.size(); i++){
            calTotal = (calTotal + activityList.get(i).getCaloriesBurned());
        }
        avgCalBurned = (calTotal/activityList.size());
        System.out.printf("AVERAGE CALORIES BURNED ACROSS ALL ACTIVITIES %.3f", avgCalBurned);
    }


    /*//BINARY SEARCH METHOD
    public int binarySearchByActivityType(Activity key) { //Method for binary search which is called in the main app and requires a key to be found
        return Collections.binarySearch(activityList, key); //Binary search is searching through the activitylist, tries to find the key and uses the ActivityTypeComparator to compare it
    }*/

    public int binarySearchByDate(LocalDate searchDate) {
        //Comparator<Activity> comparator = (act1, act2) -> act1.getDate().compareTo(searchDate);
        Activity key = new Activity("", 0, searchDate, 0, 0); //Set up the key with a value user wants to find
        return Collections.binarySearch(activityList, key); //Start binary search
    }



}