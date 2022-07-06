package DBO;

import java.util.Date;

public class DBO_HOC_PHAN {

    private String MaHocPhan;
    private String TenHocPhan;
    private int SoTinChi;
    private String PhongHoc;
    private String MaGiangVien;
    private int NamHoc;
    private int TenHocKy;
    private int SoTietHoc;

    public int getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(int NamHoc) {
        this.NamHoc = NamHoc;
    }

    public int getTenHocKy() {
        return TenHocKy;
    }

    public void setTenHocKy(int TenHocKy) {
        this.TenHocKy = TenHocKy;
    }

    public int getSoTietHoc() {
        return SoTietHoc;
    }

    public void setSoTietHoc(int SoTietHoc) {
        this.SoTietHoc = SoTietHoc;
    }

    public String getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(String MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }

    public String getTenHocPhan() {
        return TenHocPhan;
    }

    public void setTenHocPhan(String TenHocPhan) {
        this.TenHocPhan = TenHocPhan;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int SoTinChi) {
        this.SoTinChi = SoTinChi;
    }

    public String getPhongHoc() {
        return PhongHoc;
    }

    public void setPhongHoc(String PhongHoc) {
        this.PhongHoc = PhongHoc;
    }

    public String getMaGiangVien() {
        return MaGiangVien;
    }

    public void setMaGiangVien(String MaGiangVien) {
        this.MaGiangVien = MaGiangVien;
    }

}
