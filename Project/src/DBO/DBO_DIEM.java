package DBO;

import java.util.Date;

public class DBO_DIEM {

    private String MaSinhVien;
    private String MaHocPhan;
    private float DiemC;
    private float DiemB;
    private float DiemTL1;
    private float DiemTL2;
    private float Diem_Trung_Binh;
    private String Diem_Chu;
    private String MaKhoa;
    private String MaLop;
    private boolean Xoa;

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public String getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(String MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }

    public float getDiemC() {
        return DiemC;
    }

    public void setDiemC(float DiemC) {
        this.DiemC = DiemC;
    }

    public float getDiemB() {
        return DiemB;
    }

    public void setDiemB(float DiemB) {
        this.DiemB = DiemB;
    }

    public float getDiemTL1() {
        return DiemTL1;
    }

    public void setDiemTL1(float DiemTL1) {
        this.DiemTL1 = DiemTL1;
    }

    public float getDiemTL2() {
        return DiemTL2;
    }

    public void setDiemTL2(float DiemTL2) {
        this.DiemTL2 = DiemTL2;
    }

    public float getDiem_Trung_Binh() {
        return Diem_Trung_Binh;
    }

    public void setDiem_Trung_Binh(float Diem_Trung_Binh) {
        this.Diem_Trung_Binh = Diem_Trung_Binh;
    }

    public String getDiem_Chu() {
        return Diem_Chu;
    }

    public void setDiem_Chu(String Diem_Chu) {
        this.Diem_Chu = Diem_Chu;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }

}
