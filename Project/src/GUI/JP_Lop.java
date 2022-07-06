/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_GIANG_VIEN;
import DBO.DBO_KHOA;
import DBO.DBO_LOP;
import DLL.DLL_GiangVien;
import DLL.DLL_Khoa;
import DLL.DLL_Lop;
import MeThodShow.MyMethod;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JP_Lop extends javax.swing.JPanel {

    ArrayList<DBO_KHOA> lstKhoa = null;
    ArrayList<DBO_LOP> lstLop = null;
    ArrayList<DBO_GIANG_VIEN> lstGiangVien = null;
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_GiangVien dLL_GiangVien = new DLL_GiangVien();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    private static JP_Lop instance = null;

    public static JP_Lop getInstance() {
        if (instance == null) {
            instance = new JP_Lop();
        }
        return instance;
    }

    private JP_Lop() {
        initComponents();
        BiddingcbKhoa();
        BidingDataLop();
        BiddingcbGV();
        finding();
    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblLopHoc.getModel());
        tblLopHoc.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblLopHoc.getModel());
        tblLopHoc.setRowSorter(rowSorter);
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

    public void BiddingcbKhoa() {
        lstKhoa = dLL_Khoa.getAllKhoa();
        for (DBO_KHOA obj : lstKhoa) {
            cbMaKhoa.addItem(obj.getTenKhoa());
        }
    }

    public void BiddingcbGV() {
        lstGiangVien = dLL_GiangVien.getAllGV();
        for (DBO_GIANG_VIEN obj : lstGiangVien) {
            cbMaGiangVien.addItem(obj.getHoTenGiangVien());
        }
    }

    public void BidingDataLop() {
        lstLop = dLL_Lop.getAllLop();
        lstGiangVien = dLL_GiangVien.getAllGV();
        Vector Column = new Vector();
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Column.add("Tên Khoa");
        Column.add("Tên Giảng Viên");
        Vector data = new Vector();
        try {
            for (DBO_LOP item : lstLop) {
                Vector row = new Vector();
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                lstKhoa = dLL_Khoa.getAllKhoa_dk(item.getMaKhoa());
                if (lstKhoa.size() > 0) {
                    row.add(lstKhoa.get(0).getTenKhoa());
                } else {
                    row.add("Is Null");
                }
                lstGiangVien = dLL_GiangVien.getAllGV_dk(item.getMaGiangVien());
                row.add(lstGiangVien.get(0).getHoTenGiangVien());
                data.add(row);
            }

//            for (DBO_GIANG_VIEN item : lstGiangVien){
//                Vector Column = new Vector();
//                lstGiangVien = dLL_GiangVien.getAllGV()_dk(item.getMaGiangVien());
//               if (lstGiangVien.size() > 0) {
//                    row.add(lstGiangVien.get(0).getHoTenGiangVien());
//                } else {
//                    row.add("Is Null");
//                }
//                data.add(row);
//            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop : " + e.toString());
        }
        tblLopHoc.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblLopHoc.setModel(dtm);
    }

    private void res() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        cbMaKhoa.setSelectedIndex(0);
        cbMaGiangVien.setSelectedIndex(0);
        btnUpdateLopHoc.setEnabled(false);
        btnDeleteLopHoc.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLopHoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMaKhoa = new javax.swing.JComboBox<>();
        cbMaGiangVien = new javax.swing.JComboBox<>();
        btnAddLopHoc = new javax.swing.JButton();
        btnUpdateLopHoc = new javax.swing.JButton();
        btnDeleteLopHoc = new javax.swing.JButton();
        btnResetLopHoc = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 618));

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 618));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ DANH SÁCH LỚP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        tblLopHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLopHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLopHoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã lớp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Lớp");

        txtMaLop.setEnabled(false);
        txtMaLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaLopKeyTyped(evt);
            }
        });

        txtTenLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenLopKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Mã viện");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Tên giảng viên");

        btnAddLopHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddLopHoc.setForeground(new java.awt.Color(255, 51, 51));
        btnAddLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddLopHoc.setText("Thêm");
        btnAddLopHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLopHocActionPerformed(evt);
            }
        });

        btnUpdateLopHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateLopHoc.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateLopHoc.setText("Cập nhật");
        btnUpdateLopHoc.setToolTipText("");
        btnUpdateLopHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateLopHoc.setEnabled(false);
        btnUpdateLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLopHocActionPerformed(evt);
            }
        });

        btnDeleteLopHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteLopHoc.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnDeleteLopHoc.setText("Xóa");
        btnDeleteLopHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteLopHoc.setEnabled(false);
        btnDeleteLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLopHocActionPerformed(evt);
            }
        });

        btnResetLopHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetLopHoc.setForeground(new java.awt.Color(255, 51, 51));
        btnResetLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetLopHoc.setText("Làm mới");
        btnResetLopHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLopHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtTenLop))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMaKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMaGiangVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnAddLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateLopHoc)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetLopHoc)
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cbMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddLopHoc)
                    .addComponent(btnUpdateLopHoc)
                    .addComponent(btnDeleteLopHoc)
                    .addComponent(btnResetLopHoc))
                .addGap(19, 19, 19))
        );

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetLopHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLopHocActionPerformed

        res();
    }//GEN-LAST:event_btnResetLopHocActionPerformed

    private void tblLopHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopHocMouseClicked
        lstLop = dLL_Lop.getAllLop();
        lstGiangVien = dLL_GiangVien.getAllGV();
        txtMaLop.setEnabled(false);
        int rowtbl = tblLopHoc.getSelectedRow();
        txtMaLop.setText(lstLop.get(rowtbl).getMaLop());
        txtTenLop.setText(lstLop.get(rowtbl).getTenLop());

        lstKhoa = dLL_Khoa.getAllKhoa_dk(lstLop.get(rowtbl).getMaKhoa());
        if (lstKhoa.size() > 0) {
            cbMaKhoa.setSelectedItem(lstKhoa.get(0).getTenKhoa());
        } else {
            cbMaKhoa.setSelectedIndex(0);
        }

        lstGiangVien = dLL_GiangVien.getAllGV_dk(lstLop.get(rowtbl).getMaGiangVien());
        if (lstGiangVien.size() > 0) {
            cbMaGiangVien.setSelectedItem(lstGiangVien.get(0).getHoTenGiangVien());
        } else {
            cbMaGiangVien.setSelectedIndex(0);
        }

        btnUpdateLopHoc.setEnabled(true);
        btnDeleteLopHoc.setEnabled(true);
        dk = txtMaLop.getText();
    }//GEN-LAST:event_tblLopHocMouseClicked

    private void btnDeleteLopHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLopHocActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String malop = txtMaLop.getText();
            if (malop.isEmpty()) {
                method.showMessegaNo("This malop is Empty");
            } else if (dLL_Lop.Delete(malop)) {
                method.showMessegaNo("Xóa Thành Công !");
                BidingDataLop();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteLopHocActionPerformed

    private void btnAddLopHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLopHocActionPerformed
        lstKhoa = dLL_Khoa.getAllKhoa();
        lstGiangVien = dLL_GiangVien.getAllGV();
        txtMaLop.setEnabled(true);
        String malop = txtMaLop.getText();
        String tenlop = txtTenLop.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String makhoa = lstKhoa.get(cbRow).getMaKhoa();
        int cbRow1 = cbMaGiangVien.getSelectedIndex();
        String magv = lstGiangVien.get(cbRow1).getMaGiangVien();
        DBO_LOP item = new DBO_LOP();
        item.setMaLop(malop);
        item.setTenLop(tenlop);
        item.setMaKhoa(makhoa);
        item.setMaGiangVien(magv);
        if (malop.isEmpty() || tenlop.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            lstLop = dLL_Lop.Check_Lop(malop);
            if (lstLop.size() < 1) {
                if (dLL_Lop.Insert(item)) {
                    method.showMessegaNo("Thêm Thành Công !");
                    res();
                    BidingDataLop();
                } else {
                    method.showMessegaNo("Thêm Thất Bại !");
                }
            } else {
                method.showMessegaNo("Đã tồn tại dữ liệu trong cơ sở dữ liệu, Xin kiểm tra lại");
                res();
                txtMaLop.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAddLopHocActionPerformed

    private void btnUpdateLopHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLopHocActionPerformed
        lstKhoa = dLL_Khoa.getAllKhoa();
        lstGiangVien = dLL_GiangVien.getAllGV();
        txtMaLop.setEnabled(true);
        String malop = txtMaLop.getText();
        String tenlop = txtTenLop.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String makhoa = lstKhoa.get(cbRow).getMaKhoa();
        int cbRow1 = cbMaGiangVien.getSelectedIndex();
        String magv = lstGiangVien.get(cbRow1).getMaGiangVien();
        DBO_LOP item = new DBO_LOP();
        item.setMaLop(malop);
        item.setTenLop(tenlop);
        item.setMaKhoa(makhoa);
        item.setMaGiangVien(magv);
        if (malop.isEmpty() || tenlop.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else if (dLL_Lop.Update(item, dk)) {
            method.showMessegaNo("Cập Nhật Thành Công !");
            res();
            BidingDataLop();
        } else {
            method.showMessegaNo("Cập Nhật Thất Bại !");
        }
    }//GEN-LAST:event_btnUpdateLopHocActionPerformed

    private void txtMaLopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLopKeyTyped
        if (txtMaLop.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaLopKeyTyped

    private void txtTenLopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenLopKeyTyped
        if (txtTenLop.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTenLopKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLopHoc;
    private javax.swing.JButton btnDeleteLopHoc;
    private javax.swing.JButton btnResetLopHoc;
    private javax.swing.JButton btnUpdateLopHoc;
    private javax.swing.JComboBox<String> cbMaGiangVien;
    private javax.swing.JComboBox<String> cbMaKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLopHoc;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTenLop;
    // End of variables declaration//GEN-END:variables
}
