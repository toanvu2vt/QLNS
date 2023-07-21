/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.QLNSDAO;
import entity.BoPhan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ToanVu
 */
public class BoPhanDAO extends QLNSDAO<BoPhan, String>{
            public void insert(BoPhan model){
        String sql="INSERT INTO BoPhan (IDBP, TenBP) VALUES (?, ?)";
        XJdbc.update(sql, 
                model.getIDBP(), 
                model.getTenBP());
    }
    
    public void update(BoPhan model){
        String sql="UPDATE BoPhan TenBP=? WHERE  IDBP=?";
        XJdbc.update(sql, 
                model.getIDBP(),
                model.getTenBP());
    }
    
    public void delete(String id){
        String sql="DELETE FROM BoPhan WHERE IDBP=?";
        XJdbc.update(sql, id);
    }
    public List<BoPhan> selectAll(){
        String sql="SELECT * FROM BoPhan";
        return selectBySql(sql);
    }
    
    public BoPhan selectById(String manh){
        String sql="SELECT * FROM BoPhan WHERE IDBP=?";
        List<BoPhan> list = selectBySql(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<String> selectAllTenBP(){
        String sql = "SELECT DISTINCT TenBP FROM BoPhan";
        List list = new ArrayList();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, new Object[0]);
                while(rs.next()){
                    list.add(rs.getString("TenBP"));
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
    
    
    protected List<BoPhan> selectBySql(String sql, Object...args){
        List<BoPhan> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    BoPhan entity=new BoPhan();
                    entity.setIDBP(rs.getString("IDBP"));
                    entity.setTenBP(rs.getString("TenBP"));
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
    
    public List<BoPhan> selectByTenBP(String TenBP){
        String sql = "SELECT * FROM BoPhan WHERE TenBP LIKE ?";
        return selectBySql(sql, new Object[]{"%" + TenBP + "%"});
    }
      public List<String> selectAllIDBP(){
        String sql = "SELECT DISTINCT IDBP FROM BoPhan";
        List list = new ArrayList();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, new Object[0]);
                while(rs.next()){
                    list.add(rs.getString("IDBP"));
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
