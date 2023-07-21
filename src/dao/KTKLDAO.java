/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.QLNSDAO;
import entity.KTKL;
import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ToanVu
 */
public class KTKLDAO extends QLNSDAO<KTKL, String>{ 
    public void insert(KTKL model){
        String sql="INSERT INTO KTKL (ID, NoiDung, Ngay, Loai, MaNV) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getIDKTKL(), 
                model.getNoiDung(), 
                model.getNgay(), 
                model.getLoai(),
                model.getMaNV());
    }
    
    public void update(KTKL model){
        String sql="UPDATE KTKL SET NoiDung=?, Ngay=?, Loai=?, MaNV=? WHERE  ID=?";
        XJdbc.update(sql, 
                model.getNoiDung(), 
                model.getNgay(), 
                model.getLoai(),
                model.getMaNV(),
                model.getIDKTKL());
    }
    
    public void delete(String id){
        String sql="DELETE FROM KTKL WHERE ID=?";
        XJdbc.update(sql, id);
    }
    public List<KTKL> selectAll(){
        String sql="SELECT * FROM KTKL";
        return selectBySql(sql);
    }
    
    public KTKL selectById(String manh){
        String sql="SELECT * FROM KTKL WHERE ID=?";
        List<KTKL> list = selectBySql(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<KTKL> selectBySql(String sql, Object...args){
        List<KTKL> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    KTKL entity=new KTKL();
                    entity.setIDKTKL(rs.getString("ID"));
                    entity.setNoiDung(rs.getString("NoiDung"));
                    entity.setNgay(rs.getDate("Ngay"));
                    entity.setLoai(rs.getBoolean("Loai"));
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
    
    public List<KTKL> selectByKeyword(String keyword){
        String sql="SELECT * FROM KTKL WHERE ID LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
