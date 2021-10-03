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

    private void play(){
        try {
            View.EnterNumber.print();
            userBalls = inputHandler.makeNumbers();
            PlayResult playResult = cumputerBalls.play(userBalls);
            View.playResult(playResult.resultReport());
            isWin(playResult);
        }catch (Exception e){
            System.out.println(e.getMessage());
            play();
        }
    }

    private void isWin(PlayResult playResult) {
        if(playResult.isGameEnd()){
            View.GameEnd.print();
            restartOrQuit();
            return;
        }
        play();
    }

    private void restartOrQuit(){
        try {
            View.RestartGameOrQuit.print();
            isGameEnd();
        }catch (Exception e){
            System.out.println(e.getMessage());
            restartOrQuit();
        }
    }

    private void isGameEnd() {
        if (inputHandler.isEnd()) {
            System.exit(0);
        }
        start();
    }


}
