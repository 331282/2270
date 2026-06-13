package practice.Battleship;

public class square {

    public enum State {
        UNKNOWN,
        HIT,
        HITSUNK,
        MISS
    };

    private boolean occupied;
    private State state;
    private int num;
    private char letter;
    
    public square(char letter, int num) {
        this.occupied = false;
        this.state = State.UNKNOWN;
        this.num = num;
        this.letter = letter;
    }

    public char display() {
        switch (this.state) {
            case UNKNOWN:
                return 'O';
            case HIT:
                return 'X';
            case HITSUNK:
                return 'S';
            case MISS:
                return '#';
            default:
                return '!';
        }
    }

    public void guess() {
        if (this.occupied) {
            this.state = State.HIT;
        } else {
            this.state = State.MISS;
        }
        this.occupied = false;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public void addShip() {
        this.occupied = true;
    }
    
    public char getLetter() {
        return this.letter;
    }

    public int getNum() {
        return this.num;
    }
}
