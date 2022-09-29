package baseball.model;

import baseball.rule.BaseballGameRule;
import baseball.view.OutputView;

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

    public void setNumbers(String input) {
        try {
            checkValidInputLength(input.length());

            numbers.clear();

            for(char c : input.toCharArray()){
                checkValidNumber(c);
                numbers.add(c - '0');
            }
        }catch (IllegalArgumentException e) {
            OutputView.printErrorInput();
            throw new IllegalArgumentException(Message.ERROR_INPUT.getMessage());
        }
    }

    private void checkValidInputLength(int length) throws IllegalArgumentException {
        if(length != BaseballGameRule.LENGTH_OF_NUMBERS){
            throw new IllegalArgumentException();
        }
    }

    private void checkValidNumber(char c) throws IllegalArgumentException {
        if(c < '1' || c > '9'){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
