/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_GIANG_VIEN;
import DBO.DBO_KHOA;
import DLL.DLL_GiangVien;
import DLL.DLL_Khoa;
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
public class JP_GiangVien extends javax.swing.JPanel {

    ArrayList<DBO_GIANG_VIEN> lstGV = null;
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    DLL_GiangVien dLL_GiangVien = new DLL_GiangVien();
    private String dk = "";
    ArrayList<DBO_KHOA> lstKhoa = null;
    DLL_Khoa dLL_Khoa = new DLL_Khoa();

    private static JP_GiangVien instance = null;

    public static JP_GiangVien getInstance() {
        if (instance == null) {
            instance = new JP_GiangVien();
        }
        return instance;
    }

    private JP_GiangVien() {
        initComponents();
        BidingDataGV();
        BiddingcbKhoa();
        finding();
    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblGiangVien.getModel());
        tblGiangVien.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblGiangVien.getModel());
        tblGiangVien.setRowSorter(rowSorter);
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

    public void BidingDataGV() {
        lstGV = dLL_GiangVien.getAllGV();
        Vector colunm = new Vector();
        colunm.add("Mã Giảng Viên");
        colunm.add("Họ và Tên");
        colunm.add("Mã Khoa");
        colunm.add("Giới Tính");
        colunm.add("Số Điện Thoại");
        colunm.add("Email");
        colunm.add("Nơi Sinh");
        colunm.add("Trạng Thái");
        Vector data = new Vector();
        try {
            for (DBO_GIANG_VIEN item : lstGV) {
                Vector rows = new Vector();
                rows.add(item.getMaGiangVien());
                rows.add(item.getHoTenGiangVien());
                lstKhoa = dLL_Khoa.getAllKhoa_dk(item.getMaKhoa());
                if (lstKhoa.size() > 0) {
                    rows.add(lstKhoa.get(0).getTenKhoa());
                } else {
                    rows.add("Is Null");
                }
                boolean flag = item.isGioiTinh();
                String GioiTinh = "Nữ";
                if (flag) {
                    GioiTinh = "Nam";
                }
                rows.add(GioiTinh);
                rows.add(item.getSoDienThoai());
                rows.add(item.getEmail());
                rows.add(item.getNoiSinh());
                rows.add(item.getTrangThai());
                data.add(rows);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for Biding GV : " + e.toString());
        }
        tblGiangVien.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, colunm){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblGiangVien.setModel(dtm);
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

    private void res() {
        txtMaGiangVien.setText("");
        txtHoTenGiangVien.setText("");
        cbMaKhoa.setSelectedIndex(0);
        txtSoDienThoai.setText("");
        txtNoiSinh.setText("");
        txtTrangThai.setText("");
        txtEmail.setText("");
        txtMaGiangVien.requestFocus();
        rdNam.setSelected(true);
        btnUpdateGiangVien.setEnabled(false);
        btnDeleteGiangVien.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiangVien = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaGiangVien = new javax.swing.JTextField();
        txtHoTenGiangVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        cbMaKhoa = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnAddGiangVien = new javax.swing.JButton();
        btnUpdateGiangVien = new javax.swing.JButton();
        btnDeleteGiangVien = new javax.swing.JButton();
        btnResetGiangVien = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1225, 618));

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel1.setPreferredSize(new java.awt.Dimension(1230, 618));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ GIÁO VIÊN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("nb.errorForeground")));

        tblGiangVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        tblGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiangVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGiangVien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã giảng viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Họ tên giảng viên");

        txtMaGiangVien.setEnabled(false);
        txtMaGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGiangVienActionPerformed(evt);
            }
        });
        txtMaGiangVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaGiangVienKeyTyped(evt);
            }
        });

        txtHoTenGiangVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoTenGiangVienKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Số điện thoại");

        txtSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Mã ngành");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Outlook");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Quê quán");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Chức vụ");

        txtNoiSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoiSinhKeyTyped(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtTrangThai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTrangThaiKeyTyped(evt);
            }
        });

        rdNam.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        rdNu.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdNu.setText("Nữ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(33, 33, 33)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(txtMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMaKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(rdNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdNu)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtHoTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnAddGiangVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddGiangVien.setForeground(new java.awt.Color(255, 51, 51));
        btnAddGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddGiangVien.setText("Thêm");
        btnAddGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGiangVienActionPerformed(evt);
            }
        });

        btnUpdateGiangVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateGiangVien.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateGiangVien.setText("Cập nhật");
        btnUpdateGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateGiangVien.setEnabled(false);
        btnUpdateGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGiangVienActionPerformed(evt);
            }
        });

        btnDeleteGiangVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteGiangVien.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnDeleteGiangVien.setText("Xóa");
        btnDeleteGiangVien.setToolTipText("");
        btnDeleteGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteGiangVien.setEnabled(false);
        btnDeleteGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGiangVienActionPerformed(evt);
            }
        });

        btnResetGiangVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetGiangVien.setForeground(new java.awt.Color(255, 51, 51));
        btnResetGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetGiangVien.setText("Làm mới");
        btnResetGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetGiangVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetGiangVien)
                    .addComponent(btnAddGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateGiangVien, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteGiangVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddGiangVien)
                    .addComponent(btnUpdateGiangVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteGiangVien)
                    .addComponent(btnResetGiangVien))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
