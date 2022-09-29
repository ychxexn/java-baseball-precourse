package baseball.model;

import baseball.rule.BaseballGameRule;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(){
        init();
    }

    private void init(){
        numbers = new ArrayList<>();
    }

    public void setNumbers(String input){
        checkValidInputLength(input.length());

        for(char c : input.toCharArray()){
            checkValidNumber(c);
            numbers.add(c - '0');
        }
    }

    private void checkValidInputLength(int length) {
        if(length != BaseballGameRule.LENGTH_OF_NUMBERS){
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }

    private void checkValidNumber(char c) {
        if(c < '1' || c > '9'){
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }

    public String getNumbers(){
        StringBuilder sb = new StringBuilder();

        for(int number : numbers){
            sb.append(number);
        }

        return sb.toString();
    }
}
