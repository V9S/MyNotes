package main.java;

public class TestContinue {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                System.out.println("内部" + i);
                continue;
            }
            System.out.println("外部" + i);
        }
    }

}
