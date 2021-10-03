package baseball.controller;

import baseball.model.Balls;
import baseball.model.InputHandler;
import baseball.model.PlayResult;
import baseball.model.RandomNumber;
import baseball.view.View;

import java.util.List;

public class PlayController {

    private Balls cumputerBalls;
    private List<Integer> userBalls;
    private InputHandler inputHandler;

    public PlayController() {
        inputHandler = new InputHandler();
    }

    private void makeCumputerBalls() {
        cumputerBalls = new Balls(new RandomNumber().make());
    }

    public void start() {
        makeCumputerBalls();
        play();
    }

    public void play(){
        try {
            View.EnterNumber.print();
            userBalls = inputHandler.makeNumbers();
            PlayResult playResult = cumputerBalls.play(userBalls);
            View.playResult(playResult.resultReport());
            isGameEnd(playResult);
        }catch (Exception e){
            System.out.println(e.getMessage());
            play();
        }
    }

    private void isGameEnd(PlayResult playResult) {
        if(playResult.isGameEnd()){
            gameEnd();
            return;
        }
        play();
    }

    //게임 종료
    public void gameEnd(){
    // ErrorOnlyOneAndTwo("[ERROR]1, 2만 입력해주세요."),
    }



}
