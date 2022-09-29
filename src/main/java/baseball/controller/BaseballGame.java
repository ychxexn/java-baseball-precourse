package baseball.controller;

import baseball.model.Computer;

public class BaseballGame implements Game {
    private Computer computer;

    @Override
    public void init() {
        computer = new Computer();
    }

    @Override
    public void start() {
        System.out.println(computer.getNumbers());
    }
}
