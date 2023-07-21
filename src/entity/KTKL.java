/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ToanVu
 */
public class KTKL {
    private String IDKTKL;
    private String NoiDung;
    private Date Ngay = new Date();
    private boolean Loai;
    private String MaNV;

    public String getIDKTKL() {
        return IDKTKL;
    }

    public void setIDKTKL(String IDKTKL) {
        this.IDKTKL = IDKTKL;
    }


    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public boolean getLoai() {
        return Loai;
    }

    public void setLoai(boolean Loai) {
        this.Loai = Loai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }


}
