package baseball.controller;

import baseball.model.Balls;
import baseball.model.InputHandler;
import baseball.model.PlayResult;
import baseball.model.RandomNumber;
import baseball.view.View;
import nextstep.utils.Console;

public class PlayController {

    private Balls cumputerBalls;
    private InputHandler inputHandler;
    private PlayResult playResult;

    public PlayController() {
        inputHandler = new InputHandler();
    }

    private void makeCumputerBalls() {
        cumputerBalls = new Balls(new RandomNumber().make());
    }

    public void start() {
        makeCumputerBalls();
        playResult = new PlayResult();
        while (playResult.isPlaying()) {
            play();
        }
        win();
    }

    private void play() {
        View.EnterNumber.print();
        String input = Console.readLine();
        try {
            playResult = cumputerBalls.play(inputHandler.makeNumbers(input));
            View.playResult(playResult.resultReport());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void win() {
        View.GameEnd.print();
        restartOrQuit();
    }

    private void restartOrQuit() {
        try {
            View.RestartGameOrQuit.print();
            isGameEnd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            restartOrQuit();
        }
    }

    private void isGameEnd() {
        String input = Console.readLine();
        if (inputHandler.isRegame(input)) {
            start();
        }
    }

}
