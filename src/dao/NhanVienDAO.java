package dao;

import dao.QLNSDAO;
import util.XJdbc;
import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QLNSDAO<NhanVien, String>{

    public void insert(NhanVien model){
        String sql="INSERT INTO NhanVien(MaNV, HoTen, GioiTinh, NgaySinh, DienThoai, CCCD, DiaChi, HinhAnh, IDPB, IDBP, IDTD) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaNV(), 
                model.getHoTen(), 
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getDienThoai(),                
                model.getCCCD(),
                model.getDiaChi(),
                model.getHinhAnh(),
                model.getIDPB(),
                model.getIDBP(),
                model.getIDTD()
        );
    }
    
    public void update(NhanVien model){
            String sql="UPDATE NhanVien SET HoTen=?, GioiTinh=?, NgaySinh=?, DienThoai=?, CCCD=?, DiaChi=?, HinhAnh=?, IDPB=?, IDBP=?, IDTD=? WHERE MaNV=?";        
            XJdbc.update(sql, 
                model.getHoTen(), 
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getDienThoai(),                
                model.getCCCD(),
                model.getDiaChi(),
                model.getHinhAnh(),
                model.getIDPB(),
                model.getIDBP(),
                model.getIDTD(),
                model.getMaNV()
            );
    }
    
    public void delete(String MaHV){
        String sql="DELETE FROM NhanVien WHERE MaNV=?";
        XJdbc.update(sql, MaHV);
    }
    
    public List<NhanVien> selectAll(){
        String sql="SELECT * FROM NhanVien";
        return selectBySql(sql);
    }
    
    public NhanVien selectById(String manv){
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = selectBySql(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<NhanVien> selectBySql(String sql, Object...args){
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setNgaySinh(rs.getDate("NgaySinh"));
                    entity.setDienThoai(rs.getString("DienThoai"));
                    entity.setCCCD(rs.getString("CCCD"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setHinhAnh(rs.getString("HinhAnh"));
                    entity.setIDPB(rs.getString("IDPB"));
                    entity.setIDBP(rs.getString("IDBP"));
                    entity.setIDTD(rs.getString("IDTD"));
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

    public List<NhanVien> selectByMaNhanVien(int maNV) {
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        return this.selectBySql(sql, maNV);
    }
    public List<NhanVien> selectByKeyword(String keyword){
        String sql="SELECT * FROM NhanVien WHERE HoTen LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }

}
