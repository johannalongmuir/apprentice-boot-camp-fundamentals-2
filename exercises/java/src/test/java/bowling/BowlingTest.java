package bowling;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class BowlingTest {

    @Test
    public void allGutterBalls() {
        int [] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(0);
    }

    @Test
    public void noSparesOrStrikes() {
        int [] rolls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(20);

    }

    @Test
    public void oneSpare() {
        int [] rolls = {1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(29);
    }


    @Test
    public void gameWithTwoSpare() {
        int [] rolls = {1, 9, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(38);
    }

    @Test
    public void gameWithStrikeFirstRoll() {
        int [] rolls = {10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(30);
    }


    @Test
    public void gameWithStrikeFrame10() {
        int [] rolls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(30);
    }

    @Test
    public void givenAllStrikes() {
        int [] rolls = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(300);
    }

    @Test
    public void spareInFrameTen() {
        int [] rolls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(29);
    }

    @Test
    public void fiveStrikesand5Spares() {
        int [] rolls = {10,10,10,10,10, 1, 9, 1,9, 1,9, 1,9, 1,9 , 1};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(186);
    }

    @Test
    public void nineZeroEachFrame() {
        int [] rolls = {9,0, 9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0};
        Assertions.assertThat(Bowling.score(rolls)).isEqualTo(90);
    }
}
