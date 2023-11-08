import java.util.Comparator;

public class ActivityDurationAscendingComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity act1, Activity act2){ //Takes in two Activity objects
        return Double.compare(act1.getDuration(), act2.getDuration()); //This version provides more error free (due to rounding)
                                                                        // and more effective form
    }
}
