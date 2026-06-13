package hw2;

public class RateUtil {

    public static final int EXIT_TIME_LIMIT = 15;

    private RateUtil() {}

    public static double calculateCost(int minutes) {
        if (minutes <= 0) {
            return 0;
        } else if (minutes <= 30) {//30 minutes
            return 1.0;
        } else if (minutes <= 300) {//5 hours
            return 2.0 + (Math.ceil(minutes/60.0) - 1.0) * 1.5 ;
        } else if (minutes <= 480) {//8hours
            return 8.0 + (Math.ceil(minutes/60.0) - 5.0) * 1.25;
        }
        //more than that
        return 13.0 + calculateCost(minutes-60*24);
        
    }
}
