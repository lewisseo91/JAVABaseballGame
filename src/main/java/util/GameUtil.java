package util;

import model.BaseballInfo;

import java.util.Scanner;

public class GameUtil {

    private static BaseballInfo baseballInfo;

    public static void startGame() {
        setGameModel();
        processGame();
    }

    private static void setGameModel() {
        int answerNumber = MathUtil.generateRandomNumber(100, 999);
        int lifePoint = 3;
        int correctCount = 3;
        int gameCount = 10;
        baseballInfo = new BaseballInfo();
        baseballInfo.setGameCount(gameCount);
        baseballInfo.setAnswerNumber(answerNumber);
        baseballInfo.saveAnswerMap(answerNumber);
        baseballInfo.setLifePoint(lifePoint);
        baseballInfo.setCorrectCount(correctCount);
        // System.out.println(answerNumber);
    }

    public static void processGame() {
        int num;
        System.out.println(" 0~9 사이의 중복되지 않는 세 숫자를 입력하세요. ");
        System.out.println(" -1을 입력하면 게임이 종료됩니다. ");
        while((num = new Scanner(System.in).nextInt()) !=-1) {
            System.out.println(num);

            if(!BaseballUtil.validateInput(baseballInfo, num)) {
                System.out.println("다시 입력 해 주세요.");
                continue;
            }

            BaseballUtil.checkBallStrike(baseballInfo, num);

            if (baseballInfo.isCorrectAnswer()) {
                System.out.println("정답! gameEnd");
                break;
            }

            int strikeCount = BaseballUtil.ballStrikeInfo.getStrikeCount();
            int ballCount = BaseballUtil.ballStrikeInfo.getBallCount();

            System.out.println("Baseball count : strike : " + strikeCount + ", ball : " + ballCount);

            int currentLife = MathUtil.calculateLife(baseballInfo, strikeCount, ballCount);

            System.out.println("Current life point : " + currentLife);

            if(currentLife == 0) {
                System.out.print("게임 오버 ㅠㅠ game over");
                break;
            }

            int currentGameCount = baseballInfo.getGameCount();
            baseballInfo.setGameCount(--currentGameCount);

            if(currentGameCount == 0) {
                System.out.print("게임 오버 ㅠㅠ game over");
                break;
            }

            System.out.println("chance to challenge : "  + currentGameCount);

        }
    }
}
