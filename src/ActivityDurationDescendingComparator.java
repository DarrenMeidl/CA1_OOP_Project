import java.util.Comparator;

public class ActivityDurationDescendingComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity act1, Activity act2) { //Declaring 2 objects from Activity List
        return Double.compare(act2.getDuration(), act1.getDuration()); //Opposite of Ascending Order
    }
}
