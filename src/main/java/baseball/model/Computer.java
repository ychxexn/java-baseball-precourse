package baseball.model;

import baseball.rule.BaseballGameRule;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer(){
        init();
    }

    private void init(){
        numbers = new ArrayList<>();
        while(numbers.size() < BaseballGameRule.LENGTH_OF_NUMBERS){
            int number = Randoms.pickNumberInRange(1, 9);
            addIfNotContain(number);
        }
    }

    private void addIfNotContain(int number){
        if(!numbers.contains(number)){
            numbers.add(number);
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
