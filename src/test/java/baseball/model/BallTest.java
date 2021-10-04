package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @DisplayName("숫자 1 ~ 9까지 맞는지 검증")
    @Test
    void ballValidTrueTest() {
        Ball ball = new Ball(1,9);
        assertThat(ball.isValid()).isTrue();

        ball = new Ball(1,1);
        assertThat(ball.isValid()).isTrue();
    }

    @DisplayName("숫자 1 ~ 9 아닐때 검증")
    @Test
    void ballValidFalseTest() {
        Ball ball = new Ball(1,10);
        assertThat(ball.isValid()).isFalse();

        ball = new Ball(1,0);
        assertThat(ball.isValid()).isFalse();
    }

    @DisplayName("볼 두개를 받아서 비교하여 스트라이크인지 아닌지 검증")
    @Test
    void strikeTest() {
        Ball answer = new Ball(1,9);
        BallStatus ballStatus = answer.play(new Ball(1,9));
        assertThat(ballStatus).isEqualTo(BallStatus.Strike);
    }

    @DisplayName("볼 두개를 받아서 비교하여 볼을 검증")
    @Test
    void ballTest() {
        Ball answer = new Ball(1,9);
        BallStatus ballStatus = answer.play(new Ball(2,9));
        assertThat(ballStatus).isEqualTo(BallStatus.Ball);
    }

    @DisplayName("볼 두개를 받아서 비교하여 낫싱을 검증")
    @Test
    void nothingTest() {
        Ball answer = new Ball(1,9);
        BallStatus ballStatus = answer.play(new Ball(2,3));
        assertThat(ballStatus).isEqualTo(BallStatus.Nothing);

        answer = new Ball(1,9);
        ballStatus = answer.play(new Ball(1,3));
        assertThat(ballStatus).isEqualTo(BallStatus.Nothing);
    }
}
