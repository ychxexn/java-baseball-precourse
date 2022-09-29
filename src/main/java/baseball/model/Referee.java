package baseball.model;


import java.util.List;

public class Referee {
    private int sCount;
    private int bCount;
    private List<Integer> computerNum;
    private List<Integer> playerNum;

    public Referee() {
        init();
    }

    private void init() {
        sCount = 0;
        bCount = 0;
    }

    public void printResult(){
        System.out.println("결과 출력");
    }
}
