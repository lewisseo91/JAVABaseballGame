package util;

import model.BaseballInfo;

import java.util.Random;

public class MathUtil {

    public static int generateRandomNumber(int min, int max) {
        Random randomUtil = new Random();
        int randomNumber = randomUtil.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    public static int calculateLife(BaseballInfo baseballInfo, int strikeCount, int ballCount) {
        int lifePoint = baseballInfo.getLifePoint();
        if(strikeCount == 0 && ballCount == 0) {

            if(lifePoint <= 0) {
                System.out.println("여기 들어오면 말도 안되는 오류");
                return -1;
            }

            baseballInfo.setLifePoint(--lifePoint);
        }
        return lifePoint;
    }
}
