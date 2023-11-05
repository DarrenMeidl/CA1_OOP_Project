import java.util.Comparator;
public class CaloriesBurnedDescendingComparator implements Comparator<Activity>{
    @Override
    public int compare(Activity act1, Activity act2){
        double num1 = act1.getCaloriesBurned();
        double num2 = act2.getCaloriesBurned();
        if (num1 < num2) return 1;
        if (num1 > num2) return -1;
        return 0;
    }
}
