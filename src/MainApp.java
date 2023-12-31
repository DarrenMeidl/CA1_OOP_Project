import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//MainApp Class
public class MainApp {
    public static void main(String[] args) {
        Activities activities = new Activities(); //Creates a reference to a new activities object

        Scanner keyboard = new Scanner(System.in); //Creates reference to new Scanner object

        //READING CSV FILE
        String fileName = "activity_data_10.csv"; //Reference to the cvs file *we used the 10 sample test data file, possible to change to a different file with more data if needed
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
        }   catch(FileNotFoundException e){
                System.out.println("File not found: " + fileName); //Prints out when file was not found
            }
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
            if (selection == 1) {
                activities.printList();
            }


            //2. ADD ACTIVITY
            else if (selection == 2) {
                boolean addActivity = true;
                while (addActivity) {
                    System.out.print("Add your own activity fields? [Y/N]: ");
                    String userInput = keyboard.nextLine();
                    //IF NO, ADD OBJECT WITH DEFAULT CONSTRUCTOR
                    if (userInput.equalsIgnoreCase("n")) {
                        Activity newActivity = new Activity();
                        activities.add(newActivity);
                        System.out.println("Added Default Activity");
                        //CHECK IF YOU WANT TO ADD ANOTHER ACTIVITY
                        System.out.print("Do you want to add another activity? [Y/N]: ");
                        String input = keyboard.nextLine();
                        if (input.equalsIgnoreCase("n")) {
                            addActivity = false;
                        }
                    }
                    //IF YES, USER ENTERS THEIR OWN FIELDS
                    else if (userInput.equalsIgnoreCase("y")) {
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
                        System.out.println("Added Custom Activity");
                        //CHECK IF YOU WANT TO ADD ANOTHER ACTIVITY
                        System.out.print("Do you want to add another activity? [Y/N]: ");
                        String input = keyboard.nextLine();
                        if (input.equalsIgnoreCase("n")) {
                            addActivity = false;
                        }
                    }
                    //OTHERWISE, TRY AGAIN
                    else {
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }


            //3. SORT ACTIVITIES
            else if (selection == 3) {
                boolean sortActivities = true;
                while (sortActivities) {
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
                    if (sortActivitiesSelect == 1) {
                        //Natural Order method
                        activities.sort();
                        System.out.println("");
                        System.out.println("SORTING BY NATURAL ORDER");
                        activities.printList();
                    }
                    //2. Calories Burned Descending
                    else if (sortActivitiesSelect == 2) {
                        //Calories Burned Descending method
                        activities.sortByCaloriesBurnedDescending();
                        System.out.println("");
                        System.out.println("SORTING BY CALORIES DESCENDING");
                        activities.printList();
                    }

                    //3. Duration (Ascending)
                    else if (sortActivitiesSelect == 3) {
                        //Duration (Ascending) method
                        activities.sortByActivityDurationAscending();
                        System.out.println("");
                        System.out.println("SORTING BY DURATION ASCENDING");
                        activities.printList();
                    }

                    //4. Duration (Descending)
                    else if (sortActivitiesSelect == 4) {
                        //Duration (Descending) method
                        activities.sortByActivityDurationDescending();
                        System.out.println("");
                        System.out.println("SORTING BY DURATION DESCENDING");
                        activities.printList();
                    }

                    //5. Date (Ascending)
                    else if (sortActivitiesSelect == 5) {
                        //Date (Ascending) method
                        activities.sortByActivityDateAscending();
                        System.out.println("");
                        System.out.println("SORTING BY DATE ASCENDING");
                        activities.printList();
                    }

                    //6. Date (Descending)
                    else if (sortActivitiesSelect == 6) {
                        //Date (Descending) method
                        activities.sortByActivityDateDescending();
                        System.out.println("");
                        System.out.println("SORTING BY DATE DESCENDING");
                        activities.printList();
                    }

                    //7. Distance (Ascending)
                    else if (sortActivitiesSelect == 7) {
                        //Distance (Ascending) method
                        activities.sortByActivityDistanceAscending();
                        System.out.println("");
                        System.out.println("SORTING BY DISTANCE ASCENDING");
                        activities.printList();
                    }

                    //8. Distance (Descending)
                    else if (sortActivitiesSelect == 8) {
                        //Distance (Descending) method
                        activities.sortByActivityDistanceDescending();
                        System.out.println("");
                        System.out.println("SORTING BY DISTANCE DESCENDING");
                        activities.printList();
                    }

                    //9. Activity Type
                    else if (sortActivitiesSelect == 9) {
                        //Activity Type method
                        activities.sortByActivityType();
                        System.out.println("");
                        System.out.println("SORTING BY ACTIVITY TYPE");
                        activities.printList();
                    }

                    //10. Quit
                    else if (sortActivitiesSelect == 10) {
                        sortActivities = false;
                    } else {
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }

                }
            }


            //4. VIEW SUBSET OF ACTIVITIES
            else if (selection == 4) {
                boolean subsetActivities = true;
                while (subsetActivities) {
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
                    if (subsetActivitiesSelect == 1) {
                        System.out.print("Enter Activity Type: ");
                        String userInput = keyboard.nextLine();
                        System.out.println("VIEW BY ACTIVITY TYPE");
                        activities.viewByActivityType(userInput);
                    }

                    //2. Above Minimum Distance
                    else if (subsetActivitiesSelect == 2) {
                        System.out.print("Enter Minimum Distance: ");
                        double userInput = keyboard.nextDouble();
                        System.out.println("VIEW ABOVE MINIMUM DISTANCE");
                        activities.viewByActivityDistance(userInput);
                    }

                    //3. Energy Expended Type
                    else if (subsetActivitiesSelect == 3) {
                        System.out.print("Enter Energy Type: ");
                        String userInput = keyboard.nextLine();
                        System.out.println("VIEW BY ENERGY EXPENDED TYPE");
                        activities.viewByActivityIntensityType(userInput);
                    }

                    //4. Above Minimum Duration
                    else if (subsetActivitiesSelect == 4) {
                        System.out.print("Enter Minimum Duration: ");
                        double userInput = keyboard.nextDouble();
                        System.out.println("VIEW ABOVE MINIMUM DURATION");
                        activities.viewByActivityDuration(userInput);
                    }

                    //5. Quit
                    else if (subsetActivitiesSelect == 5) {
                        subsetActivities = false;
                    } else {
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }


            //5. VIEW STATISTICS
            else if (selection == 5) {
                boolean viewStatistics = true;
                while (viewStatistics) {
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
                    if (viewStatisticsSelect == 1) {
                        //Average Distance Per Activity method
                        System.out.println("");
                        activities.calculateAverageDistancePerActivity();
                    }

                    //2. Average Calories Burned
                    else if (viewStatisticsSelect == 2) {
                        //Average Calories Burned method
                        System.out.println("");
                        activities.calculateAverageCaloriesBurned();
                    }

                    //3. Quit
                    else if (viewStatisticsSelect == 3) {
                        viewStatistics = false;
                    } else {
                        System.out.println("INVALID INPUT. TRY AGAIN.");
                        System.out.println("");
                    }
                }
            }


            //6. BINARY SEARCH
            else if (selection == 6) {
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
            }


        //7. QUIT
            else if (selection == 7) {
                userHasQuit = true;
            }
            else {
                System.out.println("INVALID INPUT. TRY AGAIN.");
                System.out.println("");
            }
        }

    }
}
