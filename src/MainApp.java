//MainApp Class
public class MainApp {
    public static void main(String[] args) {
        Activities test1 = new Activities(); //New container class instance - Darren

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
        System.out.println("");
    }
}