import java.util.Scanner;

//MainApp Class
public class MainApp {
    public static void main(String[] args) {

        String fileName = "activity_data_10.csv"; //Reference to the cvs file
        Scanner sc = new Scanner(fileName);
        {
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it
            // read one line at a time into a String, and parse the String into tokens (parts)
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();             // read full line ( delimited by a "\n" )
                String [] instances = line.split(",");  // split line using a comma as the delimiter (separator)

                String ActivityType = instances[0];  // extract first token/field from the tokens array (i.e. the name)
                int Date = Integer.parseInt(instances[1]);  // e.g. Convert String "19" to int value 19
                double Duration = Double.parseDouble(instances[2]);  // e.g. Convert String "1.82" to double 1.82
                double Distance = Double.parseDouble(instances[3]);
                int AvgHeartRate = Integer.parseInt(instances[4]);

                // Use format specifiers to print the values
                System.out.printf("ActivityType: %s, Date: %d, Duration: %.2f, Distance: %.2f, AvgHeartRate: %d%n",
                        ActivityType, Date, Duration, Distance, AvgHeartRate);
            }

        /*Activities test1 = new Activities(); //New container class instance - Darren

        test1.add(new Activity());
        test1.add(new Activity("Swimming", 1, "27/09/2023", 150, 112));
        test1.add(new Activity("Running", 11, "01/12/2022", 72, 97, 80, "Very Light", 1200));
        test1.add(new Activity("Swimming", 0, "09/07/2022", 89, 102, 50, "Light", 1002));
        test1.add(new Activity("Cycling", 45, "13/06/2023", 35, 107, 63, "Moderate", 950));
        test1.add(new Activity("Running", 8, "19/04/2021", 14, 85, 78, "Vigorous", 883));
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