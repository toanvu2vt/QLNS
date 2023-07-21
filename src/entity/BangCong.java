/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BangCong {
    private String MaBC;
    private Date Ngay;
    private Float GioLam;
    private String MaNV;
//    private Float Luong;
//
//    public Float getLuong() {
//        return Luong *20000;
//    }
//
//    public void setLuong(Float Luong) {
//        this.Luong = Luong;
//    }

    public String getMaBC() {
        return MaBC;
    }

    public void setMaBC(String MaBC) {
        this.MaBC = MaBC;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public Float getGioLam() {
        return GioLam;
    }

    public void setGioLam(Float GioLam) {
        this.GioLam = GioLam;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}
