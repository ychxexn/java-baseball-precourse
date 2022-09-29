package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Game {
    private Computer computer;
    private Player player;
    private Referee referee;

    @Override
    public void init() {
        computer = new Computer();
        player = new Player();
        referee = new Referee();
    }

    @Override
    public void start() {
        System.out.println(computer.getNumbers().toString());
        while(true) {
            String playerNum = Console.readLine();
            player.setNumbers(playerNum);
            referee.judge(computer.getNumbers(), player.getNumbers());
            referee.printResult();
        }
    }
}
