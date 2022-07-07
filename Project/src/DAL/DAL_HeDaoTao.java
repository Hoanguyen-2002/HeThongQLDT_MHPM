
package DAL;

import DBO.DBO_HE_DAO_TAO;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


 class DAL_HeDaoTao extends DataAccessHelper {
    MyMethod method = new MyMethod();
    CallableStatement store_proc = null;
    ResultSet rs = null;
    
    public ArrayList<DBO_HE_DAO_TAO> getAllHeDaoTao() {
        ArrayList<DBO_HE_DAO_TAO> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_GetAll()}");
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HE_DAO_TAO item = new DBO_HE_DAO_TAO();
                    item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                    item.setTenHeDaoTao(rs.getString("TenHeDaoTao"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao getAll() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_HE_DAO_TAO> getAllHeDaoTao_dk(String MaHeDaoTao) {
        ArrayList<DBO_HE_DAO_TAO> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_Get_dk(?)}");
            store_proc.setString(1, MaHeDaoTao);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_HE_DAO_TAO item = new DBO_HE_DAO_TAO();
                item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                item.setTenHeDaoTao(rs.getString("TenHeDaoTao"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao getAllHeDaoTao_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Insert(DBO_HE_DAO_TAO obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_InsertItem(?,?)}");
            store_proc.setString(1, obj.getMaHeDaoTao());
            store_proc.setString(2, obj.getTenHeDaoTao());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao insert() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_HE_DAO_TAO obj, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_UpdateItem(?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, obj.getMaHeDaoTao());
            store_proc.setString(3, obj.getTenHeDaoTao());
            
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao update() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String MaHeDaoTao) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_DeleteItem(?)}");
            store_proc.setString(1, MaHeDaoTao);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            method.showMessegaWa("Dữ liệu chưa thể xóa, có tồn tại hệ đào tạo này, hãy xóa dữ liệu sinh viên trước");

        } catch (Exception e) {
            method.showMessegaWa("DAL_sv Delete() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public ArrayList<DBO_HE_DAO_TAO> Check_HeDaoTao(String MaHeDaoTao) {
        ArrayList<DBO_HE_DAO_TAO> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_Get_dk(?)}");
            store_proc.setString(1, MaHeDaoTao);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HE_DAO_TAO item = new DBO_HE_DAO_TAO();
                    item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                    item.setTenHeDaoTao(rs.getString("TenHeDaoTao"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao getAllHeDaoTao_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MaHeDaoTao) {
        ArrayList<DBO_HE_DAO_TAO> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_HeDaoTao_Get_dk(?)}");
            store_proc.setString(1, MaHeDaoTao);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_HE_DAO_TAO item = new DBO_HE_DAO_TAO();
                    item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_HeDaoTao getAllHeDaoTao_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
