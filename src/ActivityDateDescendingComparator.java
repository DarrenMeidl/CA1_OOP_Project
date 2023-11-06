import java.util.Comparator;

public class ActivityDateDescendingComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity act1, Activity act2){
        return act2.getDate().compareTo(act1.getDate());
        }
    }
