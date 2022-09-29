package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

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

        while(gameStatus == GameStatus.IN_PROGRESS) {
            String playerNum = InputView.getUserNumbers();
            player.setNumbers(playerNum);
            gameStatus = referee.judge(computer.getNumbers(), player.getNumbers());
            referee.printResult();
        }

        OutputView.printFinish();
    }

    @Override
    public boolean selectRestart() {
        return "1".equals(InputView.getUserChoice());
    }
}
