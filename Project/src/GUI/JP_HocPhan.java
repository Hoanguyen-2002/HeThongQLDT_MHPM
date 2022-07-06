/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_GIANG_VIEN;
import DBO.DBO_HOC_PHAN;
import DLL.DLL_GiangVien;
import DLL.DLL_HocPhan;
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

public class JP_HocPhan extends javax.swing.JPanel {

    ArrayList<DBO_HOC_PHAN> lstHocPhan = null;
    ArrayList<DBO_GIANG_VIEN> lstGV = null;
    DLL_HocPhan dLL_hp = new DLL_HocPhan();
    DLL_GiangVien dLL_gv = new DLL_GiangVien();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    private static JP_HocPhan instance = null;

    public static JP_HocPhan getInstance() {
        if (instance == null) {
            instance = new JP_HocPhan();
        }
        return instance;
    }

    private JP_HocPhan() {
        initComponents();
        BiddingcbGiangVien();
        BidingDataHocPhan();
        finding();
    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblHocPhan.getModel());
        tblHocPhan.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblHocPhan.getModel());
        tblHocPhan.setRowSorter(rowSorter);
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

    public void BidingDataHocPhan() {
        lstHocPhan = dLL_hp.getAllHocPhan();
        Vector Column = new Vector();
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Tên Giảng Viên");
        Column.add("Phòng Học");
        Column.add("Số Tín Chỉ");
        Column.add("Số Tiết Học");
        Column.add("Năm Học");
        Column.add("Tên Học Kỳ");

        Vector data = new Vector();
        try {
            for (DBO_HOC_PHAN item : lstHocPhan) {
                Vector row = new Vector();
                row.add(item.getMaHocPhan());
                row.add(item.getTenHocPhan());
                lstGV = dLL_gv.getAllGV_dk(item.getMaGiangVien());
                if (lstGV.size() > 0) {
                    row.add(lstGV.get(0).getHoTenGiangVien());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getPhongHoc());
                row.add(item.getSoTinChi());
                row.add(item.getSoTietHoc());
                row.add(item.getNamHoc());
                row.add(item.getTenHocKy());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding hoc Phan : " + e.toString());
        }
        tblHocPhan.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column){
            public boolean isCellEditable(int rowCount, int columnCount){
                return false;
            }
        };
        tblHocPhan.setModel(dtm);
    }

    public void BiddingcbGiangVien() {
        lstGV = dLL_gv.getAllGV();
        for (DBO_GIANG_VIEN obj : lstGV) {
            cbTenGiangVien.addItem(obj.getHoTenGiangVien());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHocPhan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHocPhan = new javax.swing.JTextField();
        txtTenHocPhan = new javax.swing.JTextField();
        txtSoTinChi = new javax.swing.JTextField();
        txtPhongHoc = new javax.swing.JTextField();
        txtNamHoc = new javax.swing.JTextField();
        txtTenHocKy = new javax.swing.JTextField();
        txtSoTietHoc = new javax.swing.JTextField();
        cbTenGiangVien = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnAddHocPhan = new javax.swing.JButton();
        btnUpdateHocPhan = new javax.swing.JButton();
        btnDeleteHocPhan = new javax.swing.JButton();
        btnResetHocPhan = new javax.swing.JButton();
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
        jLabel1.setText("QUẢN LÝ HỌC PHẦN");

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

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        tblHocPhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocPhanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHocPhan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        jPanel5.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã Học Phần");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Tên Học Phần");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Số Tín Chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Phòng Học");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Năm Học");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Học Kỳ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Số Tiết Học");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Giảng Viên");

        txtMaHocPhan.setEnabled(false);
        txtMaHocPhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaHocPhanKeyTyped(evt);
            }
        });

        txtTenHocPhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenHocPhanKeyTyped(evt);
            }
        });

        txtSoTinChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoTinChiKeyTyped(evt);
            }
        });

        txtPhongHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhongHocKeyTyped(evt);
            }
        });

        txtNamHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamHocKeyTyped(evt);
            }
        });

        txtTenHocKy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenHocKyKeyTyped(evt);
            }
        });

        txtSoTietHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoTietHocKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33)
                                .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoTietHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)
                                .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSoTietHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnAddHocPhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddHocPhan.setForeground(new java.awt.Color(255, 51, 51));
        btnAddHocPhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddHocPhan.setText("Thêm");
        btnAddHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHocPhanActionPerformed(evt);
            }
        });

        btnUpdateHocPhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateHocPhan.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateHocPhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateHocPhan.setText("Cập nhật");
        btnUpdateHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateHocPhan.setEnabled(false);
        btnUpdateHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHocPhanActionPerformed(evt);
            }
        });

        btnDeleteHocPhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteHocPhan.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteHocPhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnDeleteHocPhan.setText("Xóa");
        btnDeleteHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteHocPhan.setEnabled(false);
        btnDeleteHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHocPhanActionPerformed(evt);
            }
        });

        btnResetHocPhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetHocPhan.setForeground(new java.awt.Color(255, 51, 51));
        btnResetHocPhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetHocPhan.setText("Làm mới");
        btnResetHocPhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetHocPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetHocPhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetHocPhan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateHocPhan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteHocPhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateHocPhan)
                    .addComponent(btnAddHocPhan))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteHocPhan)
                    .addComponent(btnResetHocPhan))
                .addGap(27, 27, 27))
        );

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
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

    private void tblHocPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocPhanMouseClicked
        lstHocPhan = dLL_hp.getAllHocPhan();
        txtMaHocPhan.setEnabled(false);
        int rowtbl = tblHocPhan.getSelectedRow();
        txtMaHocPhan.setText(lstHocPhan.get(rowtbl).getMaHocPhan());
        txtTenHocPhan.setText(lstHocPhan.get(rowtbl).getTenHocPhan());
        txtPhongHoc.setText(lstHocPhan.get(rowtbl).getPhongHoc());
        txtNamHoc.setText(String.valueOf(lstHocPhan.get(rowtbl).getNamHoc()));
        txtSoTinChi.setText(String.valueOf(lstHocPhan.get(rowtbl).getSoTinChi()));
        txtTenHocKy.setText(String.valueOf(lstHocPhan.get(rowtbl).getTenHocKy()));
        txtSoTietHoc.setText(String.valueOf(lstHocPhan.get(rowtbl).getSoTietHoc()));
        lstGV = dLL_gv.getAllGV_dk(lstHocPhan.get(rowtbl).getMaGiangVien());
        if (lstGV.size() > 0) {
            cbTenGiangVien.setSelectedItem(lstGV.get(0).getHoTenGiangVien());
        } else {
            cbTenGiangVien.setSelectedIndex(0);
        }
        btnDeleteHocPhan.setEnabled(true);
        btnUpdateHocPhan.setEnabled(true);
        dk = txtMaHocPhan.getText();
    }//GEN-LAST:event_tblHocPhanMouseClicked
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
        txtMaHocPhan.setText("");
        txtTenHocPhan.setText("");
        txtSoTinChi.setText("");
        txtPhongHoc.setText("");
        cbTenGiangVien.setSelectedIndex(0);
        txtNamHoc.setText("");
        txtTenHocKy.setText("");
        txtSoTietHoc.setText("");
        txtMaHocPhan.requestFocus();
        btnUpdateHocPhan.setEnabled(false);
        btnDeleteHocPhan.setEnabled(false);
    }
    private void txtMaHocPhanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHocPhanKeyTyped
        onlynumber(evt, txtMaHocPhan);
        if (txtMaHocPhan.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaHocPhanKeyTyped

    private void txtSoTinChiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTinChiKeyTyped
        onlynumber(evt, txtSoTinChi);
        if (txtSoTinChi.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoTinChiKeyTyped

    private void txtNamHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamHocKeyTyped
        onlynumber(evt, txtNamHoc);
        if (txtNamHoc.getText().length() >= 4) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNamHocKeyTyped

    private void txtTenHocKyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenHocKyKeyTyped
        onlynumber(evt, txtTenHocKy);
        if (txtTenHocKy.getText().length() >= 1) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTenHocKyKeyTyped

    private void txtSoTietHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTietHocKeyTyped
        onlynumber(evt, txtSoTietHoc);
        if (txtSoTietHoc.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoTietHocKeyTyped

    private void btnAddHocPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHocPhanActionPerformed
        txtMaHocPhan.setEnabled(true);
        lstGV = dLL_gv.getAllGV();
        String mahp = txtMaHocPhan.getText();
        String tenhp = txtTenHocPhan.getText();
        int tc = Integer.parseInt(txtSoTinChi.getText());
        String phonghoc = txtPhongHoc.getText();
        int cbRow = cbTenGiangVien.getSelectedIndex();
        String magv = lstGV.get(cbRow).getMaGiangVien();
        int nh = Integer.parseInt(txtNamHoc.getText());
        int thk = Integer.parseInt(txtTenHocKy.getText());
        int sth = Integer.parseInt(txtSoTietHoc.getText());
        DBO_HOC_PHAN item = new DBO_HOC_PHAN();
        item.setMaHocPhan(mahp);
        item.setTenHocPhan(tenhp);
        item.setSoTinChi(tc);
        item.setPhongHoc(phonghoc);
        item.setMaGiangVien(magv);
        item.setNamHoc(nh);
        item.setTenHocKy(thk);
        item.setSoTietHoc(sth);

        if (mahp.isEmpty() || tenhp.isEmpty() || phonghoc.isEmpty() || txtSoTinChi.getText().isEmpty() || txtTenHocKy.getText().isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            lstHocPhan = dLL_hp.Check_Lop(mahp);
            if (lstHocPhan.size() < 1) {
                if (dLL_hp.Insert(item)) {
                    method.showMessegaNo("Thêm Thành Công !");
                    res();
                    BidingDataHocPhan();
                } else {
                    method.showMessegaNo("Thêm Thất Bại !");
                }
            } else {
                method.showMessegaNo("Đã tồn tại dữ liệu trong cơ sở dữ liệu, Xin kiểm tra lại");
                res();
                txtMaHocPhan.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAddHocPhanActionPerformed

    private void btnResetHocPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetHocPhanActionPerformed
        BidingDataHocPhan();
        res();
    }//GEN-LAST:event_btnResetHocPhanActionPerformed

    private void btnDeleteHocPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHocPhanActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String mahp = txtMaHocPhan.getText();
            if (mahp.isEmpty()) {
                method.showMessegaNo("This malop is Empty");
            } else if (dLL_hp.Delete(mahp)) {
                method.showMessegaNo("Xóa Thành Công !");
                BidingDataHocPhan();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteHocPhanActionPerformed

    private void btnUpdateHocPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHocPhanActionPerformed
        lstGV = dLL_gv.getAllGV();
        String mahp = txtMaHocPhan.getText();
        String tenhp = txtTenHocPhan.getText();
        int tc = Integer.parseInt(txtSoTinChi.getText());
        String phonghoc = txtPhongHoc.getText();
        int cbRow = cbTenGiangVien.getSelectedIndex();
        String magv = lstGV.get(cbRow).getMaGiangVien();
        int nh = Integer.parseInt(txtNamHoc.getText());
        int thk = Integer.parseInt(txtTenHocKy.getText());
        int sth = Integer.parseInt(txtSoTietHoc.getText());
        DBO_HOC_PHAN item = new DBO_HOC_PHAN();
        item.setMaHocPhan(mahp);
        item.setTenHocPhan(tenhp);
        item.setSoTinChi(tc);
        item.setPhongHoc(phonghoc);
        item.setMaGiangVien(magv);
        item.setNamHoc(nh);
        item.setTenHocKy(thk);
        item.setSoTietHoc(sth);
        if (mahp.isEmpty() || tenhp.isEmpty() || phonghoc.isEmpty() || txtSoTinChi.getText().isEmpty() || txtTenHocKy.getText().isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else if (dLL_hp.Update(item, dk)) {
            method.showMessegaNo("Cập Nhật Thành Công !");
            res();
            BidingDataHocPhan();
        } else {
            method.showMessegaNo("Cập Nhật Thất Bại !");
        }
    }//GEN-LAST:event_btnUpdateHocPhanActionPerformed

    private void txtTenHocPhanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenHocPhanKeyTyped
        if (txtTenHocPhan.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTenHocPhanKeyTyped

    private void txtPhongHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhongHocKeyTyped
        if (txtPhongHoc.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhongHocKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHocPhan;
    private javax.swing.JButton btnDeleteHocPhan;
    private javax.swing.JButton btnResetHocPhan;
    private javax.swing.JButton btnUpdateHocPhan;
    private javax.swing.JComboBox<String> cbTenGiangVien;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHocPhan;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtPhongHoc;
    private javax.swing.JTextField txtSoTietHoc;
    private javax.swing.JTextField txtSoTinChi;
    private javax.swing.JTextField txtTenHocKy;
    private javax.swing.JTextField txtTenHocPhan;
    // End of variables declaration//GEN-END:variables
}
