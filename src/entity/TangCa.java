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
public class TangCa {
    private String IDTC;
    private Date NgayTC;
    private Float SoGio;
    private boolean LoaiCa;
    private String MaNV;   
    
    public boolean getLoaiCa() {
        return LoaiCa;
    }

    public void setLoaiCa(boolean LoaiCa) {
        this.LoaiCa = LoaiCa;
    }

    public String getIDTC() {
        return IDTC;
    }

    public void setIDTC(String IDTC) {
        this.IDTC = IDTC;
    }

    public Date getNgayTC() {
        return NgayTC;
    }

    public void setNgayTC(Date NgayTC) {
        this.NgayTC = NgayTC;
    }

    public Float getSoGio() {
        return SoGio;
    }

    public void setSoGio(Float SoGio) {
        this.SoGio = SoGio;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}
