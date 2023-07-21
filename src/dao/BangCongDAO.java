/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.BangCong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;


/**
 *
 * @author ADMIN
 */
public class BangCongDAO {
    protected List<BangCong> selectBySql(String sql,Object...args){
        ArrayList<BangCong> list = new ArrayList<>();
        try {
             ResultSet rs = null;
             try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                  BangCong model = new BangCong();
                  model.setMaBC(rs.getString("MaBC"));
                  model.setNgay(rs.getDate("NgayTao"));
                  model.setGioLam(rs.getFloat("GioLam"));
                  model.setMaNV(rs.getString("MaNV"));
                  list.add(model);
                }
            } finally {
                 rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw  new RuntimeException(ex);
        }
        return  list;
    }
    public List<BangCong> selectAll(){
        String sql = "select * from BangCong";
        return selectBySql(sql);
    }
    public BangCong selectByMaBC(String mabc){
        String sql ="select * from BangCong where MaBC =?";
        List<BangCong> list = selectBySql(sql, mabc);
        return list.size()>0 ? list.get(0) : null;
    }
   public List<BangCong> selectByKeyword(String keyword){
        String sql="SELECT * FROM BangCong WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
 
    public void insert(BangCong model){
        String sql = "insert into BangCong (MaBC,NgayTao,GioLam,MaNV) values (?,?,?,?)";
        XJdbc.update(sql, new Object[]{
        model.getMaBC(),
        model.getNgay(),
        model.getGioLam(),
        model.getMaNV()
        });
    }
    public void update(BangCong model){
    String sql ="update BangCong set NgayTao=?, GioLam=?, MaNV=? where MaBC=?";
    XJdbc.update(sql, new Object[]{
        model.getNgay(),
        model.getGioLam(),
        model.getMaNV(),
        model.getMaBC()
    });
    }
    
    public void delete(String mabc){
        String sql ="delete from BangCong where MaBC=?";
        XJdbc.update(sql, mabc);
    }

}
