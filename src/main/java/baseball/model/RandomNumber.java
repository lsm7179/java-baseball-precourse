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
            randomNumbers.add(numbers(i));
        }
        return randomNumbers;
    }

    private Integer numbers(int index) {
        if (index == 0) {
            return Randoms.pickNumberInRange(1, 9);
        }
        if (index == 1) {
            return addSecondNumber();
        }
        return addThirdNumber();
    }

    private Integer addSecondNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumbers.get(0) == randomNumber) {
            return addSecondNumber();
        }
        return randomNumber;
    }

    private Integer addThirdNumber() {
        int randomNumber = addSecondNumber();
        if(randomNumbers.get(1) == randomNumber){
            return addThirdNumber();
        }
        return randomNumber;
    }

}
