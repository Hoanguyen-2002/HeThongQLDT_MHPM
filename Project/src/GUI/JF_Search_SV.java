package GUI;

import DBO.DBO_SINH_VIEN;
import DBO.DBO_DIEM;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DBO.DBO_Finding;
import DLL.DLL_Diem;
import DLL.DLL_SinhVien;
import DLL.DLL_HocPhan;
import DLL.DLL_Lop;
import DLL.DLL_Finding;
import MeThodShow.MyMethod;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JF_Search_SV extends javax.swing.JFrame {

    // this is method show message
    MyMethod method = new MyMethod();
    // lst cac thanh phan
    ArrayList<DBO_SINH_VIEN> lstSinhVien = null;
    ArrayList<DBO_HOC_PHAN> lstHocPhan = null;
    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_LOP> lstLop = null;
    ArrayList<DBO_Finding> lstketQua = null;
    // dll cac thanh phan
    DLL_SinhVien dLL_SinhVien = new DLL_SinhVien();
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_Finding dLL_Finding = new DLL_Finding();
    //
    private DefaultTableModel dtm;

    public JF_Search_SV() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        txtFiding = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scrollPanen = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfor = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finding Student");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T??M KI???M TH??NG TIN SINH VI??N");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/refreshIcon.png"))); // NOI18N
        btnClear.setText("L??m m???i");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtFiding.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtFiding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFidingMouseClicked(evt);
            }
        });
        txtFiding.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFidingKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFidingKeyTyped(evt);
            }
        });

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/FindIcon.png"))); // NOI18N
        btnFind.setText("T??m Ki???m");
        btnFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        btnFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnFindKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("M?? s??? sinh vi??n");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtFiding, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiding, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind)
                    .addComponent(jLabel2)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblDiem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPanen.setViewportView(tblDiem);

        txtInfor.setEditable(false);
        txtInfor.setBackground(new java.awt.Color(255, 255, 255));
        txtInfor.setColumns(20);
        txtInfor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtInfor.setLineWrap(true);
        txtInfor.setRows(5);
        txtInfor.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtInfor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(scrollPanen, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPanen, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        FindStudent();
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtFidingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFidingMouseClicked
        txtFiding.setText("");
    }//GEN-LAST:event_txtFidingMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Main jF_Manager = new JF_Main();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtInfor.setText("This is your information of your id");
        txtFiding.setText("Nh???p m?? s??? sinh vi??n");
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("M?? H???c Ph???n");
        Column.add("T??n H???c Ph???n");
        Column.add("??i???m C");
        Column.add("??i???m B");
        Column.add("??i???m TL1");
        Column.add("??i???m TL2");
        Column.add("??i???m Trung B??nh");
        Column.add("??i???m Ch???");
        Vector data = new Vector();
        dtm = new DefaultTableModel(data, Column);
        tblDiem.setModel(dtm);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtFidingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFidingKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            FindStudent();
        }
        
    }//GEN-LAST:event_txtFidingKeyReleased
    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }
    private void btnFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFindKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            FindStudent();
        }
    }//GEN-LAST:event_btnFindKeyReleased

    private void txtFidingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFidingKeyTyped
       onlynumber(evt, txtFiding);
    }//GEN-LAST:event_txtFidingKeyTyped

    /**
     * @param args the command line arguments
     */
    public void FindStudent() {
        String mssv = txtFiding.getText();
        String resultStudent = "";
        String gach = "\n----------------------------------\n";
        String resultSubjects = "";
        if (mssv.isEmpty()) {
            method.showMessegaWa("B???n Ph???i Nh???p ????ng sinh vi??n c???n t??m");
        } else {
            lstSinhVien = dLL_SinhVien.getAllGV_dk(mssv);
            if (lstSinhVien.size() > 0) {
                lstLop = dLL_Lop.getAllLop_dk(lstSinhVien.get(0).getMaLop());
                lstketQua = dLL_Finding.getFinding(mssv);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(lstSinhVien.get(0).getNgaySinh());
                resultStudent = "M?? sinh vi??n : " + mssv + "\nT??n Sinh Vi??n : " + lstSinhVien.get(0).getHoTenSinhVien() + "\nNg??y Sinh : " + date + "\nL???p : " + lstLop.get(0).getMaLop() + " ( " + lstLop.get(0).getTenLop() + " ) ";
                resultSubjects = "??i???m trung b??nh t??ch l??y (h??? 4): " + lstketQua.get(0).getDiemTrungBinh() + "\nS??? t??n ch??? t??ch l??y: " + lstketQua.get(0).getSoTinChiDat();
                txtInfor.setText(resultStudent + gach + resultSubjects);
                BidingData(mssv);
            } else {
                method.showMessegaQue("Kh??ng C?? Sinh Vi??n n??o c?? m?? s??? l?? : " + mssv);
            }
        }

    }

    public void BidingData(String mssv) {
        int i = 1;
        lstDiem = dLL_Diem.getAllDiem_dk_mssv(mssv);
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("M?? H???c Ph???n");
        Column.add("T??n H???c Ph???n");
        Column.add("??i???m C");
        Column.add("??i???m B");
        Column.add("??i???m TL1");
        Column.add("??i???m TL2");
        Column.add("??i???m Trung B??nh");
        Column.add("??i???m Ch???");
        Vector data = new Vector();
        try {
            for (DBO_DIEM item : lstDiem) {
                Vector row = new Vector();
                lstHocPhan = dLL_HocPhan.getAllHocPhan_dk(item.getMaHocPhan());
                row.add(i);
                i++;
                if (lstHocPhan.size() > 0) {
                    row.add(lstHocPhan.get(0).getMaHocPhan());
                } else {
                    row.add("Is Null");
                }
                if (lstHocPhan.size() > 0) {
                    row.add(lstHocPhan.get(0).getTenHocPhan());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getDiemC());
                row.add(item.getDiemB());
                row.add(item.getDiemTL1());
                row.add(item.getDiemTL2());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Diem : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDiem.setModel(dtm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPanen;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtFiding;
    private javax.swing.JTextArea txtInfor;
    // End of variables declaration//GEN-END:variables
}
