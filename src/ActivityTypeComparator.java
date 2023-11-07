import java.util.Comparator;

public class ActivityTypeComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity act1, Activity act2) { //Takes in two Activity objects
        return act1.getType().compareTo(act2.getType());
    }
}
