package com.example.demo.buoi2_p2;

import com.example.demo.buoi2.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sinhVien")
public class SinhVienController {
    @Autowired
    private SinhVienSevice sinhVienSevice;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<SinhVien> list = sinhVienSevice.getAll();
        return ResponseEntity.ok(list);
    }
}
