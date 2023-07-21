/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.TangCa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author ADMIN
 */
public class TangCaDAO {
    protected List<TangCa> selectBySql(String sql,Object...args){
        ArrayList<TangCa> list = new ArrayList<>();
        try {
             ResultSet rs = null;
             try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                  TangCa model = new TangCa();
                  model.setIDTC(rs.getString("IDTC"));
                  model.setNgayTC(rs.getDate("NgayTangCa"));
                  model.setSoGio(rs.getFloat("SoGio"));
                  model.setLoaiCa(rs.getBoolean("LoaiCa"));
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
    public List<TangCa> selectAll(){
        String sql = "select * from TangCa";
        return selectBySql(sql);
    }
    public TangCa selectByIDTC(String idtc){
        String sql ="select * from TangCa where IDTC =?";
        List<TangCa> list = selectBySql(sql, idtc);
        return list.size()>0 ? list.get(0) : null;
    }
    public List<TangCa> selectByLoaiCa(String loaica){
        String sql ="select * from TangCa where LoaiCa = ?";
        return selectBySql(sql, loaica);
    }
    public void insert(TangCa model){
        String sql = "insert into TangCa (IDTC,NgayTangCa,SoGio,LoaiCa,MaNV) values (?,?,?,?,?)";
        XJdbc.update(sql, new Object[]{
        model.getIDTC(),
        model.getNgayTC(),
        model.getSoGio(),
        model.getLoaiCa(),
        model.getMaNV()
        });
    }
    public void update(TangCa model){
    String sql ="update TangCa set NgayTangCa=?, SoGio=?, LoaiCa=?,MaNV=? where IDTC=?";
    XJdbc.update(sql, new Object[]{
        model.getNgayTC(),
        model.getSoGio(),
        model.getLoaiCa(),
        model.getMaNV(),
        model.getIDTC()
    });
    }
    public void delete(String idtc){
        String sql ="delete from TangCa where idtc=?";
        XJdbc.update(sql, idtc);
    }
    public List<TangCa> selectByKeyword(String keyword){
        String sql="SELECT * FROM TangCa WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
