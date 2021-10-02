package baseball.model;

public class Ball {

    private int position;
    private int no;

    public Ball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public boolean isValid() {
        return no <= 9 && no > 0;
    }


    public BallStatus play(Ball ball) {
        if(this.no == ball.no && this.position == ball.position){
            return BallStatus.Strike;
        }
        if(this.no == ball.no && this.position != ball.position){
            return BallStatus.Ball;
        }
        return BallStatus.Nothing;
    }
}
