package com.example.demo.StreamApi;

import com.example.demo.Lamda.SinhVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    static List<SinhVien> list = Arrays.asList(
            new SinhVien("Nguyén Van Téo", true, 7.5),
            new SinhVien("Tran Thi Thu Huong", false, 5.5),
            new SinhVien("Phaml Duc Cudng", true, 9.5),
            new SinhVien("Lé Thi My Héng", false, 6.5));

    public static void main(String[] args) {
        demo1();
        System.out.println("----------");
        demo2();
        System.out.println("----------");
        demo3();
        System.out.println("----------");
        demo4();
    }

    private static void demo1() {
        Stream<Integer> stream = Stream.of(1, 9, 4, 7, 5, 2);
        stream.forEach(n -> System.out.println(n));
        System.out.println("------------");
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.stream().forEach(n -> System.out.println(n));
    }

    ;

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        List<Double> result = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> Math.sqrt(n))
                .peek(n -> System.out.println(n))
                .collect(Collectors.toList());
//      result.forEach(n-> System.out.println(n));
    }

    ;

    private static void demo3() {
        List<SinhVien> result = list.stream()
                .filter(sv -> sv.getMarks() >= 7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());
        result.forEach(sv -> {
            System.out.println(sv.getName());
            System.out.println(sv.getMarks());
        });
    }

    ;

    private static void demo4() {
        // tinh tb
        double average = list.stream()
                .mapToDouble(sv -> sv.getMarks())
                .average().getAsDouble();
        System.out.println("average" + average);
        // tim min
        double minMark = list.stream()
                .mapToDouble(sv -> sv.getMarks())
                .min().getAsDouble();
        System.out.println("min " + minMark);
        // kiểm tra xem tất cả các sinh viên có pass không
        Boolean all_passed = list.stream()
                .allMatch(sv -> sv.getMarks() > 5);
        System.out.println("all_passed " + all_passed);
        // sinh vien diem thấp nhất
        SinhVien sinhVienMin = list.stream()
                .reduce(list.get(0), (min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);
        System.out.println("minSV " + sinhVienMin);

    }
}
