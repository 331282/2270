package hw2;

public class PayStation {

    private TimeClock timeClock;
    private ParkingCard card = null;
    private boolean inProgress = false;
    private double totalPayments = 0.0;
    
    public PayStation(TimeClock givenClock) {
        this.timeClock = givenClock;
    }

    public void insertCard(ParkingCard t) {
        if (!inProgress) {
            this.inProgress = true;
            this.card = t;
        }
    }

    public ParkingCard getCurrentCard() {
        return this.inProgress ? card : null; 
    }

    public boolean inProgress() {
        return inProgress;
    }

    public double getPaymentDue() {
        if (this.inProgress) {
            return RateUtil.calculateCost(timeClock.getTime() - card.getStartTime()) - RateUtil.calculateCost(card.getPaymentTime() - card.getStartTime());
        }
        return 0.0;
    }

    public void makePayment() {
        if (this.inProgress) {
            totalPayments += getPaymentDue();
            card.setPaymentTime(timeClock.getTime());
        }
    }

    public void ejectCard() {
        this.inProgress = false;
        this.card = null;
    }

    public double getTotalPayments() {
        return totalPayments;
    }
}
