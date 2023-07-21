/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import util.XJdbc;
import java.sql.ResultSet;
/**
 *
 * @author ADMIN
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object[] args){
        try {
            List list = new ArrayList();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
            }
            list.add(vals);
        }
        rs.getStatement().getConnection().close();
        return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getGioLam(){
        String sql = " {call sp_ThongKeGioLam}"; 
        String[] cols ={"MaNV","HoTen","GioLam","SoGio","TongGio"};
        return getListOfArray(sql, cols, new Object[0]);
    }
    public List<Object[]> getLuong(){
        String sql =" {call sp_ThongKeLuong}";
        String[] cols ={"MaNV","HoTen","MucLuong","GioTangCa","TienPhuCap","TongTien"};
        return  getListOfArray(sql, cols, new Object[0]);
    }
    
      public List<Object[]> getPhongBan(String mapb) {
       
       String sql = "{CALL sp_PhongBan (?)}";
       String[] cols = { "MaNV", "HoTen", "IDPB", "TenPB" };
       return getListOfArray(sql, cols, new Object[] { String.valueOf(mapb) });
    }
        public List<Object[]> getBoPhan(String maBP) {
       
       String sql = "{CALL sp_BoPhan (?)}";
       String[] cols = { "MaNV", "HoTen", "IDBP", "TenBP" };
       return getListOfArray(sql, cols, new Object[] { String.valueOf(maBP) });
    }
        public List<Object[]> getTrinhDo(int id) {
       
       String sql = "{CALL sp_TrinhDo (?)}";
       String[] cols = { "MaNV", "HoTen", "IDTD", "TenTD" };
       return getListOfArray(sql, cols, new Object[] { Integer.valueOf(id) });
    }
}
