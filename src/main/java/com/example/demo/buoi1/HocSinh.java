package com.example.demo.buoi1;

import java.util.*;
import java.util.stream.Collectors;

public class HocSinh {
    private String ten;
    private Integer diem;


    public HocSinh(String ten, Integer diem) {
        this.ten = ten;
        this.diem = diem;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    public static void main(String[] args) {
        List<HocSinh> list = new ArrayList<>();
        list.add(new HocSinh("ten 1", 8));
        list.add(new HocSinh("ten 2", 9));
        list.add(new HocSinh("ten 3", 10));
        list.add(new HocSinh("ten 4", 7));

        list.stream()
                .filter(s -> s.getDiem() >= 8)
                .forEach(s -> {
                    System.out.println(s.getTen() + " :" + s.getDiem());

                });
        double diemTb = list.stream()
                .mapToDouble(h -> h.diem)
                .average().getAsDouble();
        System.out.println("diem tb " + diemTb);

        double diemMax = list.stream()
                .mapToDouble(h -> h.diem)
                .max().getAsDouble();
        System.out.println("diem max " + diemMax);

        Optional<HocSinh> hocSinhMax=list.stream().max(Comparator.comparing(h->h.getDiem()));
        hocSinhMax.ifPresent(h-> System.out.println(h.getTen()));

    }

}
