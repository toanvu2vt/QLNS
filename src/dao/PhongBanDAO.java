/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.QLNSDAO;
import entity.KTKL;
import entity.PhongBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ToanVu
 */
public class PhongBanDAO extends QLNSDAO<PhongBan, String>{
        public void insert(PhongBan model){
        String sql="INSERT INTO PhongBan (IDPB, TenPB) VALUES (?, ?)";
        XJdbc.update(sql, 
                model.getIDPB(), 
                model.getTenPB());
    }
    
    public void update(PhongBan model){
        String sql="UPDATE PhongBan TenPB=? WHERE  IDPB=?";
        XJdbc.update(sql, 
                model.getTenPB(),
                model.getIDPB());
    }
    
    public void delete(String id){
        String sql="DELETE FROM PhongBan WHERE IDPB=?";
        XJdbc.update(sql, id);
    }
    public List<PhongBan> selectAll(){
        String sql="SELECT * FROM PhongBan";
        return selectBySql(sql);
    }
    
    public PhongBan selectById(String manh){
        String sql="SELECT * FROM PhongBan WHERE IDPB=?";
        List<PhongBan> list = selectBySql(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<String> selectAllTenPB(){
        String sql = "SELECT DISTINCT TenPB FROM PhongBan";
        List list = new ArrayList();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, new Object[0]);
                while(rs.next()){
                    list.add(rs.getString("TenPB"));
                }
            } finally {
                if(rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    protected List<PhongBan> selectBySql(String sql, Object...args){
        List<PhongBan> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    PhongBan entity=new PhongBan();
                    entity.setIDPB(rs.getString("IDPB"));
                    entity.setTenPB(rs.getString("TenPB"));
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

    public List<PhongBan> selectByTenPB(String TenPB){
        String sql = "SELECT * FROM PhongBan WHERE TenPB LIKE ?";
        return selectBySql(sql, new Object[]{"%" + TenPB + "%"});
    }
 
   public List<String> selectAllIDPB(){
        String sql = "SELECT DISTINCT IDPB FROM PhongBan";
        List list = new ArrayList();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, new Object[0]);
                while(rs.next()){
                    list.add(rs.getString("IDPB"));
                }
            } finally {
                if(rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
