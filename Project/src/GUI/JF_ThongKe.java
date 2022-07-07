
package GUI;
import DBO.DBO_VIEW_DIEM_SV_MON_HOC;
import DBO.DBO_VIEW_SV_LOP;
import DBO.DBO_VIEW_THONGKE_CANHCAO;
import DBO.DBO_VIEW_THONGKE_HOCBONG;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DBO.DBO_KHOA;
import DLL.DLL_HocPhan;
import DLL.DLL_Lop;
import DLL.DLL_Khoa;
import DLL.DLL_ViewDSVMH;
import DLL.DLL_ViewSVLop;
import DLL.DLL_ViewTKCC;
import DLL.DLL_ViewTKHB;
import java.util.ArrayList;
import MeThodShow.MyMethod;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;


public class JF_ThongKe extends javax.swing.JFrame {


    ArrayList<DBO_KHOA> lstCBKhoa = null;
    ArrayList<DBO_LOP> lstCBLop = null;
    ArrayList<DBO_HOC_PHAN> lstCBHP = null;
    ArrayList<DBO_VIEW_DIEM_SV_MON_HOC> lstViewDMHSV = null;
    ArrayList<DBO_VIEW_SV_LOP> lstViewLSV = null;
    ArrayList<DBO_VIEW_THONGKE_CANHCAO> lstViewTKCC = null;
    ArrayList<DBO_VIEW_THONGKE_HOCBONG> lstViewTKHB = null;
    ArrayList<Integer> lstInt = null;


    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_ViewDSVMH dLL_ViewDSVMH = new DLL_ViewDSVMH();
    DLL_ViewSVLop dLL_ViewSVLop = new DLL_ViewSVLop();
    DLL_ViewTKCC dLL_ViewTKCC = new DLL_ViewTKCC();
    DLL_ViewTKHB dLL_ViewTKHB = new DLL_ViewTKHB();

    // method 
    MyMethod method = new MyMethod();
    private int choice = 1;
    private DefaultTableModel dtm;
    private boolean check = false;
    String title = "";

    public JF_ThongKe() {
        initComponents();
        // method.showMessegaQue("asdasd");
        bidingLop();
        bidingHocPhan("");
        bidingKhoa();
    }

    public void bidingKhoa() {
        lstCBKhoa = dLL_Khoa.getAllKhoa();
        for (DBO_KHOA obj : lstCBKhoa) {
            cbKhoa.addItem(obj.getTenKhoa());
        }
    }

    public void bidingLop() {
        lstCBLop = dLL_Lop.getAllLop();
       
        for (DBO_LOP obj : lstCBLop) {
            cbLopQuanLy.addItem(obj.getTenLop());
        }
    }

