package bowling;

public class Bowling {

    public static int score(int[] rolls) {

        int totalScore = 0;

        for (int frame = 0; frame < rolls.length; frame += 2) {

            if (rolls[frame] == 10) {
                int round = rolls[frame] + rolls[frame+1] + rolls[frame+2];
                totalScore += round;
                if (frame == rolls.length - 3) {
                    break;
                }
                frame -= 1;

            } else if (rolls[frame] < 10) {
                int round = rolls[frame] + rolls[frame + 1];
                if (round == 10) {
                    round += rolls[frame + 2];
                }
                totalScore += round;
            }
        }
        return totalScore;
    }
}
