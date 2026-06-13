package hw1;

public class Location {

    public static final double RELATIVE_COST_OF_POSTCARD = 0.05;

    private String name;
    private int lodgingCost;

    public Location(String givenName, int givenLodgingCost) {
        this.name = givenName;
        this.lodgingCost = givenLodgingCost;
    }

    public String getName() {
        return this.name;
    }

    public int lodgingCost() {
        return this.lodgingCost;
    }

    public int costToSendPostcard() {
        return (int) Math.round(RELATIVE_COST_OF_POSTCARD * this.lodgingCost);
    }

    public int maxLengthOfStay(int funds) {
        return (int) Math.floor(funds/lodgingCost());
    }

    public int maxNumberOfPostcards(int funds) {
        return (int) Math.floor(funds/costToSendPostcard());
    }
}
