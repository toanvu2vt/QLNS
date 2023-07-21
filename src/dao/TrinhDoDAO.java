/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.TrinhDo;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public class TrinhDoDAO{

   

    
    protected List<TrinhDo> selectBySql(String sql, Object...args){
        List<TrinhDo> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    TrinhDo entity=new TrinhDo();
                    entity.setIDTD(rs.getInt("IDTD"));
                    entity.setTenTD(rs.getString("TenTrinhDo"));
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
    public List<Integer> selectAllIDTD(){
        String sql = "SELECT DISTINCT IDTD FROM TrinhDo";
        List list = new ArrayList();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, new Object[0]);
                while(rs.next()){
                    list.add(rs.getInt("IDTD"));
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
