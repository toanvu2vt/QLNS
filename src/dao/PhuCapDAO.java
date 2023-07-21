/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.PhuCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ToanVu
 */
public class PhuCapDAO extends QLNSDAO<PhuCap, String>{ 
    public void insert(PhuCap model){
        String sql="INSERT INTO PhuCap (IDPC, tenPC, ngay, soTien, MaNV) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getIDPC(), 
                model.getTen(), 
                model.getNgay(), 
                model.getSoTien(),
                model.getMaNV());
    }
    
    public void update(PhuCap model){
        String sql="UPDATE PhuCap SET tenPC=?, ngay=?, soTien=?, MaNV=? WHERE  IDPC=?";
        XJdbc.update(sql, 
                model.getTen(), 
                model.getNgay(), 
                model.getSoTien(),
                model.getMaNV(),
                model.getIDPC());
    }
    
    public void delete(String id){
        String sql="DELETE FROM PhuCap WHERE IDPC=?";
        XJdbc.update(sql, id);
    }
    public List<PhuCap> selectAll(){
        String sql="SELECT * FROM PhuCap";
        return selectBySql(sql);
    }
    
    public PhuCap selectById(String maul){
        String sql="SELECT * FROM PhuCap WHERE IDPC=?";
        List<PhuCap> list = selectBySql(sql, maul);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<PhuCap> selectBySql(String sql, Object...args){
        List<PhuCap> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    PhuCap entity=new PhuCap();
                    entity.setIDPC(rs.getString("IDPC"));
                    entity.setTen(rs.getString("TenPC"));
                    entity.setNgay(rs.getDate("Ngay"));
                    entity.setSoTien(rs.getDouble("SoTien"));
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
    
    public List<PhuCap> selectByKeyword(String keyword){
        String sql="SELECT * FROM PhuCap WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
