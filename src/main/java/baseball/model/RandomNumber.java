package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private List<Integer> randomNumbers;

    public RandomNumber(){
        randomNumbers = new ArrayList<>();
    }

    public List<Integer> make() {
        for (int i = 0; i < 3; i++) {
            randomNumbers.add(addNumber());
        }
        return randomNumbers;
    }

    private Integer addNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumbers.contains(randomNumber)) {
            return addNumber();
        }
        return randomNumber;
    }

}
