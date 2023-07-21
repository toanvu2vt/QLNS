/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.BangCong;
import entity.BaoHiem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ADMIN
 */
public class BaoHiemDAO {
    
    public void insert(BaoHiem model){
        String sql="INSERT INTO BaoHiem ( SoBH, NgayCap, NoiCap, NoiKhamBenh, MaNV) VALUES ( ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                model.getSoBH(), 
                model.getNgayCap(), 
                model.getNoiCap(), 
                model.getNoiKhamBenh(),
                model.getMaNV()
        );
    }
    
    public void update(BaoHiem model){
        String sql="UPDATE BaoHiem SET NgayCap=?, NoiCap=?, NoiKhamBenh=?, MaNV=? where SoBH=?";
        XJdbc.update(sql, new Object[]{
            model.getNgayCap(), 
            model.getNoiCap(), 
            model.getNoiKhamBenh(),
            model.getMaNV(),
            model.getSoBH()
        });
    }
    
    public void delete(String sobh){
        String sql="DELETE FROM BaoHIem WHERE SoBH=?";
        XJdbc.update(sql, sobh);
    }
    
    public List<BaoHiem> selectAll(){
        String sql="SELECT * FROM BaoHiem ORDER BY MANV ASC";
        return selectBySql(sql);
    }
    
    public BaoHiem selectById(String sobh){
        String sql="SELECT * FROM BaoHiem WHERE SoBH=?";
        List<BaoHiem> list = selectBySql(sql, sobh);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<BaoHiem> selectByKeyword(String keyword){
        String sql="SELECT * FROM BaoHiem WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
     protected List<BaoHiem> selectBySql(String sql, Object...args){
        List<BaoHiem> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    BaoHiem entity=new BaoHiem();
                    entity.setSoBH(rs.getString("SoBH"));
                    entity.setNgayCap(rs.getDate("NgayCap"));
                    entity.setNoiCap(rs.getString("NoiCap"));
                    entity.setNoiKhamBenh(rs.getString("NoiKhamBenh"));
                    entity.setMaNV(rs.getString("MaNV"));
                    list.add(entity);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
