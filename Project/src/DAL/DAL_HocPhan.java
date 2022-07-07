package DAL;

import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import DBO.DBO_HOC_PHAN;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAL_HocPhan extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_HOC_PHAN> getAllHocPhan() {
        ArrayList<DBO_HOC_PHAN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_GetAll()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HOC_PHAN item = new DBO_HOC_PHAN();
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setTenHocPhan(rs.getString("TenHocPhan"));
                    item.setSoTinChi(rs.getInt("SoTinChi"));
                    item.setPhongHoc(rs.getString("PhongHoc"));
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    item.setNamHoc(rs.getInt("NamHoc"));                                      
                    item.setTenHocKy(rs.getInt("TenHocKy"));
                    item.setSoTietHoc(rs.getInt("SoTietHoc"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HocPhan getAll() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_HOC_PHAN> getSearchHocPhan(String chuoitimkiem) {
        ArrayList<DBO_HOC_PHAN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Search_HocPhan(?)}");
            store_proc.setString(1, chuoitimkiem);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HOC_PHAN item = new DBO_HOC_PHAN();
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setTenHocPhan(rs.getString("TenHocPhan"));
                    item.setSoTinChi(rs.getInt("SoTinChi"));
                    item.setPhongHoc(rs.getString("PhongHoc"));
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    item.setNamHoc(rs.getInt("NamHoc"));                                      
                    item.setTenHocKy(rs.getInt("TenHocKy"));
                    item.setSoTietHoc(rs.getInt("SoTietHoc"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HocPhan getSearch() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_HOC_PHAN> getAllhocPhan_dk(String MaHocPhan) {
        ArrayList<DBO_HOC_PHAN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_GetAll_dk(?)}");
            store_proc.setString(1, MaHocPhan);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_HOC_PHAN item = new DBO_HOC_PHAN();
                item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setTenHocPhan(rs.getString("TenHocPhan"));
                    item.setSoTinChi(rs.getInt("SoTinChi"));
                    item.setPhongHoc(rs.getString("PhongHoc"));
                    item.setMaGiangVien(rs.getString("MaGiangVien"));
                    item.setNamHoc(rs.getInt("NamHoc"));                                      
                    item.setTenHocKy(rs.getInt("TenHocKy"));
                    item.setSoTietHoc(rs.getInt("SoTietHoc"));
                    objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HocPhan getAllLop() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    // Khiểm tra sự tồn tại của Hojc Phaanf trong database
    public ArrayList<DBO_HOC_PHAN> Check_HocPhan(String MaHP) {
        ArrayList<DBO_HOC_PHAN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_GetAll_dk(?)}");
            store_proc.setString(1, MaHP);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HOC_PHAN item = new DBO_HOC_PHAN();
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_hocPhan check HP dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MaHP) {
        ArrayList<DBO_HOC_PHAN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_GetAll_dk(?)}");
            store_proc.setString(1, MaHP);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HOC_PHAN item = new DBO_HOC_PHAN();
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_hocPhan check HP dk() Có Lỗi : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Insert(DBO_HOC_PHAN item) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_InsertItem(?,?,?,?,?,?,?,?)}");
            store_proc.setString(1, item.getMaHocPhan());
            store_proc.setString(2, item.getTenHocPhan());
            store_proc.setInt(3, item.getSoTinChi());
            store_proc.setString(4, item.getPhongHoc());
            store_proc.setString(5, item.getMaGiangVien());
            store_proc.setInt(6, item.getNamHoc());
            store_proc.setInt(7, item.getTenHocKy());
            store_proc.setInt(8, item.getSoTietHoc());          
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HP insert() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    // update dữ liệu
    public boolean Update(DBO_HOC_PHAN item, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_UpdateItem(?,?,?,?,?,?,?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, item.getMaHocPhan());
            store_proc.setString(3, item.getTenHocPhan());
            store_proc.setInt(4, item.getSoTinChi());
            store_proc.setString(5, item.getPhongHoc());
            store_proc.setString(6, item.getMaGiangVien());
            store_proc.setInt(7, item.getNamHoc());
            store_proc.setInt(8, item.getTenHocKy());
            store_proc.setInt(9, item.getSoTietHoc());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HP update Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    // Delete Item in table on database
    public boolean Delete(String MaHP) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HocPhan_DeleteItem(?)}");
            store_proc.setString(1, MaHP);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            method.showMessegaWa("Dữ liệu chưa thể xóa, có tồn tại điểm của môn này, hãy xóa dữ liệu điểm trước");

        } catch (Exception e) {
            method.showMessegaWa("DAL_sv Delete() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public ArrayList<Integer> getYear() {
        ArrayList<Integer> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_View_Year()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int item = rs.getInt("NamHoc");
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HocPhan getYear() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }
}
