package baseball.model;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<Integer> makeNumbers(String input) {
        return addNumber(validation(input));
    }

    private String validation(String input) {
        validateEmpty(input);
        validateNotNumber(input);
        validateSizeOverOrLack(input);
        validateEqualNumber(input);
        validateRange(input);
        return input;
    }

    private void validateEqualNumber(String input) {
        List<Integer> list = addNumber(input);
        if (list.get(0) == list.get(1) || list.get(0) == list.get(2) || list.get(1) == list.get(2)) {
            throw new IllegalArgumentException("[ERROR]입력 숫자는 각각 다른 수여야 합니다.");
        }
    }

    private void validateRange(String input) {
        List<Integer> list = addNumber(input);
        for (int no : list) {
            isRange(no);
        }
    }

    private void isRange(int no) {
        if (no > 9 || no <= 0) {
            throw new IllegalArgumentException("[ERROR]입력 숫자는 1 ~ 9 까지여야 합니다.");
        }
    }

    private void validateSizeOverOrLack(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR]입력 숫자는 3개여야만 합니다.");
        }
    }

    private void validateNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new NullPointerException("[ERROR] 입력 값이 없습니다.");
        }
    }

    private List<Integer> addNumber(String input) {
        List<Integer> result = new ArrayList<>();
        String[] number = input.split("");
        for (int i = 0; i < input.length(); i++) {
            result.add(Integer.parseInt(number[i]));
        }
        return result;
    }

    public boolean isRegame() {
        String input = Console.readLine();
        validateEmpty(input);
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR]1, 2만 입력해주세요.");
    }


}
