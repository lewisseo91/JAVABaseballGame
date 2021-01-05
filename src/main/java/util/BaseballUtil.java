package util;

import model.BallStrikeInfo;
import model.BaseballInfo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BaseballUtil {

    public static BallStrikeInfo ballStrikeInfo;

    public BaseballUtil () { }

    public static boolean validateInput(BaseballInfo baseballInfo, int number) {
        // nextInt 아닐 경우 parseInt 해서 number 인지 판정하는 경우도 필요

        Set<Integer> numberCheckSet = new HashSet<>();
        int numberSize = 0;
        while (number > 0) {
            int currentNumber = number % 10;
            number = number - currentNumber;
            number /= 10;
            numberCheckSet.add(currentNumber);
            numberSize++;
        }

        if(numberSize != baseballInfo.getCorrectCount()) {
            System.out.println("incorrect numbers");
            return false;
        }

        if(numberSize > numberCheckSet.size()) {
            System.out.println("duplicated number");
            return false;
        }

        return true;
    }

    public static void checkBallStrike(BaseballInfo baseballInfo, int number) {
        ballStrikeInfo = new BallStrikeInfo();
        calculateNumber(baseballInfo, number);
        validateCorrect(baseballInfo);
    }

    public static void calculateNumber(BaseballInfo baseballInfo, int number) {

        int reversedIdx = 0;
        while (number > 0) {
            int currentNumber = number % 10;
            number = number - currentNumber;
            number /= 10;
            validateNumber(baseballInfo, currentNumber, reversedIdx);
            reversedIdx++;
        }
    }

    private static void validateNumber(BaseballInfo baseballInfo, int currentNumber, int reversedIdx) {
        Map<Integer, Integer> answerKeyMap = baseballInfo.getAnswerKeyMap();
        Map<Integer, Integer> answerValueMap = baseballInfo.getAnswerValueMap();
        if (answerValueMap.containsKey(currentNumber)) {
            validateStrikeBall(answerKeyMap.get(reversedIdx), currentNumber);
        }
    }

    private static void validateStrikeBall(int answerNumber, int currentNumber) {
        int currentStrikeCount = ballStrikeInfo.getStrikeCount();
        int currentBallCount = ballStrikeInfo.getStrikeCount();
        // 답이 존재 볼 or 스트라이크
        if (answerNumber == currentNumber) {
            ballStrikeInfo.setStrikeCount(++currentStrikeCount);
            return;
        }
        ballStrikeInfo.setBallCount(++currentBallCount);
    }

    private static void validateCorrect(BaseballInfo baseballInfo) {
        if (ballStrikeInfo.getStrikeCount() == baseballInfo.getCorrectCount()) {
            baseballInfo.setCorrectAnswer(true);
        }
    }
}
