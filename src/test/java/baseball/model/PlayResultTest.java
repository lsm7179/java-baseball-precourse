package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PlayResultTest {

    @DisplayName("낫싱 검증")
    @Test
    void 낫싱() {
        Balls answers = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(Arrays.asList(2, 4, 6));

        assertThat(result.resultReport()).isEqualTo("낫싱");

    }
}
