import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//MainApp Class
public class MainApp {
    public static void main(String[] args) {
        //User's input fields
        String inputTest1 = "cycling";
        double inputTest2 = 5;
        String inputTest3 = "Vigorous";
        double inputTest4 = 100;
        double calAverage = 0;

        Activities activities = new Activities(); //Creates a refernce to a new activities object

        Scanner keyboard = new Scanner(System.in); //Creates reference to new Scanner object
        //MAIN MENU
        boolean userHasQuit = false;
        while (!userHasQuit) {
            //PRINTS MAIN MENU
            System.out.println("\n--- ACTIVITIES MAIN MENU ---");
            System.out.println("1. Print All Activities");
            System.out.println("2. Add Activity");
            System.out.println("3. Sort Activities");
            System.out.println("4. View Subset of Activities");
            System.out.println("5. View Statistics");
            System.out.println("6. Binary Search");
            System.out.println("7. Quit");
            System.out.print("Enter the number of your selection: ");
            //USER SELECT
            int selection = keyboard.nextInt();
            keyboard.nextLine();



            //1. PRINT ALL ACTIVITIES
            if (selection == 1){
                activities.printList();
            }



            //2. ADD ACTIVITY
            else if (selection == 2){
                boolean addActivity = true;
                while (addActivity){
                    System.out.print("Add your own activity fields? [Y/N]: ");
                    String userInput = keyboard.nextLine();
                    //IF NO, ADD OBJECT WITH DEFAULT CONSTRUCTOR
                    if(userInput.equalsIgnoreCase("n")){
                        Activity newActivity = new Activity();
                        activities.add(newActivity);
                        System.out.println("Added Default Activity");
                        //CHECK IF YOU WANT TO ADD ANOTHER ACTIVITY
                        System.out.print("Do you want to add another activity? [Y/N]: ");
                        String input = keyboard.nextLine();
                        if (input.equalsIgnoreCase("n")){
                            addActivity = false;
                        }
                    }
                    //IF YES, USER ENTERS THEIR OWN FIELDS
                    else if(userInput.equalsIgnoreCase("y")){
                        System.out.print("Enter Activity Type: ");
                        String inputType = keyboard.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        LocalDate inputDate = LocalDate.parse(keyboard.nextLine());
                        System.out.print("Enter Duration: ");
                        double inputDuration = keyboard.nextDouble();
                        System.out.print("Enter Distance: ");
                        double inputDistance = keyboard.nextDouble();
                        System.out.print("Enter Average Heart Rate: ");
                        int inputAvgHeartrate = keyboard.nextInt();

                        Activity newActivity = new Activity(inputType, inputDuration, inputDate, inputDistance, inputAvgHeartrate);
                        activities.add(newActivity);
                    }
                    //OTHERWISE, TRY AGAIN
                    else{
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }



            //3. SORT ACTIVITIES
            else if (selection == 3){
                boolean sortActivities = true;
                while(sortActivities) {
                    //PRINTS SORTING MENU
                    System.out.println("\n--- SORT ACTIVITIES ---");
                    System.out.println("1. Natural Order");
                    System.out.println("2. Calories Burned (Descending)");
                    System.out.println("3. Duration (Ascending)");
                    System.out.println("4. Duration (Descending)");
                    System.out.println("5. Date (Ascending)");
                    System.out.println("6. Date (Descending)");
                    System.out.println("7. Distance (Ascending)");
                    System.out.println("8. Distance (Descending)");
                    System.out.println("9. Activity Type");
                    System.out.println("10. Quit");
                    System.out.print("Enter the number of your selection: ");
                    //USER SELECT
                    int sortActivitiesSelect = keyboard.nextInt();
                    keyboard.nextLine();

                    //1. Natural Order
                    if (sortActivitiesSelect == 1){
                        //Natural Order method
                    }
                    else if (sortActivitiesSelect == 2){
                        //Calories Burned Descending method
                    }

                    //etc.

                    else if(sortActivitiesSelect == 10){
                        sortActivities = false;
                    }
                    else{
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }

                }
            }



            //4. VIEW SUBSET OF ACTIVITIES
            else if (selection == 4){
                boolean subsetActivities = true;
                while(subsetActivities) {
                    //PRINTS SUBSET ACTIVITIES MENU
                    System.out.println("\n--- VIEW SUBSET OF ACTIVITIES ---");
                    System.out.println("1. Activity Type");
                    System.out.println("2. Above Minimum Distance");
                    System.out.println("3. Energy Expended Type");
                    System.out.println("4. Above Minimum Duration");
                    System.out.println("5. Quit");
                    System.out.print("Enter the number of your selection: ");
                    //USER SELECT
                    int subsetActivitiesSelect = keyboard.nextInt();
                    keyboard.nextLine();

                    //1. Activity Type
                    if (subsetActivitiesSelect == 1){
                        //Activity Type method
                    }
                    //2. Above Minimum Distance
                    else if (subsetActivitiesSelect == 2){
                        //Above Minimum Distance method
                    }

                    //etc.

                    //5. Quit
                    else if(subsetActivitiesSelect == 5){
                        subsetActivities = false;
                    }
                    else{
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }



            //5. VIEW STATISTICS
            else if (selection == 5){
                boolean viewStatistics = true;
                while(viewStatistics) {
                    //PRINTS STATISTICS MENU
                    System.out.println("\n--- VIEW STATISTICS ---");
                    System.out.println("1. Average Distance Per Activity");
                    System.out.println("2. Average Calories Burned");
                    System.out.println("3. Quit");
                    System.out.print("Enter the number of your selection: ");
                    //USER SELECT
                    int viewStatisticsSelect = keyboard.nextInt();
                    keyboard.nextLine();

                    //1. Average Distance Per Activity
                    if (viewStatisticsSelect == 1){
                        //Average Distance Per Activity method
                    }
                    //2. Average Calories Burned
                    else if (viewStatisticsSelect == 2){
                        //Average Calories Burned method
                    }
                    //3. Quit
                    else if(viewStatisticsSelect == 3){
                        viewStatistics = false;
                    }
                    else{
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }



            //6. BINARY SEARCH
            else if (selection == 6){
                //BINARY SEARCH
                String fileName = "activity_data_10.csv"; //Reference to the cvs file
                File file = new File(fileName);
                try (Scanner sc = new Scanner(file)) {
                    if (sc.hasNextLine()) {
                        sc.nextLine();   //"Consume" the header by reading it and not using it further
                    }
                    //Reads lines if there are any, makes them strings and creates string instances for each variable
                    while (sc.hasNextLine()) {
                        //READING FILE
                        String line = sc.nextLine();             //Reads full line based on \n
                        String[] instances = line.split(",");  //Setting comma as a separator in a line

                        String type = instances[0];  //Separating each instance of a string from the file into a variable for each row and column
                        LocalDate date = LocalDate.parse(instances[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));  //Formatting date as in the file, using trim to remove unwanted spaces
                        double duration = Double.parseDouble(instances[2]);
                        double distance = Double.parseDouble(instances[3]);
                        int avgHeartRate = Integer.parseInt(instances[4].trim()); //Trims it because of unwanted space of the string before parsing as integer
                /*//Use format specifiers to print the values
                System.out.printf("%-20s %5s %7.2f %7.2f %7d%n", //Formatting for the file output in the code (File output)
                        type, date, duration, distance, avgHeartRate);*/
                        Activity activity = new Activity(type, duration, date, distance, avgHeartRate); //Create instance of activities from the file
                        activity.calculateEnergyExpended(distance, duration);
                        activity.calculateCaloriesBurned(activity.getIntensity(), duration);
                        boolean duplicate = false;
                        //CHECKING FOR DUPLICATES LOOP
                        for (int i = 0; i < activities.activityList.size(); i++) {
                            Activity arrayactivity = activities.activityList.get(i);
                            //If a duplicate is found
                            if (arrayactivity.getType().equals(activity.getType()) && //If the types of previous activities are equal and other conditions equal... set it as duplicate
                                    arrayactivity.getDate().equals(activity.getDate()) &&
                                    arrayactivity.getDuration() == activity.getDuration() &&
                                    arrayactivity.getDistance() == activity.getDistance() &&
                                    arrayactivity.getAvgHeartRate() == activity.getAvgHeartRate()) {
                                duplicate = true; //If all the above equal, set the duplicate boolean as true
                                System.out.println("DUPLICATE FOUND");
                                break;
                            }
                        }
                        //If a duplicate isn't found
                        if (!duplicate) {
                            activities.add(activity); //If the above values are not duplicate, add the activity to the arraylist
                        }
                    }
                    //SORT
                    activities.sortByActivityDateAscending(); //Sorts the list with natural sorting by date, or just activities.sort();
                    //USER INPUT
                    System.out.print("Enter Activity Date (YYYY-MM-DD): ");
                    String userInput = keyboard.nextLine();
                    //SEARCH
                    LocalDate searchDate = LocalDate.parse(userInput); //User inputs a date that is going to be found at a index if it exists in the arraylist
                    int index = activities.binarySearchByDate(searchDate); //Starts the binarysearch based on the date to find the index of it
                    if (index >= 0) {
                        Activity indexActivity = activities.activityList.get(index); //gets the info about the activity from the index it was found on
                        System.out.println("Activity found at index " + index + ": " + indexActivity);
                    } else {
                        System.out.println("Activity not found.");
                    }
                /*Activity key = new Activity("Swimming", 0, LocalDate.MIN, 0, 0); //Creates a key which is set to be found in the arraylist

            //Start binarysearch method in activities based on the key wanted
            int index = activities.binarySearchByActivityType(key);

            if (index >= 0) {
                System.out.println("Found " + activities.activityList.get(index) + " at index " + index); //If it's found in the arraylist 1 or multiple times, we get the index of that key in the arraylist
            } else {
                System.out.println("Not found in the list"); //Activates when the key is not found in the arraylist
            }*/
                }   catch (FileNotFoundException e) {
                    System.out.println("File not found: " + fileName); //Prints out when file was not found
                }
            }



            //7. QUIT
            else if (selection == 7){
                userHasQuit = true;
            }
            else{
                System.out.println("INVALID INPUT. TRY AGAIN.");
                System.out.println("");
            }
        }

























        /* OLD TESTING PRINTS
        //TESTING calculateAverageCaloriesBurned()
        System.out.println("TESTING 'calculateAverageCaloriesBurned'");
        activities.calculateAverageCaloriesBurned();
        System.out.println("");

        //TESTING calculateAverageDistancePerActivity()
        System.out.println("TESTING 'calculateAverageDistancePerActivity'");
        activities.calculateAverageDistancePerActivity();
        System.out.println("");

        //TESTING viewByActivityType()
        System.out.println("BEFORE 'viewByActivityType'");
        activities.printList();
        System.out.println("");
        System.out.println("AFTER 'viewByActivityType'");
        System.out.println("BASED ON: "+inputTest1);
        activities.viewByActivityType(inputTest1);
        System.out.println("");

        //TESTING viewByActivityDistance()
        System.out.println("BEFORE 'viewByActivityDistance'");
        activities.printList();
        System.out.println("");
        System.out.println("AFTER 'viewByActivityDistance'");
        System.out.println("BASED ON: "+inputTest2);
        activities.viewByActivityDistance(inputTest2);
        System.out.println("");

        //TESTING viewByActivityIntensityType()
        System.out.println("BEFORE 'viewByActivityIntensityType'");
        activities.printList();
        System.out.println("");
        System.out.println("AFTER 'viewByActivityIntensityType'");
        System.out.println("BASED ON: "+inputTest3);
        activities.viewByActivityIntensityType(inputTest3);
        System.out.println("");

        //TESTING viewByActivityDuration()
        System.out.println("BEFORE 'viewByActivityDuration'");
        activities.printList();
        System.out.println("");
        System.out.println("AFTER 'viewByActivityDuration'");
        System.out.println("BASED ON: "+inputTest4);
        activities.viewByActivityDuration(inputTest4);
        System.out.println("");

        //TESTING sortByCaloriesBurnedDescending()
        System.out.println("BEFORE 'sortByCaloriesBurnedDescending'");
        activities.printList();
        activities.sortByCaloriesBurnedDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByCaloriesBurnedDescending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDurationAscending()
        System.out.println("BEFORE 'sortByActivityDurationAscending'");
        activities.printList();
        activities.sortByActivityDurationAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDurationAscending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDurationDescending()
        System.out.println("BEFORE 'sortByActivityDurationDescending'");
        activities.printList();
        activities.sortByActivityDurationDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDurationDescending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDistanceAscending()
        System.out.println("BEFORE 'sortByActivityDistanceAscending'");
        activities.printList();
        activities.sortByActivityDistanceAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDistanceAscending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDistanceDescending()
        System.out.println("BEFORE 'sortByActivityDistanceDescending'");
        activities.printList();
        activities.sortByActivityDistanceDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDistanceDescending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityType()
        System.out.println("BEFORE 'sortByActivityType'");
        activities.printList();
        activities.sortByActivityType();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityType'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDateAscending()
        System.out.println("BEFORE 'sortByActivityDateAscending'");
        activities.printList();
        activities.sortByActivityDateAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDateAscending'");
        activities.printList();
        System.out.println("");

        //TESTING sortByActivityDateDescending()
        System.out.println("BEFORE 'sortByActivityDateDescending'");
        activities.printList();
        activities.sortByActivityDateDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDateDescending'");
        activities.printList();
        System.out.println("");*/

    }
}
