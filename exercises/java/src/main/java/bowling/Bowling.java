package bowling;

public class Bowling {

    public static int score(int[] rolls) {

        int totalScore = 0;

        for (int roll = 0; roll < rolls.length; ) {

            if (rolls[roll] == 10) {
                int round = rolls[roll] + rolls[roll+1] + rolls[roll+2];
                totalScore += round;

                if (roll == rolls.length - 3) {
                    break;
                }
                roll += 1;

            } else if (rolls[roll] < 10) {
                if (roll == rolls.length-1){
                    break;
                }
                int round = rolls[roll] + rolls[roll + 1];
                if (round == 10) {
                    round += rolls[roll + 2];
                }
                totalScore += round;
                roll += 2;
            }
        }
        return totalScore;
    }
}
