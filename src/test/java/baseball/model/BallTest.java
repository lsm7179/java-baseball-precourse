package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @DisplayName("숫자 1 ~ 9까지 검증")
    @Test
    void 숫자_1_9_까지_검증() {
        Ball ball = new Ball(1,9);
        assertThat(ball.isValid()).isTrue();

        ball = new Ball(1,1);
        assertThat(ball.isValid()).isTrue();

        ball = new Ball(1,10);
        assertThat(ball.isValid()).isFalse();

        ball = new Ball(1,0);
        assertThat(ball.isValid()).isFalse();

    }
}
