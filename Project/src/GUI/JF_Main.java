/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_DANG_NHAP;
import DLL.DLL_DangNhap;
import MeThodShow.MyMethod;
import Report.JP_ThongKeDiemSinhVien;
import Report.JP_ThongKeSinhVien;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author LeDung
 */
public class JF_Main extends javax.swing.JFrame {

    MyMethod method = new MyMethod();
    public String flag_Login = JF_Login.flag;
    public String name = JF_Login.name;
    public boolean flag_TaiKhoan = false;
    DBO_DANG_NHAP User = new DBO_DANG_NHAP();
    DLL_DangNhap dLL_DangNhap = new DLL_DangNhap();

    private Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    String date = d.format(today);

    public JF_Main() {
        initComponents();
        this.setLocation(100, 10);
        postData();
        Timer chu = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = lblTime.getText();
                st = st.substring(1) + st.charAt(0);
                lblTime.setText(st);
            }
        });
        chu.start();
        lblToday.setText(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSinhVien = new javax.swing.JButton();
        btnGiangVien = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        btnClass = new javax.swing.JButton();
        btnMonHoc = new javax.swing.JButton();
        btnDiem = new javax.swing.JButton();
        btnDaoTao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblToday = new javax.swing.JLabel();
        jtbHienThi = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnDangNhap = new javax.swing.JMenuItem();
        btnTaiKhoan = new javax.swing.JMenuItem();
        btnDangXuat = new javax.swing.JMenuItem();
        btnThoat = new javax.swing.JMenuItem();
        jMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Student System Manager");
        setSize(new java.awt.Dimension(1300, 793));

        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 754));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Xin chào :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        txtLogin1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        txtLogin1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(txtLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 6, 118, 21));

        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 51, 102));
        lblTime.setToolTipText("");
        jPanel3.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 0, 878, -1));

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        btnSinhVien.setBackground(new java.awt.Color(255, 0, 51));
        btnSinhVien.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        btnSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/student-readingIcon.png"))); // NOI18N
        btnSinhVien.setText("Sinh Viên    ");
        btnSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinhVienActionPerformed(evt);
            }
        });

        btnGiangVien.setBackground(new java.awt.Color(255, 0, 51));
        btnGiangVien.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnGiangVien.setForeground(new java.awt.Color(255, 255, 255));
        btnGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/teacherIcon.png"))); // NOI18N
        btnGiangVien.setText("Giảng Viên");
        btnGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiangVienActionPerformed(evt);
            }
        });

        btnKhoa.setBackground(new java.awt.Color(255, 0, 51));
        btnKhoa.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnKhoa.setForeground(new java.awt.Color(255, 255, 255));
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/schoolIcon.png"))); // NOI18N
        btnKhoa.setText("Khoa       ");
        btnKhoa.setToolTipText("");
        btnKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        btnClass.setBackground(new java.awt.Color(255, 0, 51));
        btnClass.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnClass.setForeground(new java.awt.Color(255, 255, 255));
        btnClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ClassiCon.png"))); // NOI18N
        btnClass.setText("Lớp          ");
        btnClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassActionPerformed(evt);
            }
        });

        btnMonHoc.setBackground(new java.awt.Color(255, 0, 51));
        btnMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnMonHoc.setForeground(new java.awt.Color(255, 255, 255));
        btnMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookIcon.png"))); // NOI18N
        btnMonHoc.setText("Học Phần  ");
        btnMonHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        btnDiem.setBackground(new java.awt.Color(255, 0, 51));
        btnDiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnDiem.setForeground(new java.awt.Color(255, 255, 255));
        btnDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/documentIcon.png"))); // NOI18N
        btnDiem.setText("Điểm        ");
        btnDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemActionPerformed(evt);
            }
        });

        btnDaoTao.setBackground(new java.awt.Color(255, 0, 51));
        btnDaoTao.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnDaoTao.setForeground(new java.awt.Color(255, 255, 255));
        btnDaoTao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DaoTaoIocn.png"))); // NOI18N
        btnDaoTao.setText("Đào Tạo   ");
        btnDaoTao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDaoTao.setPreferredSize(new java.awt.Dimension(127, 33));
        btnDaoTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaoTaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClass, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDaoTao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDaoTao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 80));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Ngày :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 33, -1, -1));

        lblToday.setBackground(new java.awt.Color(255, 51, 51));
        lblToday.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblToday.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lblToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 33, 280, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 170));

        jtbHienThi.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jtbHienThi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbHienThi.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jtbHienThi.setPreferredSize(new java.awt.Dimension(1265, 618));

        jLabel1.setPreferredSize(new java.awt.Dimension(1265, 618));
        jtbHienThi.addTab("Trang Chủ", jLabel1);

        jPanel1.add(jtbHienThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 130, 1300, 620));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/systemIcon.png"))); // NOI18N
        jMenu1.setText("Hệ Thống");
        jMenu1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        btnDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/loginIcon.png"))); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jMenu1.add(btnDangNhap);

        btnTaiKhoan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/userIcon.png"))); // NOI18N
        btnTaiKhoan.setText("Tài Khoản");
        btnTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });
        jMenu1.add(btnTaiKhoan);

        btnDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LogoutIcon.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(btnDangXuat);

        btnThoat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exitIcon.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jMenu1.add(btnThoat);

        jMenuBar1.add(jMenu1);

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ThongKeIcon.png"))); // NOI18N
        jMenu.setText("Thống Kê");
        jMenu.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuMouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Statistics-32.png"))); // NOI18N
        jMenuItem1.setText("Thống Kê");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem1);

        jMenuBar1.add(jMenu);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/FindIcon.png"))); // NOI18N
        jMenu2.setText("Tìm Kiếm");
        jMenu2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/InformationIcon.png"))); // NOI18N
        jMenu3.setText("Thông tin");
        jMenu3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/HelpIcon.png"))); // NOI18N
        jMenuHelp.setText("Trợ giúp");
        jMenuHelp.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jMenuHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHelpMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed

        int flag = JOptionPane.showConfirmDialog(null, "Bạn Muốn thoát phải không ?", "Thông Báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (flag == JOptionPane.YES_OPTION) {
            method.showMessegaNo("Good Bye : " + txtLogin1.getText());
            flag_Login = JF_Login.flag = "user";
            flag_TaiKhoan = JF_Login.flag_TaiKhoan = false;
            User = null;
            txtLogin1.setText("");
            AdminChoise(flag_Login);
            jtbHienThi.removeAll();
            jtbHienThi.addTab("Trang Chủ", jLabel1);

//            jf_sv.dispose();
//            jf_dt.dispose();
//            jf_tk.dispose();
//            jf_i.dispose();
//            jf_sv.dispose();
//            jf_d.dispose();
//            jf_gv.dispose();
//            jf_kh.dispose();
//            jf_lp.dispose();
//            jf_hp.dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed


    }//GEN-LAST:event_jMenu3ActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        JF_Login jf_log = new JF_Login(this);
        jf_log.setVisible(true);
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemActionPerformed

        addClosableTab(jtbHienThi, JP_Diem.getInstance(), "Quản Lý Điểm", PAGE_ICON);

    }//GEN-LAST:event_btnDiemActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed

        addClosableTab(jtbHienThi, JP_HocPhan.getInstance(), "Quản Lý Học Phần", PAGE_ICON);

    }//GEN-LAST:event_btnMonHocActionPerformed

    private void btnClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassActionPerformed

        addClosableTab(jtbHienThi, JP_Lop.getInstance(), "Quản Lý Lớp", PAGE_ICON);

    }//GEN-LAST:event_btnClassActionPerformed

    public void addClosableTab(final JTabbedPane jtbHienThi, final JComponent c, final String title, final Icon icon) {
        // Add the tab to the pane without any label
        jtbHienThi.addTab(null, c);
        int pos = jtbHienThi.indexOfComponent(c);

        // Make a small JPanel with the layout(that will space things 5px apart) and make it non-opaque
        JPanel pnlTab = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pnlTab.setOpaque(false);

        // Add a JLabel with title and the left-side tab icon
        JLabel lblTitle = new JLabel(title);
        lblTitle.setIcon(icon);

        // Create a JButton for the close tab button
        JButton btnClose = new JButton();
        btnClose.setOpaque(false);

        // Configure icon and rollover icon for button
        btnClose.setRolloverIcon(CLOSE_TAB_ICON);
        btnClose.setRolloverEnabled(true);
        //   btnClose.setIcon(RGBGrayFilter.getDisabledIcon(btnClose, CLOSE_TAB_ICON));
        btnClose.setIcon(CLOSE_TAB_ICON);
        // Set border null so the button doesn't make the tab too big
        btnClose.setBorder(null);

        // Add the listener that removes the tab
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // The component parameter must be declared "final" so that it can be
                // referenced in the anonymous listener class like this.
                jtbHienThi.remove(c);
            }
        });
        // Make sure the button can't get focus, otherwise it looks funny
        btnClose.setFocusable(false);

        // Put the panel together
        pnlTab.add(lblTitle);
        pnlTab.add(btnClose);

        // Add a thin border to keep the image below the top edge of the tab
        // when the tab is selected
        pnlTab.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));

        // Now assign the component for the tab
        jtbHienThi.setTabComponentAt(pos, pnlTab);

        // Optionally bring the new tab to the front
        jtbHienThi.setSelectedComponent(c);

        //-------------------------------------------------------------
        // Bonus: Adding a <Ctrl-W> keystroke binding to close the tab
        //-------------------------------------------------------------
        AbstractAction closeTabAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jtbHienThi.remove(c);
                int closeTabNumber = jtbHienThi.indexOfComponent(c);
                jtbHienThi.removeTabAt(closeTabNumber);
            }
        };

        // Create a keystroke
        KeyStroke controlW = KeyStroke.getKeyStroke("control W");

        // Get the appropriate input map using the JComponent constants.
        // This one works well when the component is a container. 
        InputMap inputMap = c.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // Add the key binding for the keystroke to the action name
        inputMap.put(controlW, "closeTab");

        // Now add a single binding for the action name to the anonymous action
        c.getActionMap().put("closeTab", closeTabAction);
    }
