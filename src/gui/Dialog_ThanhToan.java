/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.ChiTietHoaDonPhong_DAO;
import dao.DichVuOrder_DAO;
import dao.HoaDonPhong_DAO;
import dao.HoaDonThanhToan_DAO;
import dao.Phong_DAO;
import dao.HoaDonDichVu_DAO;

import entity.DichVuOrder;
import entity.HoaDonThanhToan;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
import printer.HoaDonXuat;

public class Dialog_ThanhToan extends javax.swing.JFrame {

    private DefaultTableModel mdlHDP;
    private DefaultTableModel mdlHDDV;
    private HoaDonThanhToan_DAO hoaDonThanhToan_dao = new HoaDonThanhToan_DAO();
    private Phong_DAO phong_dao = new Phong_DAO();
    private HoaDonPhong_DAO hoaDonPhong_dao = new HoaDonPhong_DAO();
    private HoaDonDichVu_DAO hoaDonDichVu_dao = new HoaDonDichVu_DAO();
    private DichVuOrder_DAO dichVuOrder_dao = new DichVuOrder_DAO();
    private Locale localeVN = new Locale("vi", "VN");
    private NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    private ChiTietHoaDonPhong_DAO chiTietHoaDonPhong_dao = new ChiTietHoaDonPhong_DAO();