    public void bidingHocPhan(String chuoitimkiem) {
        lstCBHP = dLL_HocPhan.getSearchHocPhan(chuoitimkiem);
        for (DBO_HOC_PHAN obj : lstCBHP) {
            cbLopHocPhan.addItem(obj.getTenHocPhan());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdLopQuanLy = new javax.swing.JRadioButton();
        rdLopHocPhan = new javax.swing.JRadioButton();
        rdHocBong = new javax.swing.JRadioButton();
        rdCanhCao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        cbLopQuanLy = new javax.swing.JComboBox<>();
        cbLopHocPhan = new javax.swing.JComboBox<>();
        cbHocKy = new javax.swing.JComboBox<>();
        txtHocBong = new javax.swing.JTextField();
        txtDieuKien = new javax.swing.JTextField();
        btnShowData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataTk = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống Kê Sinh Viên");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ DANH SÁCH SINH VIÊN");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Thống kê theo");

        rdLopQuanLy.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdLopQuanLy);
        rdLopQuanLy.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdLopQuanLy.setForeground(new java.awt.Color(255, 51, 51));
        rdLopQuanLy.setSelected(true);
        rdLopQuanLy.setText("Lớp");
        rdLopQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdLopQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLopQuanLyActionPerformed(evt);
            }
        });

        rdLopHocPhan.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdLopHocPhan);
        rdLopHocPhan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdLopHocPhan.setForeground(new java.awt.Color(255, 51, 51));
        rdLopHocPhan.setText("Lớp học");
        rdLopHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdLopHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLopHocPhanActionPerformed(evt);
            }
        });

        rdHocBong.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdHocBong);
        rdHocBong.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdHocBong.setForeground(new java.awt.Color(255, 51, 51));
        rdHocBong.setText("Học bổng");
        rdHocBong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdHocBong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHocBongActionPerformed(evt);
            }
        });

        rdCanhCao.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdCanhCao);
        rdCanhCao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdCanhCao.setForeground(new java.awt.Color(255, 51, 51));
        rdCanhCao.setText("Cảnh cáo");
        rdCanhCao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdCanhCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCanhCaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Khoa");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lớp Quản Lý");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Lớp Học Phần");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Học Kỳ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Số Lượng Học Bổng");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Điều Kiện");

        cbKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbKhoa.setEnabled(false);

        cbLopQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbLopHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbLopHocPhan.setEnabled(false);

        cbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học Kỳ 1", "Học Kỳ 2" }));
        cbHocKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbHocKy.setEnabled(false);

        txtHocBong.setEnabled(false);
        txtHocBong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHocBongKeyTyped(evt);
            }
        });

        txtDieuKien.setEnabled(false);
        txtDieuKien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDieuKienKeyTyped(evt);
            }
        });

        btnShowData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myShow.png"))); // NOI18N
        btnShowData.setText("Hiển thị");
        btnShowData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });

        tblDataTk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDataTk);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Năm Học");

        txtNamHoc.setEnabled(false);
        txtNamHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamHocKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbLopQuanLy, 0, 220, Short.MAX_VALUE)
                                    .addComponent(cbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtHocBong, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbLopHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(btnShowData)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdLopQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(rdLopHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(rdHocBong, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(rdCanhCao, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdLopQuanLy)
                    .addComponent(rdLopHocPhan)
                    .addComponent(rdHocBong)
                    .addComponent(rdCanhCao))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbLopHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbLopQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtHocBong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        JF_Main jF_Manager = new JF_Main();
//        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void rdLopQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLopQuanLyActionPerformed
        cbLopQuanLy.setEnabled(true);
        choice = 1;
        res();
        //
        cbKhoa.setEnabled(false);
        cbHocKy.setEnabled(false);
        cbLopHocPhan.setEnabled(false);
        txtDieuKien.setEnabled(false);
//        txtFilter.setEnabled(false);
        txtNamHoc.setEnabled(false);
        txtHocBong.setEnabled(false);
//        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdLopQuanLyActionPerformed

    private void rdLopHocPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLopHocPhanActionPerformed
        cbLopHocPhan.setEnabled(true);
//        txtFilter.setEnabled(true);
//        btnFilter.setEnabled(true);
        choice = 2;
        res();

        //
        cbLopQuanLy.setEnabled(false);
        cbKhoa.setEnabled(false);
        cbHocKy.setEnabled(false);
        txtDieuKien.setEnabled(false);
        txtNamHoc.setEnabled(false);
        txtHocBong.setEnabled(false);
    }//GEN-LAST:event_rdLopHocPhanActionPerformed

    private void rdHocBongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHocBongActionPerformed
        cbKhoa.setEnabled(true);
        txtNamHoc.setEnabled(true);
        res();

        cbHocKy.setEnabled(true);
        txtHocBong.setEnabled(true);
        txtDieuKien.setEnabled(true);
        choice = 3;
        //
        cbLopQuanLy.setEnabled(false);
        cbLopHocPhan.setEnabled(false);
//        txtFilter.setEnabled(false);
//        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdHocBongActionPerformed

    private void rdCanhCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCanhCaoActionPerformed
        txtNamHoc.setEnabled(true);
        cbHocKy.setEnabled(true);
        res();

        choice = 4;
        //
        cbLopQuanLy.setEnabled(false);
        cbKhoa.setEnabled(false);
        cbLopHocPhan.setEnabled(false);
        txtDieuKien.setEnabled(false);
//        txtFilter.setEnabled(false);
        txtHocBong.setEnabled(false);
//        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdCanhCaoActionPerformed

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        if (choice == 1) {
            lstCBLop = dLL_Lop.getAllLop();
            int cbRow = cbLopQuanLy.getSelectedIndex();
            String malop = lstCBLop.get(cbRow).getMaLop();
            BidingSVLQL(malop);
        } else if (choice == 2) {
//            if (txtFilter.getText().isEmpty()) {
//                txtFilter.setText("");
//            }
//            lstCBHP = dLL_HocPhan.getSearchHocPhan(txtFilter.getText());
            int cbRow = cbLopHocPhan.getSelectedIndex();
            String malophocphan = lstCBHP.get(cbRow).getMaHocPhan();
            BidingSVLHP(malophocphan);
        } else if (choice == 3) {
            if (txtDieuKien.getText().isEmpty() || txtNamHoc.getText().isEmpty() || txtHocBong.getText().isEmpty()) {
                method.showMessegaNo("Có 1 trường rỗng");
            } else {
                lstCBKhoa = dLL_Khoa.getAllKhoa();
                int cbRow = cbKhoa.getSelectedIndex();
                String makhoa = lstCBKhoa.get(cbRow).getMaKhoa();
                int hocky = cbHocKy.getSelectedIndex() + 1;
                Float dk = Float.parseFloat(txtDieuKien.getText());
                int sl = Integer.parseInt(txtHocBong.getText());
                int namhoc = Integer.parseInt(txtNamHoc.getText());
                BidingTKHB(dk, sl, makhoa, namhoc, hocky);
            }
        } else if (choice == 4) {
            if (txtNamHoc.getText().isEmpty()) {
                method.showMessegaNo("Có 1 trường rỗng");
            } else {
                int hocky = cbHocKy.getSelectedIndex() + 1;
                BidingTKCC(Integer.parseInt(txtNamHoc.getText()), hocky);
            }
        }
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void txtHocBongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHocBongKeyTyped
        InputNumber(evt, txtHocBong);
    }//GEN-LAST:event_txtHocBongKeyTyped

    private void txtDieuKienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDieuKienKeyTyped
        onlynumber(evt, txtDieuKien);
    }//GEN-LAST:event_txtDieuKienKeyTyped

    private void txtNamHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamHocKeyTyped
        InputNumber(evt, txtNamHoc);
    }//GEN-LAST:event_txtNamHocKeyTyped
    public void BidingSVLQL(String malop) {
        lstViewLSV = dLL_ViewSVLop.getSVLop(malop);
        if (lstViewLSV.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Và Tên");
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_SV_LOP item : lstViewLSV) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaSinhVien());
                row.add(item.getHoTenSinhVien());
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop SV : " + e.toString());
        }
        tblDataTk.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblDataTk.setModel(dtm);
    }

    public void BidingSVLHP(String malophocphan) {
        lstViewDMHSV = dLL_ViewDSVMH.getDSVMH(malophocphan);
        if (lstViewDMHSV.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Trung Bình");
        Column.add("Điểm Chữ");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_DIEM_SV_MON_HOC item : lstViewDMHSV) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaHocPhan());
                row.add(item.getTenHocPhan());
                row.add(item.getMaSinhVien());
                row.add(item.getHoTenSinhVien());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop HP : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    public void BidingTKHB(float dk, int sl, String makhoa, int namhoc, int hocky) {
        lstViewTKHB = dLL_ViewTKHB.getSVHB(dk, sl, makhoa, namhoc, hocky);
        if (lstViewTKHB.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Số");
        Column.add("Xếp Loại");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_THONGKE_HOCBONG item : lstViewTKHB) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaSinhVien());
                row.add(item.getHoTenSinhVien());
                row.add(item.getDiemSo());
                row.add(item.getHinhThuc());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop HB : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    public void BidingTKCC(int namhoc, int hocky) {
        lstViewTKCC = dLL_ViewTKCC.getSVCC(namhoc, hocky);
        if (lstViewTKCC.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Số");
        Column.add("Loại Cảnh Cáo");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_THONGKE_CANHCAO item : lstViewTKCC) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                row.add(item.getMaSinhVien());
                row.add(item.getHoTenSinhVien());
                row.add(item.getDiemSo());
                row.add(item.getHinhThuc());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop CC : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }

    private void InputNumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    public void res() {
        cbLopQuanLy.setSelectedIndex(0);
        cbHocKy.setSelectedIndex(0);
        cbKhoa.setSelectedIndex(0);
        cbLopHocPhan.setSelectedIndex(0);
        txtDieuKien.setText("");
        txtNamHoc.setText("");
        txtHocBong.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowData;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JComboBox<String> cbLopHocPhan;
    private javax.swing.JComboBox<String> cbLopQuanLy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCanhCao;
    private javax.swing.JRadioButton rdHocBong;
    private javax.swing.JRadioButton rdLopHocPhan;
    private javax.swing.JRadioButton rdLopQuanLy;
    private javax.swing.JTable tblDataTk;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtHocBong;
    private javax.swing.JTextField txtNamHoc;
    // End of variables declaration//GEN-END:variables
}
