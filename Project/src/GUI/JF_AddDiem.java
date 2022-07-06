/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.DLL_SinhVien;
import DLL.DLL_Diem;
import DLL.DLL_HocPhan;
import DBO.DBO_DIEM;
import DBO.DBO_SINH_VIEN;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DLL.DLL_Lop;
import MeThodShow.MyMethod;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class JF_AddDiem extends javax.swing.JFrame {

    MyMethod method = new MyMethod();
    ArrayList<DBO_SINH_VIEN> lstSV = null;
    ArrayList<DBO_HOC_PHAN> lstHP = null;
    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_LOP> lstLop = null;
    DLL_SinhVien dLL_SinhVien = new DLL_SinhVien();
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Lop dLL_Lop = new DLL_Lop();
    private boolean flag = false;
    JP_Diem d;

    public JF_AddDiem(JP_Diem themdiem) {
        initComponents();
        d = themdiem;
    }
//    public JF_AddDiem() {
//        initComponents();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        txtMaHocPhan = new javax.swing.JTextField();
        txtDiemC = new javax.swing.JTextField();
        txtDiemB = new javax.swing.JTextField();
        txtDiemThiL1 = new javax.swing.JTextField();
        txtDiemThiL2 = new javax.swing.JTextField();
        btnCheck = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCheck = new javax.swing.JTextArea();
        cbTL2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHẬP ĐIỂM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("MSSV");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Mã học phần");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Kiểm tra ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Điểm chuyên cần");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Điểm thi giữa kỳ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Điểm thi cuối kỳ");

        txtDiemC.setEnabled(false);

        txtDiemB.setEnabled(false);

        txtDiemThiL1.setEnabled(false);

        txtDiemThiL2.setEnabled(false);

        btnCheck.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCheck.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.errorForeground"));
        btnCheck.setText("Check");
        btnCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.errorForeground"));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add-event-icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.errorForeground"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancel.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtCheck.setColumns(20);
        txtCheck.setRows(5);
        txtCheck.setEnabled(false);
        jScrollPane1.setViewportView(txtCheck);

        cbTL2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        cbTL2.setText("Thi cuối kỳ");
        cbTL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbTL2.setEnabled(false);
        cbTL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTL2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemThiL1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemThiL2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cbTL2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiemThiL1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDiemThiL2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTL2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        String mssv = txtMaSinhVien.getText();
        String mahp = txtMaHocPhan.getText();
        String kqsv = "";
        String gach = "\n----------------------------------\n";
        String kqHP = "";
        if (mssv.isEmpty() || mahp.isEmpty()) {
            method.showMessegaWa("Không có dữ liệu để check");
            flag = false;
        } else {
            lstSV = dLL_SinhVien.getAllGV_dk(mssv);
            lstHP = dLL_HocPhan.getAllHocPhan_dk(mahp);
            if (lstSV.size() > 0 && lstHP.size() > 0) {
                lstLop = dLL_Lop.getAllLop_dk(lstSV.get(0).getMaLop());
                kqsv = "Mã số sinh viên : " + mssv + "\nHọ Và Tên : " + lstSV.get(0).getHoTenSinhVien() + "\nTên Lớp : " + lstLop.get(0).getTenLop();
                kqHP = "Mã Học Phần : " + lstHP.get(0).getMaHocPhan() + "\nTên Học Phần : " + lstHP.get(0).getTenHocPhan();
                txtCheck.setText(kqsv + gach + kqHP);
                lstDiem = dLL_Diem.Check_Diem(mssv, mahp);
                if (lstDiem.size() > 0) {
                    method.showMessegaWa("Điểm Số Học Phần :" + lstHP.get(0).getTenHocPhan() + "\n của sinh viên " + lstSV.get(0).getHoTenSinhVien() + " Đã Tồn Tại");
                    flag = false;
                } else {
                    flag = true;
                }

            } else {
                method.showMessegaQue("Không Có Sinh Viên Hoặc Lớp Học Phần");
                flag = false;
            }
        }
        txtDiemB.setEnabled(flag);
        txtDiemC.setEnabled(flag);
        txtDiemThiL1.setEnabled(flag);
        cbTL2.setEnabled(flag);
        txtDiemThiL2.setEnabled(cbTL2.isSelected());
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        boolean check = false;
        if (txtDiemB.getText().isEmpty() || txtDiemC.getText().isEmpty() || txtDiemThiL1.getText().isEmpty()) {
            method.showMessegaWa("Không có dữ liệu trong 1 textfiled");
            check = false;
        } else {
            String mssv = txtMaSinhVien.getText();
            String mahp = txtMaHocPhan.getText();
            Float diemC = Float.parseFloat(txtDiemC.getText());
            Float diemB = Float.parseFloat(txtDiemB.getText());
            Float diemTL1 = Float.parseFloat(txtDiemThiL1.getText());
            Float diemTL2 = null;
            DBO_DIEM obj = new DBO_DIEM();
            if (cbTL2.isSelected()) {
                if (txtDiemThiL2.getText().isEmpty()) {
                    method.showMessegaWa("Điểm thi lần 2 không được rỗng");
                    check = false;
                } else {
                    diemTL2 = Float.parseFloat(txtDiemThiL2.getText());
                    obj.setDiemTL2(diemTL2);
                    check = true;
                }
            } else {
                check = true;
            }
            if (check) {
                obj.setMaSinhVien(mssv);
                obj.setMaHocPhan(mahp);
                obj.setDiemC(diemC);
                obj.setDiemB(diemB);
                obj.setDiemTL1(diemTL1);

                if (dLL_Diem.Insert(obj)) {
                    method.showMessegaNo("Thêm Thành Công !");
                    d.BidingDataDiem();
                    this.dispose();
                    
//                    JF_Diem jf_diem = new JF_Diem();
                            //                    jf_diem.setVisible(true);
                            //                    jf_diem.setLocation(200, 100);
                            //                    this.setVisible(false);
                } else {
                    method.showMessegaNo("Thêm Thất Bại !");
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbTL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTL2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JCheckBox cbTL2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCheck;
    private javax.swing.JTextField txtDiemB;
    private javax.swing.JTextField txtDiemC;
    private javax.swing.JTextField txtDiemThiL1;
    private javax.swing.JTextField txtDiemThiL2;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JTextField txtMaSinhVien;
    // End of variables declaration//GEN-END:variables
}
