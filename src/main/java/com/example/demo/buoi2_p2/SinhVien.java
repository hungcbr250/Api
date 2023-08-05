package com.example.demo.buoi2_p2;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SinhVien {
    private String ten;
    private Integer tuoi;
    private Double diemToan;
    private Double diemAnh;
    private Double diemVan;
}
