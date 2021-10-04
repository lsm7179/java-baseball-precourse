package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class InputHandlerTest {

    InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @DisplayName("정상입력값 들어왔을때 검증")
    @Test
    void makeNumbers() {
        assertThat(inputHandler.makeNumbers("123")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("입력 수 제한 에러 검증")
    @Test
    void validateSizeOverOrLack() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]입력 숫자는 3개여야만 합니다.");
    }

    @DisplayName("입력값 없을때 에러 검증")
    @Test
    void validateEmpty() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("");
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("[ERROR] 입력 값이 없습니다.");
    }

    @DisplayName("입력값이 숫자가 아닐때 에러 검증")
    @Test
    void validateNotNumber() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("abc");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR] 정수 숫자만 입력 가능합니다.");
    }

    @DisplayName("입력값이 음수일때 에러 검증")
    @Test
    void validateNotPlus() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("-12");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR] 양수 숫자만 입력 가능합니다.");
    }

    @DisplayName("입력값이 같은 수가 있을때 에러 검증")
    @Test
    void validateEqualNumber() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("997");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]입력 숫자는 각각 다른 수여야 합니다.");
    }

    @DisplayName("입력값이 범위에 없을때 에러 검증")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> {
            inputHandler.makeNumbers("097");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]입력 숫자는 1 ~ 9 까지여야 합니다.");
    }

    @DisplayName("게임 종료 입력 검증")
    @Test
    void isRegame() {
        assertThatThrownBy(() -> {
            inputHandler.isRegame("else");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]1, 2만 입력해주세요.");

        assertThat(inputHandler.isRegame("1")).isTrue();
        assertThat(inputHandler.isRegame("2")).isFalse();
    }

}