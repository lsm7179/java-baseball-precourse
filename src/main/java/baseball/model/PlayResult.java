package baseball.model;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isPlaying() {
        return strike != 3;
    }

    public String resultReport() {
        if (strikeAndBall()) {
            return strike + "스트라이크 " + ball + "볼";
        }
        return strikeBallNothing();
    }

    private String strikeBallNothing() {
        if (nothing()) {
            return "낫싱";
        }
        if (noBall()) {
            return strike + "스트라이크";
        }
        return ball + "볼";
    }

    private boolean strikeAndBall() {
        if (ball > 0 && strike > 0) {
            return true;
        }
        return false;
    }

    private boolean nothing() {
        if (ball == 0 && strike == 0) {
            return true;
        }
        return false;
    }

    private boolean noStrike() {
        if (strike == 0) {
            return true;
        }
        return false;
    }

    private boolean noBall() {
        if (ball == 0) {
            return true;
        }
        return false;
    }

}
