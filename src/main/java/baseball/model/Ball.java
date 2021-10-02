package baseball.model;

public class Ball {

    private int position;
    private int no;

    public Ball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.Strike;
        }
        if (ball.isBall(no)) {
            return BallStatus.Ball;
        }
        return BallStatus.Nothing;
    }

    private boolean isBall(int no) {
        return this.no == no;
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        return position == ball.getPosition() && no == ball.getNo();
    }

    public boolean isValid() {
        return no <= 9 && no > 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
