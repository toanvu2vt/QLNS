package dao;

import util.XJdbc;
import entity.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends QLNSDAO<TaiKhoan, String>{
    public void insert(TaiKhoan model){
        String sql="INSERT INTO TaiKhoan (TenDN, Pass, VaiTro, MaNV) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql,  
                model.getTenDN(), 
                model.getMatKhau(), 
                model.getVaiTro(),
                model.getMaNV());             
    }
    
    public void update(TaiKhoan model){
        String sql="UPDATE TaiKhoan SET MaNV=?,Pass=?, VaiTro=? WHERE TenDN=?";
        XJdbc.update(sql, 
                model.getMaNV(), 
                model.getMatKhau(), 
                model.getVaiTro(),
                model.getTenDN());
    }
    
    public void delete(String MaNV){
        String sql="DELETE FROM TaiKhoan WHERE MaNV=?";
        XJdbc.update(sql, MaNV);
    }
    
    public List<TaiKhoan> selectAll(){
        String sql="SELECT * FROM TaiKhoan";
        return this.selectBySql(sql);
    }
    
    public TaiKhoan selectById(String manv){
        String sql="SELECT * FROM TaiKhoan WHERE MaNV=?";
        List<TaiKhoan> list = this.selectBySql(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
     public TaiKhoan selectByTen(String tendn){
        String sql="SELECT * FROM TaiKhoan WHERE TenDN=?";
        List<TaiKhoan> list = this.selectBySql(sql, tendn);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<TaiKhoan> selectBySql(String sql, Object...args){
        List<TaiKhoan> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                   TaiKhoan entity=new TaiKhoan();
                   entity.setTenDN(rs.getString("TenDN"));
                   entity.setMatKhau(rs.getString("Pass"));
                   entity.setVaiTro(rs.getBoolean("VaiTro"));
                   entity.setMaNV(rs.getString("MaNV"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
