package hw1;

public class Test {
    public static void main(String[] args) {
        Location paris = new Location("Paris", 75);
        Location rome = new Location("Rome", 50);

        Backpacker t = new Backpacker(500, paris);

        System.out.println(t.getCurrentLocation()); // excpected paris
        System.out.println(t.getJournal()); //expected Paris(start)
        System.out.println(t.getCurrentFunds()); // expected 500

        t.visit(rome, 2);
        System.out.println(t.getCurrentLocation()); //expected rome
        System.out.println(t.getJournal()); //expected Paris(start),Rome(2)
        System.out.println(t.getCurrentFunds()); // expected 400

        t.visit(paris, 7);
        System.out.println(t.getCurrentLocation()); //expected Paris
        System.out.println(t.getJournal()); // expected Paris(start),Rome(2),Paris(7)
        System.out.println(t.getCurrentFunds()); // expected 25
        System.out.println(t.getTotalNightsInTrainStation()); //expected 2

        t.visit(paris, 7);
        System.out.println(t.getCurrentFunds()); // expected 25
        System.out.println(t.getTotalNightsInTrainStation()); //expected 9

        t.sendPostcardsHome(1);
        System.out.println(t.getCurrentFunds()); // expected 21

        t.sendPostcardsHome(12);
        System.out.println(t.getCurrentFunds()); // expected 1

        System.out.println(t.isSOL()); // expected true
         t.callHomeForMoney(); 
        System.out.println(t.getCurrentFunds()); // expected 181 
        t.callHomeForMoney(); 
        System.out.println(t.getCurrentFunds()); // expected 181
    }
}
