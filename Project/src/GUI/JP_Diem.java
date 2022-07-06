/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_DIEM;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_KHOA;
import DBO.DBO_LOP;
import DBO.DBO_SINH_VIEN;
import DLL.DLL_Diem;
import DLL.DLL_HocPhan;
import DLL.DLL_Khoa;
import DLL.DLL_Lop;
import DLL.DLL_SinhVien;
import MeThodShow.MyMethod;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LeDung
 */
public class JP_Diem extends javax.swing.JPanel {

    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_SINH_VIEN> lstSinhVien = null;
    ArrayList<DBO_HOC_PHAN> lstHp = null;
    ArrayList<DBO_KHOA> lstKhoa = null;
    ArrayList<DBO_LOP> lstLop = null;
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_SinhVien dll_sv = new DLL_SinhVien();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dll_Lop = new DLL_Lop();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;

    private static JP_Diem instance = null;

    public static JP_Diem getInstance() {
        if (instance == null) {
            instance = new JP_Diem();
        }
        return instance;
    }

    private JP_Diem() {
        initComponents();
        BidingDataDiem();
        finding();
    }

    public void BidingDataDiem() {
        lstDiem = dLL_Diem.getAllDiem();
        Vector Column = new Vector();
        Column.add("Mã Sinh Viên");
        Column.add("Tên Sinh Viên");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Điểm Chuyên Cần");
        Column.add("Điểm KT");
        Column.add("Điểm GK");
        Column.add("Điểm CK");
        Column.add("Điểm TB");
        Column.add("Điểm Chữ");
        Column.add("Mã Khoa");
        Column.add("Mã Lớp");
        Column.add("Xóa");
        Vector data = new Vector();
        try {
            for (DBO_DIEM item : lstDiem) {
                Vector row = new Vector();
                lstSinhVien = dll_sv.getAllGV_dk(item.getMaSinhVien());
                lstHp = dLL_HocPhan.getAllHocPhan_dk(item.getMaHocPhan());

                if (lstSinhVien.size() > 0) {
                    row.add(lstSinhVien.get(0).getMaSinhVien());
                } else {
                    row.add("Is Null");
                }
                if (lstSinhVien.size() > 0) {
                    row.add(lstSinhVien.get(0).getHoTenSinhVien());
                } else {
                    row.add("Is Null");
                }
                if (lstHp.size() > 0) {
                    row.add(lstHp.get(0).getMaHocPhan());
                } else {
                    row.add("Is Null");
                }
                if (lstHp.size() > 0) {
                    row.add(lstHp.get(0).getTenHocPhan());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getDiemC());
                row.add(item.getDiemB());
                row.add(item.getDiemTL1());
                row.add(item.getDiemTL2());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                lstLop = dll_Lop.getAllLop_dk(lstSinhVien.get(0).getMaLop());
                lstKhoa = dLL_Khoa.getAllKhoa_dk(lstLop.get(0).getMaKhoa());
                if (lstKhoa.size() > 0) {
                    row.add(lstKhoa.get(0).getTenKhoa());
                } else {
                    row.add("Is Null");
                }
                if (lstLop.size() > 0) {
                    row.add(lstLop.get(0).getTenLop());
                } else {
                    row.add("Is Null");
                }
                boolean flag = item.isXoa();
                String Xoa = "Đã Xóa";
                if (!flag) {
                    Xoa = "Chưa Xóa";
                }
                row.add(Xoa);
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Diem : " + e.toString());
        }
        tblDiem.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblDiem.setModel(dtm);

    }
//                lstSinhVien = dll_sv.getAllGV_dk(item.getMaSinhVien());
//                lstHp = dLL_HocPhan.getAllHocPhan_dk(item.getMaHocPhan());
//                if (lstSinhVien.size() > 0) {
//                    row.add(lstSinhVien.get(0).getMaSinhVien());
//                } else {
//                    row.add("Is Null");
//                }
//                if (lstSinhVien.size() > 0) {
//                    row.add(lstSinhVien.get(0).getHoTenSinhVien());
//                } else {
//                    row.add("Is Null");
//                }
//                if (lstHp.size() > 0) {
//                    row.add(lstHp.get(0).getMaHocPhan());
//                } else {
//                    row.add("Is Null");
//                }
//                if (lstHp.size() > 0) {
//                    row.add(lstHp.get(0).getTenHocPhan());
//                } else {
//                    row.add("Is Null");
//                }
//                row.add(item.getDiemC());
//                row.add(item.getDiemB());
//                row.add(item.getDiemTL1());
//                row.add(item.getDiemTL2());
//                row.add(item.getDiem_Trung_Binh());
//                row.add(item.getDiem_Chu());
//                
////                lstLop = dll_Lop.getAllLop_dk(lstSinhVien.get(0).getMaLop());
////                lstKhoa = dLL_Khoa.getAllKhoa_dk(lstLop.get(0).getMaKhoa());
//                  if (lstLop.size() > 0 &&lstSinhVien.size()>0  ) {
//                    lstLop = dll_Lop.getAllLop_dk(lstSinhVien.get(0).getMaLop());
//                lstKhoa = dLL_Khoa.getAllKhoa_dk(lstLop.get(0).getMaKhoa());
//                }
//                if (lstKhoa.size() > 0) {
//                    row.add(lstKhoa.get(0).getTenKhoa());
//                } else {
//                    row.add("Is Null");
//                }
//                if (lstLop.size() > 0) {
//                    row.add(lstLop.get(0).getTenLop());
//                } else {
//                    row.add("Is Null");
//                }
//                
//                boolean flag = item.isXoa();
//                String Xoa = "Đã Xóa";
//                if (!flag) {
//                    Xoa = "Chưa Xóa";
//                }
//                
//                
//                row.add(Xoa);
//                data.add(row);
//            }
//        } catch (Exception e) {
//            method.showMessegaWa("Error for biding Diem : " + e.toString());
//        }
//        dtm = new DefaultTableModel(data, Column);
//        tblDiem.setModel(dtm);
//
//    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDiem.getModel());
        tblDiem.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDiem.getModel());
        tblDiem.setRowSorter(rowSorter);
        txtFind.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtFind.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtFind.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                method.showMessegaNo("this is change");
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenSinhVien = new javax.swing.JTextField();
        txtMaSinhVien = new javax.swing.JTextField();
        txtDiemB = new javax.swing.JTextField();
        txtDiemC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenHocPhan = new javax.swing.JTextField();
        txtMaHocPhan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTL1 = new javax.swing.JTextField();
        txtTL2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDiemTB = new javax.swing.JTextField();
        txtDiemChu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        checkBoxXoa = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAddDiem = new javax.swing.JButton();
        btnUpdateDiem = new javax.swing.JButton();
        btnDeleteDiem = new javax.swing.JButton();
        btnResetDiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1252, 618));

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel4.setPreferredSize(new java.awt.Dimension(1252, 618));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Nhập từ khóa cần tìm");

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Tên sinh viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Mã số sinh viên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Kiểm tra");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Điểm chuyên cần");

        txtTenSinhVien.setEnabled(false);

        txtMaSinhVien.setEnabled(false);

        txtDiemB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemBKeyTyped(evt);
            }
        });

        txtDiemC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemCKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Tên học phần");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Mã học phần");

        txtTenHocPhan.setEnabled(false);

        txtMaHocPhan.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Điểm thi giữa kỳ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Điểm thi cuối kỳ");

        txtTL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTL1KeyTyped(evt);
            }
        });

        txtTL2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTL2KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Điểm trung bình");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Điểm chữ");

        txtDiemTB.setEnabled(false);

        txtDiemChu.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Trạng thái");

        checkBoxXoa.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        checkBoxXoa.setText("Đã Xóa");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Mã ngành");

        txtMaKhoa.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Mã lớp");

        txtMaLop.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiemC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTL1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTL2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiemChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSinhVien)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenHocPhan)
                            .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(checkBoxXoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaLop)
                            .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(333, 333, 333))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtTL1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtTL2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtDiemChu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(checkBoxXoa))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnAddDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddDiem.setForeground(new java.awt.Color(255, 51, 51));
        btnAddDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddDiem.setText("Thêm");
        btnAddDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiembtnAddActionPerformed(evt);
            }
        });

        btnUpdateDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateDiem.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateDiem.setText("Cập nhật");
        btnUpdateDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateDiem.setEnabled(false);
        btnUpdateDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDiemActionPerformed(evt);
            }
        });

        btnDeleteDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteDiem.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnDeleteDiem.setText("Xóa");
        btnDeleteDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteDiem.setEnabled(false);
        btnDeleteDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDiemActionPerformed(evt);
            }
        });

        btnResetDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetDiem.setForeground(new java.awt.Color(255, 51, 51));
        btnResetDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetDiem.setText("Làm mới");
        btnResetDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetDiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDiem)
                    .addComponent(btnUpdateDiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetDiem)
                    .addComponent(btnDeleteDiem))
                .addGap(32, 32, 32))
        );

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiem);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiemBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemBKeyTyped
        onlynumber(evt, txtDiemB);
    }//GEN-LAST:event_txtDiemBKeyTyped

    private void txtDiemCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemCKeyTyped
        onlynumber(evt, txtDiemC);
    }//GEN-LAST:event_txtDiemCKeyTyped

    private void txtTL1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTL1KeyTyped
        onlynumber(evt, txtTL1);
    }//GEN-LAST:event_txtTL1KeyTyped

    private void txtTL2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTL2KeyTyped
        onlynumber(evt, txtTL2);
    }//GEN-LAST:event_txtTL2KeyTyped

    private void btnAddDiembtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiembtnAddActionPerformed
        JF_AddDiem jf_add_diem = new JF_AddDiem(this);
        jf_add_diem.setVisible(true);


    }//GEN-LAST:event_btnAddDiembtnAddActionPerformed

    private void btnResetDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDiemActionPerformed
        BidingDataDiem();
        res();
    }//GEN-LAST:event_btnResetDiemActionPerformed
    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }

    private void res() {
        txtDiemC.setText("");
        txtDiemB.setText("");
        txtTL1.setText("");
        txtTL2.setText("");
        txtDiemChu.setText("");
        txtDiemTB.setText("");
        txtMaSinhVien.setText("");
        txtTenSinhVien.setText("");
        txtMaHocPhan.setText("");
        txtTenHocPhan.setText("");
        txtMaKhoa.setText("");
        txtMaLop.setText("");
        checkBoxXoa.setSelected(false);
        btnUpdateDiem.setEnabled(false);
        btnDeleteDiem.setEnabled(false);
    }
    private void btnDeleteDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDiemActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String ma = txtMaSinhVien.getText();
            String mahp = txtMaHocPhan.getText();
            method.showMessegaNo("Mssv is Empty");
            if (dLL_Diem.Delete(ma, mahp)) {
                method.showMessegaNo("Xóa Thành Công !");
                BidingDataDiem();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteDiemActionPerformed

    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        int row = tblDiem.getSelectedRow();
        String mssv = tblDiem.getValueAt(row, 0).toString();
        String mamon = tblDiem.getValueAt(row, 2).toString();

        lstDiem = dLL_Diem.getAllDiem_infor(mssv, mamon);
        lstSinhVien = dll_sv.getAllGV_dk(lstDiem.get(0).getMaSinhVien());
        lstHp = dLL_HocPhan.getAllHocPhan_dk(lstDiem.get(0).getMaHocPhan());
        txtMaSinhVien.setText(lstDiem.get(0).getMaSinhVien());
        txtMaHocPhan.setText(lstDiem.get(0).getMaHocPhan());
        txtTenSinhVien.setText(lstSinhVien.get(0).getHoTenSinhVien());
        txtTenHocPhan.setText(lstHp.get(0).getTenHocPhan());
        txtDiemC.setText(String.valueOf(lstDiem.get(0).getDiemC()));
        txtDiemB.setText(String.valueOf(lstDiem.get(0).getDiemB()));
        txtTL1.setText(String.valueOf(lstDiem.get(0).getDiemTL1()));
        txtTL2.setText(String.valueOf(lstDiem.get(0).getDiemTL2()));
        txtDiemTB.setText(String.valueOf(lstDiem.get(0).getDiem_Trung_Binh()));
        txtDiemChu.setText(lstDiem.get(0).getDiem_Chu());
        txtMaKhoa.setText(tblDiem.getValueAt(row, 10).toString());
        txtMaLop.setText(tblDiem.getValueAt(row, 11).toString());
        checkBoxXoa.setSelected(lstDiem.get(0).isXoa());
        //
        txtDiemB.requestFocus();
        btnDeleteDiem.setEnabled(true);
        btnUpdateDiem.setEnabled(true);
    }//GEN-LAST:event_tblDiemMouseClicked

    private void btnUpdateDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDiemActionPerformed
        if (txtDiemC.getText().isEmpty() || txtDiemB.getText().isEmpty() || txtTL1.getText().isEmpty() || txtTL2.getText().isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            String mssv = txtMaSinhVien.getText();
            String mahocphan = txtMaHocPhan.getText();
            Float diemc = Float.parseFloat(txtDiemC.getText());
            Float diemb = Float.parseFloat(txtDiemB.getText());
            Float dieml1 = Float.parseFloat(txtTL1.getText());
            Float dieml2 = Float.parseFloat(txtTL2.getText());
            boolean check = checkBoxXoa.isSelected();
            DBO_DIEM item = new DBO_DIEM();
            item.setMaSinhVien(mssv);
            item.setMaHocPhan(mahocphan);
            item.setDiemC(diemc);
            item.setDiemB(diemb);
            item.setDiemTL1(dieml1);
            item.setDiemTL2(dieml2);
            item.setXoa(check);
            if (dLL_Diem.Update(item)) {
                method.showMessegaNo("Cập Nhật Thành Công !");
                res();
                BidingDataDiem();
            } else {
                method.showMessegaNo("Cập Nhật Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnUpdateDiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDiem;
    private javax.swing.JButton btnDeleteDiem;
    private javax.swing.JButton btnResetDiem;
    private javax.swing.JButton btnUpdateDiem;
    private javax.swing.JCheckBox checkBoxXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtDiemB;
    private javax.swing.JTextField txtDiemC;
    private javax.swing.JTextField txtDiemChu;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtTL1;
    private javax.swing.JTextField txtTL2;
    private javax.swing.JTextField txtTenHocPhan;
    private javax.swing.JTextField txtTenSinhVien;
    // End of variables declaration//GEN-END:variables
}
