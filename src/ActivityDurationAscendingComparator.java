import java.util.Comparator;

public class ActivityDurationAscendingComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity act1, Activity act2){ //Takes in two Activity objects
        return Double.compare(act1.getDuration(), act2.getDuration()); //This version provides more error free (due to rounding)
                                                                        // and more effective form

        //Darren Version
        /*double num1 = act1.getDuration(); //Assigns local field num1 to first object's duration
        double num2 = act2.getDuration(); //Assigns local field num2 to second object's duration
        if (num1 < num2) return -1; // If num2 is bigger than num1, return negative
        if (num1 > num2) return 1; // If num2 is smaller than num1, return positive
        return 0; // Otherwise, return 0*/
    }
}
