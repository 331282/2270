package hw2;

public class ExitGate {

    private TimeClock timeClock;
    private int successfulSwipes = 0;

    public ExitGate(TimeClock givenClock) {
        this.timeClock = givenClock;
    }

    public boolean insertCard(ParkingCard c) {

        if (c.getPaymentTime() > 0 && timeClock.getTime() - c.getPaymentTime() <= RateUtil.EXIT_TIME_LIMIT) {
            successfulSwipes ++;
            return true;
        }
        return false;
    }

    public int getExitCount() {
        return successfulSwipes;
    }
    
}
