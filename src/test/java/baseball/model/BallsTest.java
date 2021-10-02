package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @DisplayName("각 볼,스트라이크가 몇개인지 검증")
    @Test
    void play() {
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(4,5,6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("공 세개와 한개 비교하여 스트라이크 검증")
    @Test
    void playStrike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus result = answers.play(new Ball(1,1));
        assertThat(result).isEqualTo(BallStatus.Strike);
    }

    @DisplayName("공 세개와 한개 비교하여 볼 검증")
    @Test
    void playBall(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus result = answers.play(new Ball(1,2));
        assertThat(result).isEqualTo(BallStatus.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 낫싱 검증")
    @Test
    void playNothing(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus result = answers.play(new Ball(1,4));
        assertThat(result).isEqualTo(BallStatus.Nothing);

        answers = new Balls(Arrays.asList(1,2,3));
        result = answers.play(new Ball(2,4));
        assertThat(result).isEqualTo(BallStatus.Nothing);
    }
}
