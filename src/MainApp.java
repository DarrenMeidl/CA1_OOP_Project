import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        double avgDistanceSwim = 0;
        double avgDistanceRun = 0;
        double avgDistanceCycle = 0;

        Activities activities = new Activities(); //Creates container for activities


        String fileName = "activity_data_10.csv"; //Reference to the cvs file
        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            if (sc.hasNextLine()) {
                sc.nextLine();   //"Consume" the header by reading it and not using it further
            }
            //Reads lines if there are any, makes them strings and creates string instances for each variable
            while (sc.hasNextLine()) {
                String line = sc.nextLine();             //reads full line based on \n
                String[] instances = line.split(",");  //setting comma as a separator in a line

                String type = instances[0];  //Separating each instance of a string from the file into a variable for each row and column
                //String date = instances[1];
                LocalDate date = LocalDate.parse(instances[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));  //Formatting date as in the file, using trim to remove unwanted spaces
                double duration = Double.parseDouble(instances[2]);
                double distance = Double.parseDouble(instances[3]);
                int avgHeartRate = Integer.parseInt(instances[4].trim()); //trims it because of unwanted space of the string before parsing as integer

                /*//Use format specifiers to print the values
                System.out.printf("%-20s %5s %7.2f %7.2f %7d%n", //Formatting for the file output in the code (File output)
                        type, date, duration, distance, avgHeartRate);*/


                Activity activity = new Activity(type, duration, date, distance, avgHeartRate); //Create instance of activities from the file
                activity.calculateEnergyExpended(distance, duration);
                activity.calculateCaloriesBurned(activity.getIntensity(), duration);
                activities.add(activity); //Add the instance to the container

            }

            Activity key = new Activity("Running", 0, LocalDate.MIN, 0, 0); //Creates a key which is set to be found in the arraylist

            //Start binarysearch method in activities based on the key wanted
            int index = activities.binarySearchByActivityType(key);

            if (index >= 0) {
                System.out.println("Found " + activities.activityList.get(index) + " at index " + index); //If it's found in the arraylist 1 or multiple times, we get the index of that key in the arraylist
            } else {
                System.out.println("Not found in the list"); //Activates when the key is not found in the arraylist
            }

            //TESTING calculateAverageCaloriesBurned()
            System.out.println("TESTING 'calculateAverageCaloriesBurned'");
            calAverage = activities.calculateAverageCaloriesBurned();
            System.out.printf("AVERAGE CALORIES BURNED ACROSS ALL ACTIVITIES IS: %.3f\n", calAverage);
            avgDistanceSwim = activities.calculateAverageDistanceSwimming();
            System.out.printf("AVERAGE DISTANCE IN SWIMMING ACTIVITY IS: %.3f\n", avgDistanceSwim);
            avgDistanceRun = activities.calculateAverageDistanceRunning();
            System.out.printf("AVERAGE DISTANCE IN RUNNING ACTIVITY IS: %.3f\n", avgDistanceRun);
            avgDistanceCycle = activities.calculateAverageDistanceCycling();
            System.out.printf("AVERAGE DISTANCE IN CYCLING ACTIVITY IS: %.3f\n", avgDistanceCycle);
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

            /*//TESTING sortByCaloriesBurnedDescending()
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


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName); //Prints out when file was not found
        }
    }
}
