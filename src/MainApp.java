//MainApp Class
public class MainApp {
    public static void main(String[] args) {
        Activities test1 = new Activities(); //New container class instance - Darren

        test1.add(new Activity());
        test1.add(new Activity("Swimming", 1, "03/11/2023", 50, 97));
        test1.add(new Activity("Swimming", 1, "03/11/2023", 50, 97, 50, "Light", 90));
        test1.add(new Activity("Swimming", 1, "03/11/2023", 50, 97, 50, "Light", 100));

        System.out.println("BEFORE");
        test1.printList();
        test1.sortByCaloriesBurnedDescending();
        System.out.println("");
        System.out.println("AFTER");
        test1.printList();
    }
}