//    private final  Icon CLOSE_TAB_ICON = new ImageIcon(TabDemoFrame.class.getResource("Icon/closeTabButton.png"));
//    private final  Icon PAGE_ICON = new ImageIcon(TabDemoFrame.class.getResource("Icon/Actions-document-edit-icon.png"));
    private final Icon CLOSE_TAB_ICON = new ImageIcon("../Icon/closeTabButton.png");
    private final Icon PAGE_ICON = new ImageIcon("../Icon/Actions-document-edit-icon.png");


    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed

        addClosableTab(jtbHienThi, JP_Khoa.getInstance(), "Quản Lý Khoa", PAGE_ICON);

    }//GEN-LAST:event_btnKhoaActionPerformed

    private void btnGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiangVienActionPerformed

        addClosableTab(jtbHienThi, JP_GiangVien.getInstance(), "Quản Lý Giảng Viên", PAGE_ICON);

    }//GEN-LAST:event_btnGiangVienActionPerformed

    private void btnSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinhVienActionPerformed

        addClosableTab(jtbHienThi, JP_SinhVien.getInstance(), "Quản Lý Sinh Viên", PAGE_ICON);
    }//GEN-LAST:event_btnSinhVienActionPerformed

    private void btnDaoTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaoTaoActionPerformed

        addClosableTab(jtbHienThi, JP_DaoTao.getInstance(), "Chương Trình Đào Tạo", PAGE_ICON);
    }//GEN-LAST:event_btnDaoTaoActionPerformed

