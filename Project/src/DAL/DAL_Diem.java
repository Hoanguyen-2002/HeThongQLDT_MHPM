package DAL;

import DBO.DBO_DIEM;
import MeThodShow.MyMethod;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DAL_Diem extends DataAccessHelper {

    MyMethod method = new MyMethod();
    DBO_DIEM diem = new DBO_DIEM();
    CallableStatement store_proc = null;
    ResultSet rs = null;

    public ArrayList<DBO_DIEM> getAllDiem() {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_GetAll()}");
            rs = store_proc.executeQuery();
            //PreparedStatement ps = cnn.prepareStatement("select * from SINH_VIEN");
//            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_DIEM item = new DBO_DIEM();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setDiemC(rs.getFloat("DiemC"));
                    item.setDiemB(rs.getFloat("DiemB"));
                    item.setDiemTL1(rs.getFloat("DiemTL1"));
                    item.setDiemTL2(rs.getFloat("DiemTL2"));
                    item.setDiem_Trung_Binh(rs.getFloat("Diem_Trung_Binh"));
                    item.setDiem_Chu(rs.getString("Diem_Chu"));
                    item.setXoa(rs.getBoolean("Xoa"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem getAll() Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_DIEM> getAllDiem_dk_mssv(String mssv) {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_GetAll_mssv(?)}");
            store_proc.setString(1, mssv);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_DIEM item = new DBO_DIEM();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    item.setMaHocPhan(rs.getString("MaHocPhan"));
                    item.setDiemC(rs.getFloat("DiemC"));
                    item.setDiemB(rs.getFloat("DiemB"));
                    item.setDiemTL1(rs.getFloat("DiemTL1"));
                    item.setDiemTL2(rs.getFloat("DiemTL2"));
                    item.setDiem_Trung_Binh(rs.getFloat("Diem_Trung_Binh"));
                    item.setDiem_Chu(rs.getString("Diem_Chu"));
                    item.setXoa(rs.getBoolean("Xoa"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem getAll dk mssv Error : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_DIEM> getAllDiem_dk(String idDiem) {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_GetAll_dk(?)}");
            store_proc.setString(1, idDiem);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_DIEM item = new DBO_DIEM();
                item.setMaSinhVien(rs.getString("MaSinhVien"));
                item.setMaHocPhan(rs.getString("MaHocPhan"));
                item.setDiemC(rs.getFloat("DiemC"));
                item.setDiemB(rs.getFloat("DiemB"));
                item.setDiemTL1(rs.getFloat("DiemTL1"));
                item.setDiemTL2(rs.getFloat("DiemTL2"));
                item.setDiem_Trung_Binh(rs.getFloat("Diem_Trung_Binh"));
                item.setDiem_Chu(rs.getString("Diem_Chu"));
                item.setXoa(rs.getBoolean("Xoa"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem getAllsv_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_DIEM> getAllDiem_infor(String mssv, String mahp) {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_GetInfor(?,?)}");
            store_proc.setString(1, mssv);
            store_proc.setString(2, mahp);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_DIEM item = new DBO_DIEM();
                item.setMaSinhVien(rs.getString("MaSinhVien"));
                item.setMaHocPhan(rs.getString("MaHocPhan"));
                item.setDiemC(rs.getFloat("DiemC"));
                item.setDiemB(rs.getFloat("DiemB"));
                item.setDiemTL1(rs.getFloat("DiemTL1"));
                item.setDiemTL2(rs.getFloat("DiemTL2"));
                item.setDiem_Trung_Binh(rs.getFloat("Diem_Trung_Binh"));
                item.setDiem_Chu(rs.getString("Diem_Chu"));
                item.setXoa(rs.getBoolean("Xoa"));
                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem getAllsv_infor() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_DIEM> Check_Diem(String mssv, String mahocphan) {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_Check(?,?)}");
            store_proc.setString(1, mssv);
            store_proc.setString(2, mahocphan);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_DIEM item = new DBO_DIEM();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Check Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String mssv, String mahocphan) {
        ArrayList<DBO_DIEM> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_Check(?,?)}");
            store_proc.setString(1, mssv);
            store_proc.setString(2, mahocphan);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_DIEM item = new DBO_DIEM();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Check Có Lỗi : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Insert(DBO_DIEM obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_InsertItem(?,?,?,?,?,?)}");
            store_proc.setString(1, obj.getMaSinhVien());
            store_proc.setString(2, obj.getMaHocPhan());
            store_proc.setFloat(3, obj.getDiemC());
            store_proc.setFloat(4, obj.getDiemB());
            store_proc.setFloat(5, obj.getDiemTL1());
            store_proc.setFloat(6, obj.getDiemTL2());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem insert() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_DIEM obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call  sp_qldsv_Diem_UpdateItem(?,?,?,?,?,?,?)}");
            store_proc.setString(1, obj.getMaSinhVien());
            store_proc.setString(2, obj.getMaHocPhan());
            store_proc.setFloat(3, obj.getDiemC());
            store_proc.setFloat(4, obj.getDiemB());
            store_proc.setFloat(5, obj.getDiemTL1());
            store_proc.setFloat(6, obj.getDiemTL2());
            store_proc.setBoolean(7, obj.isXoa());
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_diem update() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String mssv, String mahocphan) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_Diem_DeleteItem(?,?)}");
            store_proc.setString(1, mssv);
            store_proc.setString(2, mahocphan);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Diem Delete() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }
}
