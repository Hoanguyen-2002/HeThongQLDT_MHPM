package DAL;



public class DAL_SinhVien extends DataAccessHelper {

    MyMethod method = new MyMethod();
    DBO_SINH_VIEN diem = new DBO_SINH_VIEN();
    CallableStatement store_proc = null;
    ResultSet rs = null;
    java.sql.Date sqlDate;

    public ArrayList<DBO_SINH_VIEN> getAllSinhVien() {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll()}");
            rs = store_proc.executeQuery();
            //PreparedStatement ps = cnn.prepareStatement("select * from SINH_VIEN");
//            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    item.setHoTenSinhVien(rs.getString("HoTenSinhVien"));
                    item.setNgaySinh(new Date(rs.getDate("NgaySinh").getTime()));
                    item.setGioiTinh(rs.getBoolean("GioiTinh"));
                    item.setMaLop(rs.getString("MaLop"));
                    item.setSoDienThoai(rs.getString("SoDienThoai"));
                    item.setMatKhau(rs.getString("MatKhau"));
                    item.setEmail(rs.getString("Email"));
                    item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                    item.setThoiGianHoc(rs.getString("ThoiGianHoc"));
                    item.setSoDienThoaiGiaDinh(rs.getString("SoDienThoaiGiaDinh"));
                    item.setHoTenBo(rs.getString("HoTenBo"));
                    item.setHoTenMe(rs.getString("HoTenMe"));
                    item.setNoiSinh(rs.getString("NoiSinh"));
                    item.setNgayNhapHoc(new Date(rs.getDate("NgayNhapHoc").getTime()));

                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_Sv getAll() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_SINH_VIEN> getAllSinhVien_dk(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null && rs.next()) {
                DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                item.setMaSinhVien(rs.getString("MaSinhVien"));
                item.setHoTenSinhVien(rs.getString("HoTenSinhVien"));
                item.setNgaySinh(new Date(rs.getDate("NgaySinh").getTime()));
                item.setGioiTinh(rs.getBoolean("GioiTinh"));
                item.setMaLop(rs.getString("MaLop"));
                item.setSoDienThoai(rs.getString("SoDienThoai"));
                item.setMatKhau(rs.getString("MatKhau"));
                item.setEmail(rs.getString("Email"));
                item.setMaHeDaoTao(rs.getString("MaHeDaoTao"));
                item.setThoiGianHoc(rs.getString("ThoiGianHoc"));
                item.setSoDienThoaiGiaDinh(rs.getString("SoDienThoaiGiaDinh"));
                item.setHoTenBo(rs.getString("HoTenBo"));
                item.setHoTenMe(rs.getString("HoTenMe"));
                item.setNoiSinh(rs.getString("NoiSinh"));
                item.setNgayNhapHoc(new Date(rs.getDate("NgayNhapHoc").getTime()));

                objs.add(item);
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv getAllsv_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public ArrayList<DBO_SINH_VIEN> Check_SV(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllsv_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        return objs;
    }

    public boolean Check(String MSSV) {
        ArrayList<DBO_SINH_VIEN> objs = new ArrayList<>();
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_GetAll_dk(?)}");
            store_proc.setString(1, MSSV);
            rs = store_proc.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DBO_SINH_VIEN item = new DBO_SINH_VIEN();
                    item.setMaSinhVien(rs.getString("MaSinhVien"));
                    objs.add(item);
                }
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_GetAllsv_dk() Có Lỗi : " + e.toString());
        }
        getClose();
        if (objs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Insert(DBO_SINH_VIEN obj) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_InsertItem(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            store_proc.setString(1, obj.getMaSinhVien());
            store_proc.setString(2, obj.getHoTenSinhVien());
            sqlDate = new java.sql.Date(obj.getNgaySinh().getTime());
            store_proc.setDate(3, sqlDate);
            store_proc.setBoolean(4, obj.isGioiTinh());
            store_proc.setString(5, obj.getMaLop());
            store_proc.setString(6, obj.getSoDienThoai());
            store_proc.setString(7, obj.getMatKhau());
            store_proc.setString(8, obj.getEmail());
            store_proc.setString(9, obj.getMaHeDaoTao());
            store_proc.setString(10, obj.getThoiGianHoc());
            store_proc.setString(11, obj.getSoDienThoaiGiaDinh());
            store_proc.setString(12, obj.getHoTenBo());
            store_proc.setString(13, obj.getHoTenMe());
            store_proc.setString(14, obj.getNoiSinh());
            sqlDate = new java.sql.Date(obj.getNgayNhapHoc().getTime());
            store_proc.setDate(15, sqlDate);

            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv insert() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Update(DBO_SINH_VIEN obj, String dk) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call  sp_qldsv_SinhVien_UpdateItem(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            store_proc.setString(1, dk);
            store_proc.setString(2, obj.getMaSinhVien());
            store_proc.setString(3, obj.getHoTenSinhVien());
            sqlDate = new java.sql.Date(obj.getNgaySinh().getTime());
            store_proc.setDate(4, sqlDate);
            store_proc.setBoolean(5, obj.isGioiTinh());
            store_proc.setString(6, obj.getMaLop());
            store_proc.setString(7, obj.getSoDienThoai());
            store_proc.setString(8, obj.getMatKhau());
            store_proc.setString(9, obj.getEmail());
            store_proc.setString(10, obj.getMaHeDaoTao());
            store_proc.setString(11, obj.getThoiGianHoc());
            store_proc.setString(12, obj.getSoDienThoaiGiaDinh());
            store_proc.setString(13, obj.getHoTenBo());
            store_proc.setString(14, obj.getHoTenMe());
            store_proc.setString(15, obj.getNoiSinh());
            sqlDate = new java.sql.Date(obj.getNgayNhapHoc().getTime());
            store_proc.setDate(16, sqlDate);

            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (Exception e) {
            method.showMessegaWa("DAL_sv update() Có Lỗi : " + e.toString());
        }
        getClose();
        return check;
    }

    public boolean Delete(String MaGiangVien) {
        boolean check = false;
        try {
            getConnect();
            store_proc = cnn.prepareCall("{call sp_qldsv_SinhVien_DeleteItem(?)}");
            store_proc.setString(1, MaGiangVien);
            int rs = store_proc.executeUpdate();
            if (rs > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            method.showMessegaWa("Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước");

        } catch (Exception e) {
            method.showMessegaWa("DAL_sv Delete() Có Lỗi : " + e.toString());
        }

        getClose();
        return check;
    }
}
