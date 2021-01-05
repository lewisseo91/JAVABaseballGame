package model;

import java.util.HashMap;
import java.util.Map;

public class BaseballInfo {

    private int gameCount;
    private int answerNumber;
    private int lifePoint;
    private int correctCount;
    private boolean isCorrectAnswer;
    private Map<Integer, Integer> answerKeyMap = new HashMap<>();
    private Map<Integer, Integer> answerValueMap = new HashMap<>();


    public int getGameCount() { return gameCount; }

    public void setGameCount(int gameCount) { this.gameCount = gameCount; }

    public int getAnswerNumber() { return answerNumber; }

    public void setAnswerNumber(int answerNumber) { this.answerNumber = answerNumber; }

    public int getLifePoint() { return lifePoint; }

    public void setLifePoint(int lifePoint) { this.lifePoint = lifePoint; }

    public int getCorrectCount() { return correctCount; }

    public void setCorrectCount(int correctCount) { this.correctCount = correctCount; }

    public boolean isCorrectAnswer() { return isCorrectAnswer; }

    public void setCorrectAnswer(boolean correctAnswer) { isCorrectAnswer = correctAnswer; }

    public Map<Integer, Integer> getAnswerKeyMap() { return answerKeyMap; }

    public void setAnswerKeyMap(Map<Integer, Integer> answerKeyMap) { this.answerKeyMap = answerKeyMap; }


    public Map<Integer, Integer> getAnswerValueMap() { return answerValueMap; }

    public void setAnswerValueMap(Map<Integer, Integer> answerValueMap) { this.answerValueMap = answerValueMap; }

    public void saveAnswerMap(int number) {
        int reversedIdx = 0; // 역순 인덱스 (끝자리 수부터 0)
        while (number > 0) {
            int currentNumber = number % 10;
            number = number - currentNumber;
            number /= 10;
            this.answerKeyMap.put(reversedIdx, currentNumber);
            this.answerValueMap.put(currentNumber, reversedIdx);
            reversedIdx++;
        }
    }
}
