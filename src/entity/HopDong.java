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
public class HopDong {
    private String IDHD;
    private Date ngayBD ;
    private Date ngayKT ;
    private Date ngayKY ;
    private String NoiDung; 
    private int MucLuong;
    private String MaNV;
    public String getIDHD() {
        return IDHD;
    }

    public void setIDHD(String IDHD) {
        this.IDHD = IDHD;
    }
  
    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public Date getNgayKY() {
        return ngayKY;
    }

    public void setNgayKY(Date ngayKY) {
        this.ngayKY = ngayKY;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public int getMucLuong() {
        return MucLuong;
    }

    public void setMucLuong(int MucLuong) {
        this.MucLuong = MucLuong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
   
}