//    JF_DaoTao jf_dt = new JF_DaoTao();
//    JF_TaiKhoan jf_tk = new JF_TaiKhoan(this);
//    JF_ImportDB jf_i = new JF_ImportDB();
//    JF_SinhVien jf_sv = new JF_SinhVien();
//    JF_Diem jf_d = new JF_Diem();
//    JF_GiangVien jf_gv = new JF_GiangVien();
//    JF_Khoa jf_kh = new JF_Khoa();
//    JF_Lop jf_lp = new JF_Lop();
//    JF_HocPhan jf_hp = new JF_HocPhan();
//
//    JP_DaoTao jp_dt = new JP_DaoTao();
//    JP_Diem jp_d = new JP_Diem();
//    //JP_GiangVien jp_gv = new JP_GiangVien();
//    JP_HocPhan jp_hp = new JP_HocPhan();
//    JP_Khoa jp_kh = new JP_Khoa();
//    JP_Lop jp_lp = new JP_Lop();
//    JP_SinhVien jp_sv = new JP_SinhVien();
    JF_TaiKhoan jf_tk = null;
    

    JP_DaoTao jp_dt = null;
    JP_Diem jp_d = null;
    JP_GiangVien jp_gv = null;
    JP_HocPhan jp_hp = null;
    JP_Khoa jp_kh = null;
    JP_Lop jp_lp = null;
    JP_SinhVien jp_sv = null;

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed

        jf_tk = new JF_TaiKhoan(this);
        jf_tk.setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void jMenuHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHelpMouseClicked
        JF_Help help = new JF_Help();
        help.setVisible(true);
    }//GEN-LAST:event_jMenuHelpMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        JF_About jf_au = new JF_About();
        jf_au.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JF_Search_SV jf_sea = new JF_Search_SV();
        jf_sea.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuMouseClicked

    }//GEN-LAST:event_jMenuMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JF_ThongKe jf_thongke = new JF_ThongKe();
        jf_thongke.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Main().setVisible(true);
            }
        });
    }

    public void postData() {
        flag_Login = "user";
        flag_Login = JF_Login.flag;
        flag_TaiKhoan = JF_Login.flag_TaiKhoan;
        if (name.isEmpty()) {
            txtLogin1.setText(User.getHoTen());
        } else {
            txtLogin1.setText(name);
        }
        AdminChoise(flag_Login);
    }

    public void postDataFromTK() {
//        txtLogin1.setText(User.getHoTen());
        method.showMessegaNo("ok");
    }

    private void AdminChoise(String flag) {
        boolean check = false;
        if (flag.equals("Quản Trị Viên")) {
            check = true;
        }
        if (check) {
            btnDangNhap.setEnabled(false);
            btnDangXuat.setEnabled(true);
            btnTaiKhoan.setEnabled(true);
        } else {
            btnDangNhap.setEnabled(true);
            btnDangXuat.setEnabled(false);
            btnTaiKhoan.setEnabled(false);
        }
        btnClass.setEnabled(check);
        btnDiem.setEnabled(check);
        btnGiangVien.setEnabled(check);
        btnKhoa.setEnabled(check);
        btnMonHoc.setEnabled(check);
        btnSinhVien.setEnabled(check);
        btnDaoTao.setEnabled(check);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClass;
    private javax.swing.JMenuItem btnDangNhap;
    private javax.swing.JMenuItem btnDangXuat;
    private javax.swing.JButton btnDaoTao;
    private javax.swing.JButton btnDiem;
    private javax.swing.JButton btnGiangVien;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSinhVien;
    private javax.swing.JMenuItem btnTaiKhoan;
    private javax.swing.JMenuItem btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jtbHienThi;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblToday;
    public final javax.swing.JLabel txtLogin = new javax.swing.JLabel();
    public final javax.swing.JLabel txtLogin1 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
