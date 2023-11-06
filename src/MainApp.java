import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//MainApp Class
public class MainApp {
    public static void main(String[] args) {

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

                //Use format specifiers to print the values
                System.out.printf("%-20s %5s %7.2f %7.2f %7d%n", //Formatting for the file output in the code
                        type, date, duration, distance, avgHeartRate);


                Activity activity = new Activity(type, duration, date, distance, avgHeartRate); //Create instance of activities from the file
                //calculateEnergyExpended(distance, duration);
                activities.add(activity); //Add the instance to the container

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName); //Prints out when file was not found


            activities.sortByActivityDurationAscending();
            activities.printList();

        /*Activities test1 = new Activities(); //New container class instance - Darren

        test1.add(new Activity());
        test1.add(new Activity("Swimming", 1, LocalDate.parse("0000-07-03"), 150, 112));
        test1.add(new Activity("Running", 11, LocalDate.parse("2021-03-01"), 72, 97, 80, "Very Light", 1200));
        test1.add(new Activity("Swimming", 0, LocalDate.parse("2023-01-17"), 89, 102, 50, "Light", 1002));
        test1.add(new Activity("Cycling", 45, LocalDate.parse("2021-01-09"), 35, 107, 63, "Moderate", 950));
        test1.add(new Activity("Running", 8, LocalDate.parse("2022-11-01"), 14, 85, 78, "Vigorous", 883));
        //TESTING sortByCaloriesBurnedDescending()
        System.out.println("BEFORE 'sortByCaloriesBurnedDescending'");
        test1.printList();
        test1.sortByCaloriesBurnedDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByCaloriesBurnedDescending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDurationAscending()
        System.out.println("BEFORE 'sortByActivityDurationAscending'");
        test1.printList();
        test1.sortByActivityDurationAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDurationAscending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDurationDescending()
        System.out.println("BEFORE 'sortByActivityDurationDescending'");
        test1.printList();
        test1.sortByActivityDurationDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDurationDescending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDistanceAscending()
        System.out.println("BEFORE 'sortByActivityDistanceAscending'");
        test1.printList();
        test1.sortByActivityDistanceAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDistanceAscending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDistanceDescending()
        System.out.println("BEFORE 'sortByActivityDistanceDescending'");
        test1.printList();
        test1.sortByActivityDistanceDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDistanceDescending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityType()
        System.out.println("BEFORE 'sortByActivityType'");
        test1.printList();
        test1.sortByActivityType();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityType'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDateAscending()
        System.out.println("BEFORE 'sortByActivityDateAscending'");
        test1.printList();
        test1.sortByActivityDateAscending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDateAscending'");
        test1.printList();
        System.out.println("");

        //TESTING sortByActivityDateDescending()
        System.out.println("BEFORE 'sortByActivityDateDescending'");
        test1.printList();
        test1.sortByActivityDateDescending();
        System.out.println("");
        System.out.println("AFTER 'sortByActivityDateDescending'");
        test1.printList();
        System.out.println("");*/
        }
    }
}