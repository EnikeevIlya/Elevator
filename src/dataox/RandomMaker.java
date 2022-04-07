package dataox;

public class RandomMaker {
    public static int getRandomNumBetween(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
