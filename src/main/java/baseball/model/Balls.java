package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> ballList;
    private int size = 3;

    public Balls(List<Integer> answer) {
        createBalls(answer);
    }

    private void createBalls(List<Integer> answer) {
        ballList = new ArrayList<Ball>();
        for (int i = 0; i < size; i++) {
            ballList.add(new Ball(i + 1, answer.get(i)));
        }
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball ball : ballList) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        int statusNum = 0;
        for (int i = 0; i < size; i++) {
            statusNum += ballList.get(i).play(userBall).getValue();
        }
        if (statusNum == BallStatus.Nothing.getValue()) {
            return BallStatus.Nothing;
        }
        return strikeOrBall(statusNum);
    }

    private BallStatus strikeOrBall(int statusNum) {
        if (statusNum == BallStatus.Ball.getValue()) {
            return BallStatus.Ball;
        }
        return BallStatus.Strike;
    }



}
