package hw2;

public class CardDispenser {

    private TimeClock timeClock;

    public CardDispenser(TimeClock givenClock) {
        this.timeClock = givenClock;
    }

    public ParkingCard takeCard() {
        ParkingCard card = new ParkingCard(this.timeClock.getTime());
        return card;        
    }
}
