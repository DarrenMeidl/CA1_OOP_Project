import java.util.Comparator;
public class CaloriesBurnedDescendingComparator implements Comparator<Activity>{
    //Overrides compare method
    @Override
    public int compare(Activity act1, Activity act2){ //Takes in two Activity objects
        return Double.compare(act1.getCaloriesBurned(), act2.getCaloriesBurned()); //This version provides more error free (due to rounding)
                                                                                    // and more effective form

        //Darren Version
        /*double num1 = act1.getCaloriesBurned(); //Assigns local field num1 to first object's calories burned
        double num2 = act2.getCaloriesBurned(); //Assigns local field num2 to second object's calories burned
        if (num1 < num2) return 1; // If num2 is bigger than num1, return positive
        if (num1 > num2) return -1; // If num2 is smaller than num1, return negative
        return 0; // Otherwise, return 0*/
    }
}
