package baseball.view;

public enum View {
    EnterNumber("숫자를 입력해주세요: "),
    GameEnd("3개의숫자를모두맞히셨습니다! 게임 끝\n"),
    RestartGameOrQuit("게임을새로시작하려면1 , 종료하려면2를입력하세요.\n");

    public static void playResult(String result){
        System.out.println(result);
    }

    private final String stringToprint;

    View(String stringToprint) {
        this.stringToprint = stringToprint;
    }

    public void print(){
        System.out.print(this.stringToprint);
    }

    public String getStringToprint() {
        return stringToprint;
    }

}
