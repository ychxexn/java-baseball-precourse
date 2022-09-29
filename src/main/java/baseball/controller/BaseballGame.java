package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Referee;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Game {
    private GameStatus gameStatus;
    private Computer computer;
    private Player player;
    private Referee referee;

    @Override
    public void init() {
        gameStatus = GameStatus.READY;
        computer = new Computer();
        player = new Player();
        referee = new Referee();
    }

    @Override
    public void start() {
        do{
            init();
            playBaseballGame();
        }while(selectRestart());
    }

    private void playBaseballGame() {
        gameStatus = GameStatus.IN_PROGRESS;

        System.out.println(computer.getNumbers().toString());

        while(gameStatus == GameStatus.IN_PROGRESS) {
            String playerNum = Console.readLine();
            player.setNumbers(playerNum);
            gameStatus = referee.judge(computer.getNumbers(), player.getNumbers());
            referee.printResult();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public boolean selectRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return "1".equals(Console.readLine());
    }
}
