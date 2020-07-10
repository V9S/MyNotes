package main.java;

public class BreakPointTest {

    public static void main(String[] args) {
        int n = 100;
        for (int m = 0; m <= n; m++) {
            System.out.println(m);
        }
    }

    public void fun() {
        int n = 200;
        for (int m = 0; m <= n; m++) {
            System.out.println(m);
        }
    }

}
