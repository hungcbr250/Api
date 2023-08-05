package com.example.demo.buoi2_p2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class SinhVienSevice {
    List<SinhVien> list = new ArrayList<>();

    @PostConstruct
    public void fakeData() {
        IntStream.rangeClosed(1, 50)
                .mapToObj(o -> SinhVien.builder().ten("name" + o).tuoi(new Random().nextInt(50)
                        ).diemToan(new Random().nextDouble(10)+1)
                        .diemAnh(new Random().nextDouble(10))
                        .diemVan(new Random().nextDouble(10)))
                .forEach(s -> list.add(s.build()));
        ;
    }

    public List<SinhVien> getAll() {
        return list;
    }
}
