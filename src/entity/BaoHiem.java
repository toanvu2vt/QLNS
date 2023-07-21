/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import util.XDate;
/**
 *
 * @author ADMIN
 */
public class BaoHiem {
    private String SoBH;
    private Date NgayCap = new Date(); 
    private String NoiCap;
    private String NoiKhamBenh;
    private String MaNV;

    public Date getNgayCap() {
        return NgayCap;
    }

    public void setNgayCap(Date NgayCap) {
        this.NgayCap = NgayCap;
    }
   
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }


    public String getSoBH() {
        return SoBH;
    }

    public void setSoBH(String SoBH) {
        this.SoBH = SoBH;
    }

    public String getNoiCap() {
        return NoiCap;
    }

    public void setNoiCap(String NoiCap) {
        this.NoiCap = NoiCap;
    }

    public String getNoiKhamBenh() {
        return NoiKhamBenh;
    }

    public void setNoiKhamBenh(String NoiKhamBenh) {
        this.NoiKhamBenh = NoiKhamBenh;
    }
    
    
}
