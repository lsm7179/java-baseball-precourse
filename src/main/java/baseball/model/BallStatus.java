package baseball.model;

public enum BallStatus {
    Nothing(0), Ball(1), Strike(2);

    private final int value;

    BallStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isStrike() {
        return this == Strike;
    }

    public boolean isBall() {
        return this == Ball;
    }

}
