package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PlayResultTest {

    @DisplayName("낫싱레포트 출력 검증")
    @Test
    void 낫싱() {
        Balls answers = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(Arrays.asList(2, 4, 6));
        assertThat(result.resultReport()).isEqualTo("낫싱");

    }

    @DisplayName("3볼 레포트 출력 검증")
    @Test
    void 볼() {
        Balls answers = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(Arrays.asList(5, 1, 3));

        assertThat(result.resultReport()).isEqualTo("3볼");
        assertThat(result.isPlaying()).isTrue();

    }

    @DisplayName("1스트라이크 1볼 레포트 출력 검증")
    @Test
    void oneStrike_oneBall() {
        Balls answers = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(Arrays.asList(1, 6, 3));

        assertThat(result.resultReport()).isEqualTo("1스트라이크 1볼");
        assertThat(result.isPlaying()).isTrue();

    }

    @DisplayName("3스트라이크 및 게임 성공 검증")
    @Test
    void 게임성공() {
        Balls answers = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(Arrays.asList(1, 3, 5));

        assertThat(result.resultReport()).isEqualTo("3스트라이크");
        assertThat(result.isPlaying()).isFalse();

    }

}
