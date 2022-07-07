
package GUI;



public class JP_Khoa extends javax.swing.JPanel {

    ArrayList<DBO_KHOA> lstKhoa = null;
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    private static JP_Khoa instance = null;

    public static JP_Khoa getInstance() {
        if (instance == null) {
            instance = new JP_Khoa();
        }
        return instance;
    }

    private JP_Khoa() {
        initComponents();
        BiddingKhoa();
        finding();
    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblKhoa.getModel());
        tblKhoa.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblKhoa.getModel());
        tblKhoa.setRowSorter(rowSorter);
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

    public void BiddingKhoa() {
        lstKhoa = dLL_Khoa.getAllKhoa();
        Vector Column = new Vector();
        Column.add("Mã Khoa");
        Column.add("Tên Khoa");
        Vector data = new Vector();
        try {
//            int i=1;
            for (DBO_KHOA item : lstKhoa) {
//                method.showMessegaWa(i+ "");
//                i++;
                Vector row = new Vector();
                row.add(item.getMaKhoa());
                row.add(item.getTenKhoa());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Khoa : " + e.toString());
        }
        tblKhoa.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblKhoa.setModel(dtm);
    }

    private void res() {
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
        btnUpdateKhoa.setEnabled(false);
        btnDeleteKhoa.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        txtTenKhoa = new javax.swing.JTextField();
        btnAddKhoa = new javax.swing.JButton();
        btnUpdateKhoa = new javax.swing.JButton();
        btnDeleteKhoa = new javax.swing.JButton();
        btnResetKhoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoa = new javax.swing.JTable();
        txtFind = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 618));

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 618));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ CHUYÊN NGÀNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã ngành");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Tên ngành");

        txtMaKhoa.setEnabled(false);
        txtMaKhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaKhoaKeyTyped(evt);
            }
        });

        txtTenKhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKhoaKeyTyped(evt);
            }
        });

        btnAddKhoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddKhoa.setForeground(new java.awt.Color(255, 51, 51));
        btnAddKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddKhoa.setText("Thêm");
        btnAddKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKhoaActionPerformed(evt);
            }
        });

        btnUpdateKhoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateKhoa.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateKhoa.setText("Cập nhật");
        btnUpdateKhoa.setToolTipText("");
        btnUpdateKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateKhoa.setEnabled(false);
        btnUpdateKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKhoaActionPerformed(evt);
            }
        });

        btnDeleteKhoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteKhoa.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnDeleteKhoa.setText("Xóa");
        btnDeleteKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteKhoa.setEnabled(false);
        btnDeleteKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKhoaActionPerformed(evt);
            }
        });

        btnResetKhoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetKhoa.setForeground(new java.awt.Color(255, 51, 51));
        btnResetKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetKhoa.setText("Làm mới");
        btnResetKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAddKhoa)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateKhoa)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteKhoa)
                .addGap(18, 18, 18)
                .addComponent(btnResetKhoa)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenKhoa)
                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddKhoa)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdateKhoa)
                        .addComponent(btnDeleteKhoa)
                        .addComponent(btnResetKhoa)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel5.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        tblKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoa);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
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
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetKhoaActionPerformed
        // TODO add your handling code here:
        res();
    }//GEN-LAST:event_btnResetKhoaActionPerformed

    private void btnDeleteKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKhoaActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Dữ Liệu ?", "Thông Báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String ma = txtMaKhoa.getText();
            if (ma.isEmpty()) {
                method.showMessegaNo("MaKhoa is Empty");
            } else if (dLL_Khoa.Delete(ma)) {
                method.showMessegaNo("Xóa Thành Công !");
                BiddingKhoa();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteKhoaActionPerformed

    private void btnAddKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKhoaActionPerformed
        String ma = txtMaKhoa.getText();
        String ten = txtTenKhoa.getText();
        txtMaKhoa.setEnabled(true);
        lstKhoa = dLL_Khoa.Check_Khoa(ma);
        if (ma.isEmpty() || ten.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else if (lstKhoa.size() > 0) {
            method.showMessegaWa("Đã Tồn Tại Khoa Này, Bạn Không Thể Thêm Vào Nữa");
            res();
            txtMaKhoa.requestFocus();
        } else {
            DBO_KHOA obj = new DBO_KHOA();
            obj.setMaKhoa(ma);
            obj.setTenKhoa(ten);
            if (dLL_Khoa.Insert(obj)) {
                method.showMessegaNo("Thêm Thành Công !");
                BiddingKhoa();
                res();
            } else {
                method.showMessegaNo("Thêm Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnAddKhoaActionPerformed

    private void btnUpdateKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKhoaActionPerformed
        String ma = txtMaKhoa.getText();
        String ten = txtTenKhoa.getText();
        if (ma.isEmpty() || ten.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            DBO_KHOA obj = new DBO_KHOA();
            obj.setMaKhoa(ma);
            obj.setTenKhoa(ten);
            if (dLL_Khoa.Update(obj, dk)) {
                method.showMessegaNo("Cập Nhật Thành Công !");
                BiddingKhoa();
                res();
            } else {
                method.showMessegaNo("Cập Nhật Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnUpdateKhoaActionPerformed

    private void tblKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaMouseClicked
        int row = tblKhoa.getSelectedRow();
        txtMaKhoa.setEnabled(false);
        lstKhoa = dLL_Khoa.getAllKhoa();
        txtMaKhoa.setText(lstKhoa.get(row).getMaKhoa());
        txtTenKhoa.setText(lstKhoa.get(row).getTenKhoa());
        btnUpdateKhoa.setEnabled(true);
        btnDeleteKhoa.setEnabled(true);
        dk = lstKhoa.get(row).getMaKhoa();
    }//GEN-LAST:event_tblKhoaMouseClicked

    private void txtMaKhoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKhoaKeyTyped
        if (txtMaKhoa.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaKhoaKeyTyped

    private void txtTenKhoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhoaKeyTyped
        if (txtTenKhoa.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTenKhoaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKhoa;
    private javax.swing.JButton btnDeleteKhoa;
    private javax.swing.JButton btnResetKhoa;
    private javax.swing.JButton btnUpdateKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhoa;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtTenKhoa;
    // End of variables declaration//GEN-END:variables
}
