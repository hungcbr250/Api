package com.example.demo.buoi1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 5, 3);
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 == 0) {
                sum += i;

            }
        }
        System.out.println(sum);
//        .reduce(0, (o1, o2) -> o1 + o2):Đây là một phép giảm(reduction) để tích lũy các phần tử của Stream thành một
//        kết quả duy nhất.Trong trường hợp này, nó được sử dụng để tính tổng các số chẵn.
//
//        0:Giá trị ban đầu cho phép giảm.Trong trường hợp này, nó bắt đầu từ 0.
//        (o1, o2) -> o1 + o2:Hàm lambda mô tả cách kết hợp hai phần tử của Stream.Ở đây, nó đơn giản là cộng chúng lại
//        với nhau.
        //stream
        // tổng các số chẵn
        int sum2 = list.stream()
                .filter(o -> o % 2 == 0)
                .reduce(0, (o1, o2) -> o1 + o2);

        System.out.println(sum2);

        // tổng các số lẻ
        int sumLe = list.stream().filter(o -> o % 2 != 0).reduce(0, (o1, o2) -> o1 + o2);
        System.out.println(sumLe);

        //tổng bình phương của các số lẻ
        int sumOfSquares = list.stream()
                .filter(o -> o % 2 == 0)
                .reduce(0, (o1, o2) -> o1 + o2*o2);
//     cách 2:    .mapToInt(o -> o * o)
//                .reduce(0, (o1, o2) -> o1 + o2);

        System.out.println(" tong binh phuong" + sumOfSquares);

    }

}

