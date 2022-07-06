/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBO.DBO_HE_DAO_TAO;
import DBO.DBO_LOP;
import DBO.DBO_SINH_VIEN;
import DLL.DLL_HeDaoTao;
import DLL.DLL_Lop;
import DLL.DLL_SinhVien;
import MeThodShow.MyMethod;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JP_SinhVien extends javax.swing.JPanel {

    ArrayList<DBO_SINH_VIEN> lstSinhVien = null;
    ArrayList<DBO_LOP> lstLop = null;
    ArrayList<DBO_HE_DAO_TAO> lstDaoTao = null;
    DLL_SinhVien dll_sv = new DLL_SinhVien();
    DLL_Lop dll_lop = new DLL_Lop();
    DLL_HeDaoTao dll_dt = new DLL_HeDaoTao();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    private static JP_SinhVien instance = null;

    public static JP_SinhVien getInstance() {
        if (instance == null) {
            instance = new JP_SinhVien();
        }
        return instance;
    }

    private JP_SinhVien() {
        initComponents();
        BidingDataSinhVien();
        BidingcbMaLop();
        BidingcbMaHeDaoTao();
        Date date = new Date();
        txtNgaySinh.setDate(date);
        txtNgayNhapHoc.setDate(date);
    }

    private void BidingDataSinhVien() {
        lstSinhVien = dll_sv.getAllSinhVien();
        Vector Column = new Vector();
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Và Tên");
        Column.add("Ngày Sinh");
        Column.add("Giới Tính");
        Column.add("Mã Lớp");
        Column.add("Số Điện Thoại");
        Column.add("Mật Khẩu");
        Column.add("Email");
        Column.add("Mã Hệ Đào Tạo");
        Column.add("Thời Gian Học");
        Column.add("Số Điện Thoại Gia Đình");
        Column.add("Họ Tên Bố");
        Column.add("Họ Tên Mẹ");
        Column.add("Nơi Sinh");
        Column.add("Ngày Nhập Học");
        Vector data = new Vector();
        try {
            for (DBO_SINH_VIEN item : lstSinhVien) {
                Vector row = new Vector();
                row.add(item.getMaSinhVien());
                row.add(item.getHoTenSinhVien());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(item.getNgaySinh());
                row.add(date);
                boolean flag = item.isGioiTinh();
                String gioitinh = "Nam";
                if (!flag) {
                    gioitinh = "Nữ";
                }
                row.add(gioitinh);
                lstLop = dll_lop.getAllLop_dk(item.getMaLop());
                if (lstLop.size() > 0) {
                    row.add(lstLop.get(0).getTenLop());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getSoDienThoai());
                row.add(item.getMatKhau());
                row.add(item.getEmail());
                lstDaoTao = dll_dt.getAllHeDaoTao_dk(item.getMaHeDaoTao());
                if (lstLop.size() > 0) {
                    row.add(lstDaoTao.get(0).getTenHeDaoTao());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getThoiGianHoc());
                row.add(item.getSoDienThoaiGiaDinh());
                row.add(item.getHoTenBo());
                row.add(item.getHoTenMe());
                row.add(item.getNoiSinh());
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = dateFormat1.format(item.getNgayNhapHoc());
                row.add(date1);

                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding SV : " + e.toString());
        }
//        for (DBO_SINH_VIEN sv : lstSinhVien) {
//            dtm.addRow(toObjectData(sv));
//        }
        tblSinhVien.setAutoCreateRowSorter(true);
        dtm = new DefaultTableModel(data, Column) {
            public boolean isCellEditable(int rowCount, int columnCount) {
                return false;
            }
        };
        tblSinhVien.setModel(dtm);

    }

    private void BidingcbMaLop() {
        lstLop = dll_lop.getAllLop();
        for (DBO_LOP item : lstLop) {
            cbMaLop.addItem(item.getTenLop());
        }
    }

    private void BidingcbMaHeDaoTao() {
        lstDaoTao = dll_dt.getAllHeDaoTao();
        for (DBO_HE_DAO_TAO item : lstDaoTao) {
            cbMaHeDaoTao.addItem(item.getTenHeDaoTao());
        }
    }

    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (Character.isDigit(vchar) && vchar != KeyEvent.VK_BACK_SPACE && vchar != KeyEvent.VK_DELETE) {
        } else {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }

    private void res() {
        txtMaSinhVien.setText("");
        txtHoTenSinhVien.setText("");
        txtMatKhau.setText("");
        txtEmail.setText("");
        txtThoiGianHoc.setText("");
        txtNoiSinh.setText("");
        txtSoDienThoai.setText("");
        txtSoDienThoaiGiaDinh.setText("");
        txtHoTenBa.setText("");
        txtHoTenMe.setText("");
        Date date = new Date();
        txtNgaySinh.setDate(date);
        txtNgayNhapHoc.setDate(date);
        rdNam.setSelected(true);
        cbMaLop.setSelectedIndex(0);
        cbMaHeDaoTao.setSelectedIndex(0);
        btnUpdateSinhVien.setEnabled(false);
        btnDeleteSinhVien.setEnabled(false);
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
        tblSinhVien = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        txtHoTenSinhVien = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        txtNoiSinh = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtSoDienThoaiGiaDinh = new javax.swing.JTextField();
        cbMaLop = new javax.swing.JComboBox<>();
        cbMaHeDaoTao = new javax.swing.JComboBox<>();
        txtHoTenBa = new javax.swing.JTextField();
        txtHoTenMe = new javax.swing.JTextField();
        txtNgayNhapHoc = new com.toedter.calendar.JDateChooser();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtThoiGianHoc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnAddSinhVien = new javax.swing.JButton();
        btnUpdateSinhVien = new javax.swing.JButton();
        btnDeleteSinhVien = new javax.swing.JButton();
        btnResetSinhVien = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1252, 618));

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã số sinh viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Họ tên sinh viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Mật khẩu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Ngày Sinh");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Năm đào tạo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Quê quán");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Mã lớp học");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Hệ đào tạo");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Họ tên bố");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Giới tính");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("SDT cá nhân");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Ngày nhập học");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("SDT bố mẹ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Họ tên mẹ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("OutLook");

        txtMaSinhVien.setEnabled(false);
        txtMaSinhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaSinhVienKeyTyped(evt);
            }
        });

        txtHoTenSinhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoTenSinhVienKeyTyped(evt);
            }
        });

        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyTyped(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtNgaySinh.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        txtNgaySinh.setDateFormatString("yyyy-MM-dd");

        txtNoiSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoiSinhKeyTyped(evt);
            }
        });

        txtSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKeyTyped(evt);
            }
        });

        txtSoDienThoaiGiaDinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiGiaDinhKeyTyped(evt);
            }
        });

        txtHoTenBa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoTenBaKeyTyped(evt);
            }
        });

        txtHoTenMe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoTenMeKeyTyped(evt);
            }
        });

        txtNgayNhapHoc.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        txtNgayNhapHoc.setDateFormatString("yyyy-MM-dd");

        rdNam.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        rdNu.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        txtThoiGianHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtThoiGianHocKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Năm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenSinhVien)
                            .addComponent(txtMatKhau)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdNu))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDienThoaiGiaDinh))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDienThoai))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtThoiGianHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)))))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cbMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMaHeDaoTao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenBa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenMe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhapHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel8)
                        .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(txtHoTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaHeDaoTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenBa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txtHoTenMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdNam)
                                .addComponent(rdNu))
                            .addComponent(jLabel11))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgayNhapHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtThoiGianHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtSoDienThoaiGiaDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );

        jPanel6.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnAddSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddSinhVien.setForeground(new java.awt.Color(255, 51, 51));
        btnAddSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddSinhVien.setText("Thêm");
        btnAddSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSinhVienbtnAddActionPerformed(evt);
            }
        });

        btnUpdateSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateSinhVien.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdateSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateSinhVien.setText("Cập nhật");
        btnUpdateSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateSinhVien.setEnabled(false);
        btnUpdateSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSinhVienActionPerformed(evt);
            }
        });

        btnDeleteSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteSinhVien.setForeground(new java.awt.Color(255, 51, 51));
        btnDeleteSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnDeleteSinhVien.setText("Xóa");
        btnDeleteSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteSinhVien.setEnabled(false);
        btnDeleteSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSinhVienActionPerformed(evt);
            }
        });

        btnResetSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResetSinhVien.setForeground(new java.awt.Color(255, 51, 51));
        btnResetSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResetSinhVien.setText("Làm mới");
        btnResetSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSinhVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnUpdateSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAddSinhVien)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateSinhVien)
                .addGap(16, 16, 16)
                .addComponent(btnDeleteSinhVien)
                .addGap(18, 18, 18)
                .addComponent(btnResetSinhVien)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        txtMaSinhVien.setEnabled(false);
        lstSinhVien = dll_sv.getAllSinhVien();
        int row = tblSinhVien.getSelectedRow();
        txtMaSinhVien.setText(lstSinhVien.get(row).getMaSinhVien());
        txtHoTenSinhVien.setText(lstSinhVien.get(row).getHoTenSinhVien());
        Date date = lstSinhVien.get(row).getNgaySinh();
        txtNgaySinh.setDate(date);
        rdNu.setSelected(true);
        if (lstSinhVien.get(row).isGioiTinh()) {
            rdNam.setSelected(true);
        }
        lstLop = dll_lop.getAllLop_dk(lstSinhVien.get(row).getMaLop());
        // method.showMessegaNo(lstKhoa.get(0).getMaKhoa());
        if (lstLop.size() > 0) {
            cbMaLop.setSelectedItem(lstLop.get(0).getTenLop());
        } else {
            cbMaLop.setSelectedIndex(0);
        }
        txtSoDienThoai.setText(lstSinhVien.get(row).getSoDienThoai());
        txtMatKhau.setText(lstSinhVien.get(row).getMatKhau());
        txtEmail.setText(lstSinhVien.get(row).getEmail());
        lstDaoTao = dll_dt.getAllHeDaoTao_dk(lstSinhVien.get(row).getMaHeDaoTao());
        // method.showMessegaNo(lstKhoa.get(0).getMaKhoa());
        if (lstDaoTao.size() > 0) {
            cbMaHeDaoTao.setSelectedItem(lstDaoTao.get(0).getTenHeDaoTao());
        } else {
            cbMaHeDaoTao.setSelectedIndex(0);
        }
        txtThoiGianHoc.setText(String.valueOf(lstSinhVien.get(row).getThoiGianHoc()));
        txtSoDienThoaiGiaDinh.setText(lstSinhVien.get(row).getSoDienThoaiGiaDinh());
        txtHoTenBa.setText(lstSinhVien.get(row).getHoTenBo());
        txtHoTenMe.setText(lstSinhVien.get(row).getHoTenMe());
        txtNoiSinh.setText(lstSinhVien.get(row).getNoiSinh());
        Date date1 = lstSinhVien.get(row).getNgayNhapHoc();
        txtNgayNhapHoc.setDate(date1);
        dk = txtMaSinhVien.getText();
        btnDeleteSinhVien.setEnabled(true);
        btnUpdateSinhVien.setEnabled(true);
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void txtMaSinhVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSinhVienKeyTyped
        onlynumber(evt, txtMaSinhVien);
        if (txtMaSinhVien.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaSinhVienKeyTyped

    private void txtSoDienThoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKeyTyped
        onlynumber(evt, txtSoDienThoai);
        if (txtSoDienThoai.getText().length() >= 11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoDienThoaiKeyTyped

    private void txtSoDienThoaiGiaDinhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiGiaDinhKeyTyped
        onlynumber(evt, txtSoDienThoaiGiaDinh);
        if (txtSoDienThoaiGiaDinh.getText().length() >= 11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoDienThoaiGiaDinhKeyTyped

    private void txtThoiGianHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThoiGianHocKeyTyped
        onlynumber(evt, txtThoiGianHoc);
        if (txtThoiGianHoc.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtThoiGianHocKeyTyped

    private void btnAddSinhVienbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSinhVienbtnAddActionPerformed
        lstLop = dll_lop.getAllLop();
        lstDaoTao = dll_dt.getAllHeDaoTao();
        txtMaSinhVien.setEnabled(true);
        String ma = txtMaSinhVien.getText();
        String ten = txtHoTenSinhVien.getText();
        Date ngaysinh = txtNgaySinh.getDate();
        boolean gioitinh = true;
        if (rdNu.isSelected()) {
            gioitinh = false;
        }
        int cbRow = cbMaLop.getSelectedIndex();
        String malop = lstLop.get(cbRow).getMaLop();
        String sdt = txtSoDienThoai.getText();
        String mk = txtMatKhau.getText();
        String email = txtEmail.getText();
        int cbRow2 = cbMaHeDaoTao.getSelectedIndex();
        String mahdt = lstDaoTao.get(cbRow2).getMaHeDaoTao();
        String tghoc = txtThoiGianHoc.getText();
        String sdtgd = txtSoDienThoaiGiaDinh.getText();
        String hotenba = txtHoTenBa.getText();
        String hotenme = txtHoTenMe.getText();
        String noisinh = txtNoiSinh.getText();
        Date ngaynhaphoc = txtNgayNhapHoc.getDate();

        DBO_SINH_VIEN item = new DBO_SINH_VIEN();
        item.setMaSinhVien(ma);
        item.setHoTenSinhVien(ten);
        item.setNgaySinh(ngaysinh);
        item.setGioiTinh(gioitinh);
        item.setMaLop(malop);
        item.setSoDienThoai(sdt);
        item.setMatKhau(mk);
        item.setEmail(email);
        item.setMaHeDaoTao(mahdt);
        item.setThoiGianHoc(tghoc);
        item.setSoDienThoaiGiaDinh(sdtgd);
        item.setHoTenBo(hotenba);
        item.setHoTenMe(hotenme);
        item.setNoiSinh(noisinh);
        item.setNgayNhapHoc(ngaynhaphoc);

        if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty() || mk.isEmpty() || email.isEmpty()
                || txtThoiGianHoc.getText().isEmpty() || sdtgd.isEmpty() || hotenba.isEmpty() || hotenme.isEmpty()
                || noisinh.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
            txtMaSinhVien.requestFocus();
        } else {
            lstSinhVien = dll_sv.Check_SV(ma);
            if (lstSinhVien.size() < 1) {
                if (dll_sv.Insert(item)) {
                    method.showMessegaNo("Thêm Thành Công !");
                    BidingDataSinhVien();
                    res();
                } else {
                    method.showMessegaNo("Thêm Thất Bại !");
                }
            } else {
                method.showMessegaNo("Đã tồn tại dữ liệu trong cơ sở dữ liệu, Xin kiểm tra lại");
                res();
                txtMaSinhVien.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAddSinhVienbtnAddActionPerformed

    private void btnResetSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSinhVienActionPerformed
        BidingDataSinhVien();
        BidingcbMaLop();
        BidingcbMaHeDaoTao();
        res();
    }//GEN-LAST:event_btnResetSinhVienActionPerformed

    private void btnDeleteSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSinhVienActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Dữ Liệu ?", "Thông Báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String ma = txtMaSinhVien.getText();
            if (ma.isEmpty()) {
                method.showMessegaNo("MaSinhVien is Empty");
            } else if (dll_sv.Delete(ma)) {
                method.showMessegaNo("Xóa Thành Công !");
                BidingDataSinhVien();
                res();
            } else {
                method.showMessegaNo("Xóa Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnDeleteSinhVienActionPerformed

    private void btnUpdateSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSinhVienActionPerformed
        lstLop = dll_lop.getAllLop();
        lstDaoTao = dll_dt.getAllHeDaoTao();
        String ma = txtMaSinhVien.getText();
        String ten = txtHoTenSinhVien.getText();
        Date ngaysinh = txtNgaySinh.getDate();
        boolean gioitinh = true;
        if (rdNu.isSelected()) {
            gioitinh = false;
        }
        int cbRow = cbMaLop.getSelectedIndex();
        //method.showMessegaQue(cbRow + "");
        String malop = lstLop.get(cbRow).getMaLop();
        String sdt = txtSoDienThoai.getText();
        String mk = txtMatKhau.getText();
        String email = txtEmail.getText();
        int cbRow2 = cbMaHeDaoTao.getSelectedIndex();
        String mahdt = lstDaoTao.get(cbRow2).getMaHeDaoTao();
        String tghoc = txtThoiGianHoc.getText();
        String sdtgd = txtSoDienThoaiGiaDinh.getText();
        String hotenba = txtHoTenBa.getText();
        String hotenme = txtHoTenMe.getText();
        String noisinh = txtNoiSinh.getText();
        Date ngaynhaphoc = txtNgayNhapHoc.getDate();
        if (ma.isEmpty() || ten.isEmpty() || malop.isEmpty() || sdt.isEmpty() || mk.isEmpty() || email.isEmpty()
                || mahdt.isEmpty() || tghoc.isEmpty() || sdtgd.isEmpty() || hotenba.isEmpty() || hotenme.isEmpty()
                || noisinh.isEmpty()) {
            method.showMessegaNo("Bạn Cần Nhập Đầy Đủ Thông Tin !");
        } else {
            DBO_SINH_VIEN obj = new DBO_SINH_VIEN();
            obj.setMaSinhVien(ma);
            obj.setHoTenSinhVien(ten);
            obj.setNgaySinh(ngaysinh);
            obj.setGioiTinh(gioitinh);
            obj.setMaLop(malop);
            obj.setSoDienThoai(sdt);
            obj.setMatKhau(mk);
            obj.setEmail(email);
            obj.setMaHeDaoTao(mahdt);
            obj.setThoiGianHoc(tghoc);
            obj.setSoDienThoaiGiaDinh(sdtgd);
            obj.setHoTenBo(hotenba);
            obj.setHoTenMe(hotenme);
            obj.setNoiSinh(noisinh);
            obj.setNgayNhapHoc(ngaynhaphoc);
            if (dll_sv.Update(obj, dk)) {
                method.showMessegaNo("Cập Nhật Thành Công !");
                BidingDataSinhVien();
                res();
            } else {
                method.showMessegaNo("Cập Nhật Thất Bại !");
            }
        }
    }//GEN-LAST:event_btnUpdateSinhVienActionPerformed

    private void txtHoTenSinhVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoTenSinhVienKeyTyped
        if (txtHoTenSinhVien.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtHoTenSinhVienKeyTyped

    private void txtMatKhauKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyTyped
        if (txtMatKhau.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMatKhauKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if (txtEmail.getText().length() >= 1000) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtHoTenBaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoTenBaKeyTyped
        if (txtHoTenBa.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtHoTenBaKeyTyped

    private void txtHoTenMeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoTenMeKeyTyped
        if (txtHoTenMe.getText().length() >= 50) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtHoTenMeKeyTyped

    private void txtNoiSinhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoiSinhKeyTyped
        if (txtMatKhau.getText().length() >= 150) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNoiSinhKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSinhVien;
    private javax.swing.JButton btnDeleteSinhVien;
    private javax.swing.JButton btnResetSinhVien;
    private javax.swing.JButton btnUpdateSinhVien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMaHeDaoTao;
    private javax.swing.JComboBox<String> cbMaLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenBa;
    private javax.swing.JTextField txtHoTenMe;
    private javax.swing.JTextField txtHoTenSinhVien;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgayNhapHoc;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoDienThoaiGiaDinh;
    private javax.swing.JTextField txtThoiGianHoc;
    // End of variables declaration//GEN-END:variables
}
