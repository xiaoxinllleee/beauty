package com.venus.beauty.study;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author lx
 * @time 2018/10/8
 */
public class Demo1 {
    public static void main(String[] args) {
        long i = 11;
        System.out.println("i的两倍是： "+ (i+i));

        double d = 2d;
        System.out.println(d/0);

        System.out.println('\u005B');

        if (i > 0)
            System.out.println("i大于0");

        System.out.println(new Date());

        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(LocalDate.ofYearDay(2018,10));
    }
}
