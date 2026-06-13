package hw1;

public class Backpacker {

    public static final int SYMPATHY_FACTOR = 30;

    private int funds;
    private Location location;
    private String journal;
    private int totalNightsInTrainStation = 0;
    private int postCardsSentSinceLastCall = 0;

    public Backpacker(int initialFunds, Location initialLocation) {
        this.funds = initialFunds;
        this.location = initialLocation;
        this.journal = this.location.getName() + "(start)";
    }

    public String getCurrentLocation() {
        return this.location.getName();
    }

    public int getCurrentFunds() {
        return this.funds;
    }

    public String getJournal() {
        return this.journal;
    }

    public boolean isSOL() {
        return this.funds < this.location.costToSendPostcard();
    }

    public int getTotalNightsInTrainStation() {
        return this.totalNightsInTrainStation;
    }

    public void visit(Location c, int numNights) {
        int maxLengthOfStay = c.maxLengthOfStay(this.funds);
        int nightsStayed = (maxLengthOfStay < numNights) ? maxLengthOfStay : numNights;
        this.funds -= c.lodgingCost() * nightsStayed;
        this.totalNightsInTrainStation += numNights - nightsStayed;
        this.journal = this.journal + "," + c.getName() + "(" + numNights + ")";
        this.location = c;
    }

    public void sendPostcardsHome(int howMany) {
        int maxNumberOfPostcards = this.location.maxNumberOfPostcards(this.funds);
        int sentPostcards = (howMany < maxNumberOfPostcards) ? howMany : maxNumberOfPostcards;
        this.funds -= this.location.costToSendPostcard() * sentPostcards;
        this.postCardsSentSinceLastCall += sentPostcards;
    }

    public void callHomeForMoney() {
        this.funds += this.postCardsSentSinceLastCall * SYMPATHY_FACTOR;
        this.postCardsSentSinceLastCall = 0;
    }
}
