/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.HopDong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ADMIN
 */
public class HopDongDAO {
   public void insert(HopDong model){
       String sql =" INSERT INTO HopDong (IDHD,NgayBD,NgayKT,NgayKy,NoiDung,MaNV,MucLuong) VALUES (?,?,?,?,?,?,?)";
       XJdbc.update(sql,
               model.getIDHD(),
               model.getNgayBD(),
               model.getNgayKT(),
               model.getNgayKY(),
               model.getNoiDung(),
               model.getMaNV(),
               model.getMucLuong()
       );
   }
   public void update(HopDong model){
        String sql ="UPDATE HopDong set NgayBD=?,NgayKT=?,NgayKy=?,NoiDung=?,MaNV=?,MucLuong=? WHERE IDHD= ?";
        XJdbc.update(sql, 
          model.getNgayBD(),
          model.getNgayKT(),
          model.getNgayKY(),
          model.getNoiDung(),
          model.getMaNV(),
          model.getMucLuong(),
          model.getIDHD()
                );
   }
   public void delete(Integer idhd){
        String sql ="DELETE HopDong Where IDHD=?";
        XJdbc.update(sql, idhd); 
   }
   public List<HopDong> selectAll(){
    String sql = "SELECT * FROM HopDong"; 
   return  selectBySql(sql);
   }
  public HopDong selectById(String idhd){
      String sql ="SELECT * FROM HOPDONG WHERE IDHD=?";
      List<HopDong> list = selectBySql(sql, idhd);
        return list.size() > 0 ? list.get(0) : null;
    }
    protected List<HopDong> selectBySql(String sql, Object...args){
      List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                HopDong entity = new HopDong();
                entity.setIDHD(rs.getString("IDHD"));
                entity.setNgayBD(rs.getDate("NgayBD"));
                entity.setNgayKT(rs.getDate("NgayKT"));
                entity.setNgayKY(rs.getDate("NgayKy"));
                entity.setNoiDung(rs.getString("NoiDung"));
                entity.setMucLuong(rs.getInt("MucLuong"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw  new RuntimeException(ex);
        }
             return list;
        }
     public List<HopDong> selectByKeyword(String keyword){
        String sql="SELECT * FROM HopDong WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
