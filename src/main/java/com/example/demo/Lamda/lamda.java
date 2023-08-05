package com.example.demo.Lamda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class lamda {
    static List<SinhVien> list = Arrays.asList(
            new SinhVien("Nguyén Van Téo", true, 7.5),
            new SinhVien("Tran Thi Thu Huong", false, 5.5),
            new SinhVien("Phaml Duc Cudng", true, 9.5),
            new SinhVien("Lé Thi My Héng", false, 6.5));

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    @FunctionalInterface
    interface Demo4Interface {
        void m1(int x);

        default void m2() {
        }

        public static void m3() {
        }
    }

    private static void demo4() {
        Demo4Interface demo4Interface = new Demo4Interface() {
            @Override
            public void m1(int x) {
                System.out.println(x);
            }
        };
        demo4Interface.m1(2023);// truyen thong

        Demo4Interface o = (x -> System.out.println(x));//moi
        o.m1(2023);
    }

    private static void demo3() {
        Collections.sort(list, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
        list.forEach(n ->
        {
            System.out.println(n.getName());
            System.out.println(n.getGender());
            System.out.println(n.getMarks());
        });
    }

    private static void demo2() {


        list.forEach(n ->
        {
            System.out.println(n.getName());
            System.out.println(n.getGender());
            System.out.println(n.getMarks());
        });

    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(n -> System.out.println(n));
    }




}
