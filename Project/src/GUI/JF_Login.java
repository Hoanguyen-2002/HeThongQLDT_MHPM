package GUI;

import DBO.DBO_DANG_NHAP;
import DLL.DLL_DangNhap;
import MeThodShow.MyMethod;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JF_Login extends javax.swing.JFrame {

    private DBO_DANG_NHAP dbo_log = new DBO_DANG_NHAP();
    private DLL_DangNhap dll_log = new DLL_DangNhap();
    private MyMethod method = new MyMethod();
    public ArrayList<DBO_DANG_NHAP> lstLogin = null;

    public static String flag = "user";
    public static String name = "";
    public static boolean flag_TaiKhoan= false;
    JF_Main jF_Main;

    public JF_Login(JF_Main r) {
        initComponents();
        this.setLocation(500, 200);
        this.setResizable(false);
        jF_Main = r;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Application");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tài Khoản");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mật Khẩu");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        txtTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 300, -1));

        txtMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMatKhauMouseClicked(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 300, -1));

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 51, 51));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/login.png"))); // NOI18N
        btnLogin.setText("Đăng Nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnLoginKeyReleased(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, 44));

        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 51, 51));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logoff.png"))); // NOI18N
        btnCancel.setText("Thoát");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, 44));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Back-Ground-Dang-Nhap.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void send() {
         String u = txtTaiKhoan.getText();
        String p = new String(txtMatKhau.getPassword());
        boolean check = true;
        if ((check & u.isEmpty()) || (check & p.isEmpty())) {
            check = false;
            JOptionPane.showMessageDialog(null, "Yêu Cầu Nhập Đầy Đủ Tài Khoản Và Mật Khẩu !");
            txtTaiKhoan.requestFocus();
        }
        if (check) {
            lstLogin = dll_log.checkLogin(u, p);
            if (lstLogin.size() > 0) {
                method.showMessegaNo(lstLogin.get(0).getQuyen()+ " Đăng Nhập Thành Công !\nHello : " + lstLogin.get(0).getHoTen());
                jF_Main.User = lstLogin.get(0);
                flag_TaiKhoan = true;
                flag = lstLogin.get(0).getQuyen();
                name = lstLogin.get(0).getHoTen();
                jF_Main.postData();
                this.setVisible(false);
            } else {
                method.showMessegaNo("Sai Tài Khoản Hoăc Mật Khẩu !");
                txtTaiKhoan.requestFocus();
                txtTaiKhoan.setText("");
                txtMatKhau.setText("");
            }
        }
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       send();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatKhauMouseClicked
        txtMatKhau.setText("");
    }//GEN-LAST:event_txtMatKhauMouseClicked

    private void btnLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            send();
        }
    }//GEN-LAST:event_btnLoginKeyReleased

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            send();
        }
    }//GEN-LAST:event_txtMatKhauKeyReleased

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