    public Dialog_ThanhToan(int maPhieu) throws ParseException {
        initComponents();
        lblMaPhieu.setText(maPhieu + "");
        this.setLocationRelativeTo(null);
        lblMaHDDV.setText("");
        mdlHDP = (DefaultTableModel) tbHDP.getModel();
        mdlHDDV = (DefaultTableModel) tbHDDV.getModel();
        loadDuLieuLenHDP(hoaDonThanhToan_dao.GetHoaDonThanhToan(maPhieu));
        loadDuLieuLenHoaDonDichVu(dichVuOrder_dao.GetAllDichVuOrder(lblMaPhong.getText()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnHoaDonThanhToan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMaHDP = new javax.swing.JLabel();
        lblMaHDDV = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHDDV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHDP = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        lblMaPhong = new javax.swing.JLabel();
        lblMaPhieu = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Thanh Toán");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Thành tiền");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Tiền phòng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Tiền dịch vụ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Tổng tiền:");

        lblTienPhong.setText("24.0000");

        lblTienDichVu.setText("0");

        lblTongTien.setText("1.540.000vnd");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Chiết khấu:");

        lblMaHDDV.setVisible(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMaHDDV)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienDichVu))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienPhong))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGap(40, 40, 40)
                            .addComponent(lblTongTien)))
                    .addComponent(lblMaHDP))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(lblMaHDP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(lblTienPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTienDichVu)
                    .addComponent(lblMaHDDV))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTien))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn dịch vụ"));

        tbHDDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dịch vụ", "Số lượng", "Đơn Vị", "Đơn giá", "Số Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbHDDV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn phòng"));

        tbHDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thông tin", "Nội dung"
            }
        ));
        jScrollPane2.setViewportView(tbHDP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Credit-Card-icon.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Devices-printer-laser-icon.png"))); // NOI18N
        btnInHoaDon.setText("In Hóa Đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N

        lblMaPhieu.setText("");
        lblMaPhieu.setVisible(false);

        lblThanhTien.setText("1");
        lblThanhTien.setVisible(false);

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Close-2-icon.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHoaDonThanhToanLayout = new javax.swing.GroupLayout(pnHoaDonThanhToan);
        pnHoaDonThanhToan.setLayout(pnHoaDonThanhToanLayout);
        pnHoaDonThanhToanLayout.setHorizontalGroup(
            pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblMaPhieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThanhTien)
                .addGap(51, 51, 51))
            .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addComponent(lblMaPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonThanhToanLayout.createSequentialGroup()
                            .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(41, 41, 41))))
        );
        pnHoaDonThanhToanLayout.setVerticalGroup(
            pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblMaPhong)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaPhieu)
                    .addComponent(lblThanhTien))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(pnHoaDonThanhToanLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnHoaDonThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(btnThanhToan)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 841, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnHoaDonThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnHoaDonThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed


    }//GEN-LAST:event_btnThanhToanActionPerformed
    public void xuLiBtnThanhToan() {
        HoaDonThanhToan hdtt = hoaDonThanhToan_dao.GetHoaDonThanhToan(Integer.parseInt(lblMaPhieu.getText()));
        boolean CapNhatChiTietHoaDonPhong = chiTietHoaDonPhong_dao.capNhatThoiGianVaTienPhong(hdtt.getGioRa(), hdtt.getThoiGian(), Double.parseDouble(lblThanhTien.getText()), Integer.parseInt(lblMaHDP.getText()));

        if (lblMaHDDV.getText().isEmpty()) {

            if (hoaDonPhong_dao.capNhatTrangThaiHoaDonPhong(Integer.parseInt(lblMaHDP.getText()), true) && phong_dao.capNhatTrangThaiPhong(lblMaPhong.getText(), false) && CapNhatChiTietHoaDonPhong) {

                JOptionPane.showMessageDialog(this, "thanh toán thành công !!!");

                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "thanh toán thành that bai!!!");

                this.dispose();
            }
        } else {
            if (hoaDonPhong_dao.capNhatTrangThaiHoaDonPhong(Integer.parseInt(lblMaHDP.getText()), true) && hoaDonDichVu_dao.capNhatTrangThaiHoaDonDichVu(Integer.parseInt(lblMaHDDV.getText()), true) && phong_dao.capNhatTrangThaiPhong(lblMaPhong.getText(), false) && CapNhatChiTietHoaDonPhong) {

                JOptionPane.showMessageDialog(this, "thanh toán thành công !!!");

                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "thanh toán thành that bai!!!");

                this.dispose();
            }
        }

    }
    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed

        try {
            HoaDonXuat hdx = new HoaDonXuat(Integer.parseInt(lblMaPhieu.getText()), false);
            hdx.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    public JPanel getPnHoaDonThanhToan() {
        return pnHoaDonThanhToan;
    }

    public void loadDuLieuLenHoaDonDichVu(ArrayList<DichVuOrder> ds) {
        if (ds.size() > 0) {

            for (DichVuOrder dv : ds) {
                double tongTien = dv.getDichVu().getSoLuongTon() * dv.getDichVu().getDonGia();
                lblMaHDDV.setText(dv.getHoaDonDV().getMaHDDV() + "");
                Object[] obj = {dv.getDichVu().getTenDichVu(), dv.getDichVu().getSoLuongTon(), dv.getDichVu().getDonVi().getTenDonVi(), currencyVN.format(dv.getDichVu().getDonGia()), currencyVN.format(tongTien)};
                mdlHDDV.addRow(obj);

            }
        }
    }

    public double tinhTongTienDichVu(ArrayList<DichVuOrder> ds) {
        double TongTien = 0;

        for (DichVuOrder dv : ds) {
            TongTien = TongTien + dv.getDichVu().getSoLuongTon() * dv.getDichVu().getDonGia();

        }

        return TongTien;
    }

    public static long demGio(String gioden, String giodi, boolean donVi) throws ParseException {
        String dateStart = gioden;
        String dateStop = giodi;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date d1 = null;
        Date d2 = null;

        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);

        long diff = d2.getTime() - d1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;

        if (donVi) {
            return diffHours;
        }
        return diffMinutes;

    }

    private void loadDuLieuLenHDP(HoaDonThanhToan hdtt) throws ParseException {

        lblMaPhong.setText(hdtt.getPhong().getMaPhong());
        lblMaPhong.setVisible(false);
        double TongTienPhong = 0;
        long gio = demGio(hdtt.getGioVao(), hdtt.getGioRa(), true);
        long phut = demGio(hdtt.getGioVao(), hdtt.getGioRa(), false);

        double giaPhong = phong_dao.getTienPhong(lblMaPhong.getText());
        System.out.println(giaPhong);
        System.out.println(giaPhong);
        if (gio == 0) {
            TongTienPhong = giaPhong;
        } else if (gio != 0 && phut == 0) {

            TongTienPhong = giaPhong * gio;
        } else {

            TongTienPhong = giaPhong * (gio + 1);
        }

        Object[] objHD = {"mã hóa đơn", hdtt.getHoaDon().getMaHDP()};
        Object[] objMaKH = {"mã khách hàng", hdtt.getKhachHang().getMaKH()};
        Object[] objTenKH = {"Tên Khách hàng", hdtt.getKhachHang().getTenKH()};
        Object[] objCMND = {"CMND", hdtt.getKhachHang().getCMND()};
        Object[] objMaPhong = {"mã phòng", hdtt.getPhong().getMaPhong()};
        Object[] objNgay = {"ngày", hdtt.getNgayLap()};
        Object[] objGioVao = {"giờ vào", hdtt.getGioVao()};
        Object[] objGioRa = {"giờ ra", hdtt.getGioRa()};
        Object[] objTongTG = {"tổng thời gian", hdtt.getThoiGian()};
        Object[] objSoTien = {"tổng tiền", TongTienPhong};

        mdlHDP.addRow(objHD);
        mdlHDP.addRow(objMaKH);
        mdlHDP.addRow(objTenKH);
        mdlHDP.addRow(objCMND);
        mdlHDP.addRow(objMaPhong);
        mdlHDP.addRow(objNgay);
        mdlHDP.addRow(objGioVao);
        mdlHDP.addRow(objGioRa);
        mdlHDP.addRow(objTongTG);
        mdlHDP.addRow(objSoTien);
        lblTienPhong.setText(currencyVN.format(TongTienPhong));
        double TongTienDichVu = tinhTongTienDichVu(dichVuOrder_dao.GetAllDichVuOrder(lblMaPhong.getText()));
        lblTienDichVu.setText(currencyVN.format(TongTienDichVu));
        double TongTienHoaDon = TongTienDichVu + TongTienPhong;
        lblTongTien.setText(currencyVN.format(TongTienHoaDon));
        lblThanhTien.setText(TongTienHoaDon + "");
        lblMaHDP.setText(hdtt.getHoaDon().getMaHDP() + "");
        lblMaHDP.setVisible(false);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dialog_ThanhToan(29).setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Dialog_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JButton getBtnThanhToan() {
        return btnThanhToan;
    }

    public JButton getBtnHuy() {
        return btnHuy;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMaHDDV;
    private javax.swing.JLabel lblMaHDP;
    private javax.swing.JLabel lblMaPhieu;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnHoaDonThanhToan;
    private javax.swing.JTable tbHDDV;
    private javax.swing.JTable tbHDP;
    // End of variables declaration//GEN-END:variables
}
