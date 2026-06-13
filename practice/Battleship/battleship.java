package practice.Battleship;

import java.util.Scanner;

public class battleship {

    public static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    static String displayField(square[][] field) {
        int i = 0;
        String output = " |ABCDEFGHIJ\n-+----------\n0|";
        for (square[] row : field) {
            for (square tile : row) {
                output += tile.display();
            }
            i++;
            if (i < 10) output += "\n" + i+"|";
        }
        return output;
    }

    static square getSquare(char letter, int num, square[][] field) {
        for (square[] row : field) {
            for (square tile : row) {
                if (tile.getLetter() == letter && tile.getNum() == num) {
                    return tile;
                }
            }
        }
        return null;
    }

    static square getInput(Scanner scanner, square[][] field) {
        try {
            String line = scanner.nextLine().trim();
            char letter = line.charAt(0);
            int num = Integer.parseInt(line.substring(1));
            square output = getSquare(letter, num, field);
            if (output == null) {
                System.out.println("Not a square -.-\nTry again");
                return getInput(scanner, field);
            } else {
                return output;
            }
        } catch (Exception e) {
            System.out.println("Try again(wrong input)");
            return getInput(scanner, field);
        }
    }

    static boolean allHit(square[][] field) {
        for (square[] row : field) {
            for (square tile : row) {
                if (tile.isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        square[][] field = new square[10][10];
        Scanner scanner = new Scanner(System.in);

        for (int i0 = 0; i0 < field.length; i0++) {
            for (int i1 = 0; i1 < field.length; i1++) {
                field[i0][i1] = new square(alphabet[i1],i0);
            }
        }
        System.out.println(displayField(field));
        System.out.println("Add a hit spot!");
        for (int i = 0; i < 5; i++) {
            getInput(scanner, field).addShip(); //5 targets 5% hit rate
        }
        while (!allHit(field)) {
            System.out.println(displayField(field));
            System.out.println("What do you want to hit?");
            getInput(scanner, field).guess();
        }
    }

}