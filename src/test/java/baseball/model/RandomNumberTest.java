package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {

    @DisplayName("랜덤번호 크기 검증")
    @RepeatedTest(100)
    @Test
    void ramdomNumbers_size() {
        List list = new RandomNumber().make();
        assertThat(list.size()).isEqualTo(3);
    }

    @DisplayName("랜덤번호 각 번호가 다른지 검증")
    @RepeatedTest(100)
    @Test
    void ramdomNumbers_isDifferent() {
        List list = new RandomNumber().make();
        boolean isDifferent =
                list.get(0)!=list.get(1)&&
                list.get(0)!=list.get(2)&&
                list.get(1)!=list.get(2);
        assertThat(isDifferent).isTrue();
    }
}