public void BiddingcbKhoa() {
        lstKhoa = dLL_Khoa.getAllKhoa();
        for (DBO_KHOA obj : lstKhoa) {
            cbMaKhoa.addItem(obj.getTenKhoa());
        }
    }
    private void tblGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiangVienMouseClicked
        lstGV = dLL_GiangVien.getAllGV();
        int row = tblGiangVien.getSelectedRow();
        txtMaGiangVien.setEnabled(false);
        txtMaGiangVien.setText(lstGV.get(row).getMaGiangVien());
        txtHoTenGiangVien.setText(lstGV.get(row).getHoTenGiangVien());
        lstKhoa = dLL_Khoa.getAllKhoa_dk(lstGV.get(row).getMaKhoa());
        if (lstKhoa.size() > 0) {
            cbMaKhoa.setSelectedItem(lstKhoa.get(0).getTenKhoa());
        } else {
            cbMaKhoa.setSelectedIndex(0);
        }
        rdNu.setSelected(true);
        if (lstGV.get(row).isGioiTinh()) {
            rdNam.setSelected(true);
        }
        txtSoDienThoai.setText(lstGV.get(row).getSoDienThoai());
        txtEmail.setText(lstGV.get(row).getEmail());
        txtNoiSinh.setText(lstGV.get(row).getNoiSinh());
        txtTrangThai.setText(lstGV.get(row).getTrangThai());
        dk = txtMaGiangVien.getText();
        btnUpdateGiangVien.setEnabled(true);
        btnDeleteGiangVien.setEnabled(true);
    }//GEN-LAST:event_tblGiangVienMouseClicked

    private void txtSoDienThoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKeyTyped
        onlynumber(evt, txtSoDienThoai);
        if (txtSoDienThoai.getText().length() >= 11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoDienThoaiKeyTyped

    private void btnAddGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGiangVienActionPerformed
        lstGV = dLL_GiangVien.getAllGV();
        lstKhoa = dLL_Khoa.getAllKhoa();
        txtMaGiangVien.setEnabled(true);
        String ma = txtMaGiangVien.getText();
        String ten = txtHoTenGiangVien.getText();
        Boolean gioitinh = true;
        if (rdNu.isSelected()) {
            gioitinh = false;
        }
        String sdt = txtSoDienThoai.getText();
        String ns = txtNoiSinh.getText();
        String e = txtEmail.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String mk = lstKhoa.get(cbRow).getMaKhoa();
        String tt = txtTrangThai.getText();
        lstGV = dLL_GiangVien.Check_GV(ma);

        DBO_GIANG_VIEN obj = new DBO_GIANG_VIEN();
        obj.setMaGiangVien(ma);
        obj.setHoTenGiangVien(ten);
        obj.setGioiTinh(gioitinh);
        obj.setSoDienThoai(sdt);
        obj.setNoiSinh(ns);
        obj.setEmail(e);
        obj.setMaKhoa(mk);
        obj.setTrangThai(tt);
        if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else if (lstGV.size() > 0) {
            method.showMessegaWa("Đã Tồn Tại Khoa này, Bạn không thể thêm vào nữa");
            res();
            txtMaGiangVien.requestFocus();
        } else {
            lstGV = dLL_GiangVien.Check_GV(ma);
            if (dLL_GiangVien.Insert(obj)) {
                method.showMessegaNo("Thêm Thành Công !");
                BidingDataGV();
                res();
            } else {
                method.showMessegaNo("Thêm Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnAddGiangVienActionPerformed

    private void btnResetGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetGiangVienActionPerformed
        // TODO add your handling code here:
        res();
    }//GEN-LAST:event_btnResetGiangVienActionPerformed

    private void btnDeleteGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGiangVienActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String ma = txtMaGiangVien.getText();
            if (ma.isEmpty()) {
                method.showMessegaNo("MaGV is Empty");
            } else if (dLL_GiangVien.Delete(ma)) {
                method.showMessegaNo("Xóa Thành Công !");
                BidingDataGV();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteGiangVienActionPerformed

    private void btnUpdateGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGiangVienActionPerformed
        lstKhoa = dLL_Khoa.getAllKhoa();
        String ma = txtMaGiangVien.getText();
        String ten = txtHoTenGiangVien.getText();
        Boolean gioitinh = true;
        if (rdNu.isSelected()) {
            gioitinh = false;
        }
        String sdt = txtSoDienThoai.getText();
        String ns = txtNoiSinh.getText();
        String e = txtEmail.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String makhoa = lstKhoa.get(cbRow).getMaKhoa();
        String tt = txtTrangThai.getText();
        if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            DBO_GIANG_VIEN obj = new DBO_GIANG_VIEN();
            obj.setMaGiangVien(ma);
            obj.setHoTenGiangVien(ten);
            obj.setGioiTinh(gioitinh);
            obj.setSoDienThoai(sdt);
            obj.setNoiSinh(ns);
            obj.setEmail(e);
            obj.setMaKhoa(makhoa);
            obj.setTrangThai(tt);
            if (dLL_GiangVien.Update(obj, dk)) {
                method.showMessegaNo("Cập Nhật Thành Công !");
                BidingDataGV();
                res();
            } else {
                method.showMessegaNo("Cập Nhật Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnUpdateGiangVienActionPerformed

    private void txtMaGiangVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaGiangVienKeyTyped
        if (txtMaGiangVien.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaGiangVienKeyTyped

    private void txtHoTenGiangVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoTenGiangVienKeyTyped
        if (txtHoTenGiangVien.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtHoTenGiangVienKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if (txtEmail.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtNoiSinhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoiSinhKeyTyped
        if (txtNoiSinh.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNoiSinhKeyTyped

    private void txtTrangThaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrangThaiKeyTyped
        if (txtTrangThai.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTrangThaiKeyTyped

    private void txtMaGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGiangVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGiangVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGiangVien;
    private javax.swing.JButton btnDeleteGiangVien;
    private javax.swing.JButton btnResetGiangVien;
    private javax.swing.JButton btnUpdateGiangVien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMaKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblGiangVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtHoTenGiangVien;
    private javax.swing.JTextField txtMaGiangVien;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
