import java.util.Random;

class RaceSimulation {

    public static void main(String[] args) {
        int tortoisePos = 1;
        int harePos = 1;
        int finishLine = 70;
        Random rand = new Random();

        System.out.println("The race begins!");

        while (tortoisePos < finishLine && harePos < finishLine) {
            tortoisePos += moveTortoise(rand);
            harePos += moveHare(rand);

            if (tortoisePos < 1) tortoisePos = 1;
            if (harePos < 1) harePos = 1;


            System.out.println("Tortoise: " + tortoisePos + " | Hare: " + harePos);


            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("An error occurred.");
            }
        }


        if (tortoisePos >= finishLine && harePos >= finishLine) {
            System.out.println("It's a tie!");
        } else if (tortoisePos >= finishLine) {
            System.out.println("Tortoise wins!");
        } else {
            System.out.println("Hare wins!");
        }
    }


    public static int moveTortoise(Random rand) {
        int move = rand.nextInt(10) + 1;
        if (move <= 5)
            return 3;
        else if (move <= 7)
            return -6;
        else
            return 1;
    }


    public static int moveHare(Random rand) {
        int move = rand.nextInt(10) + 1;
        if (move <= 2)
            return 0;
        else if (move <= 4)
            return 9;
        else if (move == 5)
            return -12;
        else if (move <= 8)
            return 1;
        else
            return -2;
    }
}
