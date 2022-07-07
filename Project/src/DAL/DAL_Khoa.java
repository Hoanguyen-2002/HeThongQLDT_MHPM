package DAL;

import DBO.DBO_KHOA;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

 class DAL_Khoa extends DataAccessHelper {

    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_KHOA> getAllKhoa() {
        ArrayList<DBO_KHOA> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_GetAll()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_KHOA item = new DBO_KHOA();
                    item.setMaKhoa(rs.getString("MaKhoa"));
                    item.setTenKhoa(rs.getString("TenKhoa"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa getAll() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_KHOA> getAllKhoa_dk(String MaKhoa) {
        ArrayList<DBO_KHOA> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_Get_dk(?)}");
            store_proc.setString(1, MaKhoa);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_KHOA item = new DBO_KHOA();
                item.setMaKhoa(rs.getString("MaKhoa"));
                item.setTenKhoa(rs.getString("TenKhoa"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa getAllLop_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Insert(DBO_KHOA obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_InsertItem(?,?)}");
            store_proc.setString(1, obj.getMaKhoa());
            store_proc.setString(2, obj.getTenKhoa());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa insert() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_KHOA obj, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_UpdateItem(?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, obj.getMaKhoa());
            store_proc.setString(3, obj.getTenKhoa());

            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa update() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String MaKhoa) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_DeleteItem(?)}");
            store_proc.setString(1, MaKhoa);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            method.showMessegaWa("Dữ liệu chưa thể xóa, có tồn tại lớp này, hãy xóa dữ liệu lớp trước");

        } catch (Exception e) {
            method.showMessegaWa("DAL_sv Delete() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public ArrayList<DBO_KHOA> Check_Khoa(String MaKhoa) {
        ArrayList<DBO_KHOA> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_Get_dk(?)}");
            store_proc.setString(1, MaKhoa);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_KHOA item = new DBO_KHOA();
                    item.setMaKhoa(rs.getString("MaKhoa"));
                    item.setTenKhoa(rs.getString("TenKhoa"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa getAllKhoa_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MaKhoa) {
        ArrayList<DBO_KHOA> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Khoa_Get_dk(?)}");
            store_proc.setString(1, MaKhoa);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_KHOA item = new DBO_KHOA();
                    item.setMaKhoa(rs.getString("MaKhoa"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Khoa getAllKhoa_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
