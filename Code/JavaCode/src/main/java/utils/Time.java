package main.java.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author ZLM
 * @date 2020/09/16
 */
public class Time {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分  ss 秒");
    // 当年天数
    public static int daysOfThisYear = LocalDate.now().lengthOfYear();

    public static String getTime() {
        while (true) {
            long a = System.currentTimeMillis();
            long b = new Date().getTime();
            if (a != b) {
                System.out.print("new Date().getTime()" + simpleDateFormat.format(b) + "----------");
                System.out.println("System.currentTimeMillis()" + simpleDateFormat2.format(a));
            }
        }
    }

    public static int getDaysOfYears(int year, int month, int day) {
        return LocalDate.of(year, month, day).getDayOfYear();
    }
}
