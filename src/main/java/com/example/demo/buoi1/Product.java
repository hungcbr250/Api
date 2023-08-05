package com.example.demo.buoi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Product {
    private String ten;
    private Float gia;

    public Product(String ten, Float gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("ten 1", 100F));
        list.add(new Product("ten 2", 300f));
        list.add(new Product("ten 3", 500f));
        list.add(new Product("ten 4", 200.5F));

        list.stream().filter(o -> o.getGia() >= 200f && o.getGia() <= 500f)
                .forEach(product -> System.out.println(product.getTen()));
        double tongGiaBan = list.stream()
                .mapToDouble(Product::getGia) /* tương ứng  product -> product.getPrice()*/
                .sum()
                ;
//      cách 2    .map(o->o.getGia())
//                .reduce(0f,Float::sum);
        System.out.println(tongGiaBan);

        Optional<Float> maxPrice = list.stream()
                .map(Product::getGia)
                .max(Float::compare);
        System.out.println("Giá bán cao nhất: " + maxPrice.get());
    }

}
