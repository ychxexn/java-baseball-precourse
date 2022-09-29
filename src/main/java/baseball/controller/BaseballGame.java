package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Game {
    private Computer computer;
    private Player player;

    @Override
    public void init() {
        computer = new Computer();
        player = new Player();
    }

    @Override
    public void start() {
        System.out.println(computer.getNumbers());
        player.setNumbers(Console.readLine());
    }
}
