package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @DisplayName("낫싱 검증")
    @Test
    void notthing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("3스트라이크 검증")
    @Test
    void three_strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("3볼 검증")
    @Test
    void three_ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(3, 1, 2));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @DisplayName("1스트라이크 1볼 검증")
    @Test
    void two_strike_one_ball() {
        Balls answers = new Balls(Arrays.asList(4, 6, 2));
        PlayResult result = answers.play(Arrays.asList(4, 2, 8));

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @DisplayName("공 세개와 한개 비교하여 스트라이크 검증")
    @Test
    void playStrike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = answers.play(new Ball(1, 1));
        assertThat(result).isEqualTo(BallStatus.Strike);
    }

    @DisplayName("공 세개와 한개 비교하여 볼 검증")
    @Test
    void playBall() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = answers.play(new Ball(1, 2));
        assertThat(result).isEqualTo(BallStatus.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 낫싱 검증")
    @Test
    void playNothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus result = answers.play(new Ball(1, 4));
        assertThat(result).isEqualTo(BallStatus.Nothing);

        answers = new Balls(Arrays.asList(1, 2, 3));
        result = answers.play(new Ball(2, 4));
        assertThat(result).isEqualTo(BallStatus.Nothing);
    }

}
