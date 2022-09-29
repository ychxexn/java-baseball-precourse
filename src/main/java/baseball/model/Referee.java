package baseball.model;

import baseball.rule.BaseballGameRule;

import java.util.List;
import java.util.Objects;

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

    private void init(List<Integer> computerNum, List<Integer> playerNum) {
        init();
        this.computerNum = computerNum;
        this.playerNum = playerNum;
    }

    public GameStatus judge(List<Integer> computerNum, List<Integer> playerNum) {
        init(computerNum, playerNum);

        countStrike();
        countBall();

        if(sCount == BaseballGameRule.LENGTH_OF_NUMBERS) {
            return GameStatus.END;
        }

        return GameStatus.IN_PROGRESS;
    }

    private void countStrike() {
        for(int i=0; i< BaseballGameRule.LENGTH_OF_NUMBERS; i++) {
            if(Objects.equals(computerNum.get(i), playerNum.get(i))){
                sCount++;
            }
        }
    }

    private void countBall() {
        for(int number : playerNum) {
            if(computerNum.contains(number)) {
                bCount++;
            }
        }
    }

    public void printResult(){
        StringBuilder sb = new StringBuilder();

        if(bCount != 0){
            sb.append(bCount - sCount);
            sb.append("볼");
        }
        if(sb.length() != 0){
            sb.append(" ");
        }
        if(sCount != 0){
            sb.append(sCount);
            sb.append("스트라이크");
        }
        if(sb.length() == 0){
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}
