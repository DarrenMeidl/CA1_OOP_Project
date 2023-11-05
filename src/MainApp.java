//MainApp Class
public class MainApp {
    public static void main(String[] args) {
        Activities test1 = new Activities(); //New container class instance - Darren

        test1.add(new Activity());
        test1.add(new Activity("Swimming", 1, "03/11/2023", 50, 97));
        test1.add(new Activity("Swimming", 11, "03/11/2023", 50, 97, 50, "Light", 90));
        test1.add(new Activity("Swimming", 7, "03/11/2023", 50, 97, 50, "Light", 100));

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
    }
}