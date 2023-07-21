/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.QLNSDAO;
import entity.UngLuong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ToanVu
 */
public class UngLuongDAO extends QLNSDAO<UngLuong, String>{ 
    public void insert(UngLuong model){
        String sql="INSERT INTO UngLuong (IDUL, NgayUL, SoTien,TrangThai, MaNV) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getIDUL(), 
                model.getNgay(), 
                model.getSoTien(), 
                model.getTrangThai(),
                model.getMaNV());
    }
    
    public void update(UngLuong model){
        String sql="UPDATE UngLuong SET NgayUL=?, SoTien=?, TrangThai=?, MaNV=? WHERE  IDUL=?";
        XJdbc.update(sql, 
                model.getNgay(), 
                model.getSoTien(), 
                model.getTrangThai(),
                model.getMaNV(),
                model.getIDUL());
    }
    
    public void delete(String id){
        String sql="DELETE FROM UngLuong WHERE IDUL=?";
        XJdbc.update(sql, id);
    }
    public List<UngLuong> selectAll(){
        String sql="SELECT * FROM UngLuong";
        return selectBySql(sql);
    }
    
    public UngLuong selectById(String maul){
        String sql="SELECT * FROM UngLuong WHERE IDUL=?";
        List<UngLuong> list = selectBySql(sql, maul);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<UngLuong> selectBySql(String sql, Object...args){
        List<UngLuong> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    UngLuong entity=new UngLuong();
                    entity.setIDUL(rs.getString("IDUL"));
                    entity.setNgay(rs.getDate("NgayUL"));
                    entity.setSoTien(rs.getFloat("SoTien"));
                    entity.setTrangThai(rs.getBoolean("TrangThai"));
                    entity.setMaNV(rs.getString("MaNV"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public List<UngLuong> selectByKeyword(String keyword){
        String sql="SELECT * FROM UngLuong WHERE IDUL LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
