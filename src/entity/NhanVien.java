/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import util.XDate;

/**
 *
 * @author ToanVu
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh = XDate.addDays(new Date(), -365*20);
    private String dienThoai;
    private String CCCD;
    private String diaChi;
    private String hinhAnh;
    private String IDPB;
    private String IDBP;
    private String IDTD;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getIDPB() {
        return IDPB;
    }

    public void setIDPB(String IDPB) {
        this.IDPB = IDPB;
    }

    public String getIDBP() {
        return IDBP;
    }

    public void setIDBP(String IDBP) {
        this.IDBP = IDBP;
    }

    public String getIDTD() {
        return IDTD;
    }

    public void setIDTD(String IDTD) {
        this.IDTD = IDTD;
    }



}
