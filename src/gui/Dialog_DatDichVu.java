package gui;

import dao.ChiTietHoaDonDichVu_DAO;
import dao.ChiTietHoaDonPhong_DAO;
import dao.DichVuOrder_DAO;
import dao.DichVu_DAO;
import dao.DonVi_DAO;
import dao.HoaDonDichVu_DAO;
import dao.LoaiDichVu_DAO;

import entity.ChiTietHoaDonDichVu;
import entity.DichVu;
import entity.DichVuOrder;
import entity.DonViDichVu;
import entity.LoaiDichVu;
import entity.Phong;
import entity.HoaDonDichVu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Dialog_DatDichVu extends javax.swing.JFrame {

    private DefaultTableModel mdlDichVu;

    private DichVu_DAO dichVu_dao = new DichVu_DAO();
    private DonVi_DAO donVi_dao = new DonVi_DAO();
    private HoaDonDichVu_DAO hoaDonDichVu_dao = new HoaDonDichVu_DAO();
    private ChiTietHoaDonDichVu_DAO chiTietHoaDonDV_dao = new ChiTietHoaDonDichVu_DAO();
    private DichVuOrder_DAO dichVuOrder_dao = new DichVuOrder_DAO();
    private LoaiDichVu_DAO loaiDichVu_dao = new LoaiDichVu_DAO();

    private ChiTietHoaDonPhong_DAO chiTietHoaDonPhong_dao = new ChiTietHoaDonPhong_DAO();

    public Dialog_DatDichVu(String maPhong) {
        initComponents();
        txtMaPhong.setText(maPhong);

        loadDuLieuLenCboLoaiDichVu();
        mdlDichVu = (DefaultTableModel) tbOrderDichVu.getModel();
        this.setLocationRelativeTo(null);
        loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(txtMaPhong.getText()));

    }

    private void loadDuLieuLenCboLoaiDichVu() {

        ArrayList<LoaiDichVu> dsLDV = loaiDichVu_dao.getAllLoaiDichVu();
        for (LoaiDichVu loaiDV : dsLDV) {

            cboLoaiDichVu.addItem(loaiDV.getTenLoaiDichVu());

        }

    }

    private void loadDuLieuLenCboDichVu() {
        cboDichVu.removeAllItems();
        String tenDichVu = "";
        ArrayList<DichVu> dsDV = dichVu_dao.getTenDichVuByLoaiDichVu(cboLoaiDichVu.getSelectedItem().toString());
        for (DichVu DV : dsDV) {

            if (!DV.getTenDichVu().trim().equals(tenDichVu)) {

                tenDichVu = DV.getTenDichVu();
                cboDichVu.addItem(tenDichVu);
            }

        }

    }

    private void loadDuLieuLenCboDonVi() {
        cboDonVi.removeAllItems();

        try {
            if (cboDichVu.getSelectedItem() != null) {
                ArrayList<DonViDichVu> dsDonVi = donVi_dao.getTenDonViByTenDichVu(cboDichVu.getSelectedItem().toString());

                for (DonViDichVu dvdv : dsDonVi) {

                    cboDonVi.addItem(dvdv.getTenDonVi());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void emptyTable() {

        int count = tbOrderDichVu.getModel().getRowCount();
        if (count > 0) {
            for (int i = mdlDichVu.getRowCount() - 1; i >= 0; i--) {
                mdlDichVu.removeRow(i);
            }
        }
    }

    public void loadDataToTable(ArrayList<DichVuOrder> ds) {
        if (ds.size() > 0) {
            emptyTable();
            for (DichVuOrder dv : ds) {

                Object[] obj = {dv.getDichVu().getTenDichVu(), dv.getDichVu().getSoLuongTon(), dv.getDichVu().getDonVi().getTenDonVi(), dv.getDichVu().getDonGia(), dv.getNgayDat(), dv.getHoaDonDV().getMaHDDV()};
                mdlDichVu.addRow(obj);

            }
        }
    }

    private boolean themHoaDonDichVu() throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String ngayLapHD = java.time.LocalDate.now().toString();
        String maPhong = txtMaPhong.getText();
        Date ngayLap = df.parse(ngayLapHD);
        String GioVao = chiTietHoaDonPhong_dao.getGioVao(maPhong);
        if (hoaDonDichVu_dao.themHoaDonDichVu(new entity.HoaDonDichVu(new java.sql.Date(ngayLap.getTime()), new Phong(maPhong), false, GioVao))) {
            return true;
        }

        return false;

    }

    private boolean themCTHDDV() {
        DichVu dichVu = dichVu_dao.getDichVuByTenVaDonVi(cboDichVu.getSelectedItem().toString(), cboDonVi.getSelectedItem().toString());
        HoaDonDichVu hddv = hoaDonDichVu_dao.layHoaDonDichVu(txtMaPhong.getText());

        int soLuongTon = dichVu.getSoLuongTon();
        int soLuongDat = Integer.parseInt(txtSoLuong.getText());
        System.out.println(soLuongTon);
        System.out.println(soLuongDat);
        if (soLuongDat > soLuongTon) {
            JOptionPane.showMessageDialog(this, "không đủ dịch vụ để đặt" + "\n" + "số lượng tồn hiện tại là:" + soLuongTon + cboDonVi.getSelectedItem().toString());
            return false;
        } else {

            if (dichVu_dao.capNhatSoLuongDichVu(soLuongTon - soLuongDat, cboDichVu.getSelectedItem().toString(), donVi_dao.getMaDonViByTenDonVi(cboDonVi.getSelectedItem().toString())) && chiTietHoaDonDV_dao.themChiTietHoaDonDichVu(new ChiTietHoaDonDichVu(hddv, dichVu, Integer.parseInt(txtSoLuong.getText())))) {
                return true;
            }

        }
        return false;
    }

    public JPanel getContent_OrderDV() {
        return Content_OrderDV;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content_OrderDV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnOderDV = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cboDichVu = new javax.swing.JComboBox<>();
        btnThemDichVu = new javax.swing.JButton();
        cboLoaiDichVu = new javax.swing.JComboBox<>();
        cboDonVi = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderDichVu = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setText("Order dịch vụ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Order dịch vụ")));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Phòng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Loại dịch vụ:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Dịch vụ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("số lượng:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        cboDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboDichVu.setToolTipText("");
        cboDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDichVuActionPerformed(evt);
            }
        });

        btnThemDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/add.png"))); // NOI18N
        btnThemDichVu.setText("Đặt");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        cboLoaiDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboLoaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiDichVuActionPerformed(evt);
            }
        });

        cboDonVi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDonViActionPerformed(evt);
            }
        });

        txtGia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtGia.setForeground(new java.awt.Color(255, 51, 51));

        txtMaPhong.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtGia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboLoaiDichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboDichVu, 0, 171, Short.MAX_VALUE)
                                .addComponent(txtMaPhong)))
                        .addGap(137, 137, 137))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch vụ đã đặt"));

        tbOrderDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Số lượng", "Đơn vị", "Đơn giá", "Ngày đặt", "Mã hóa đơn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbOrderDichVu);

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/delete-16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_mainMenu/logout.png"))); // NOI18N
        btnHuy.setText("Thoat");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnOderDVLayout = new javax.swing.GroupLayout(pnOderDV);
        pnOderDV.setLayout(pnOderDVLayout);
        pnOderDVLayout.setHorizontalGroup(
            pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOderDVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(pnOderDVLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnOderDVLayout.setVerticalGroup(
            pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOderDVLayout.createSequentialGroup()
                .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOderDVLayout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel7))
                    .addGroup(pnOderDVLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout Content_OrderDVLayout = new javax.swing.GroupLayout(Content_OrderDV);
        Content_OrderDV.setLayout(Content_OrderDVLayout);
        Content_OrderDVLayout.setHorizontalGroup(
            Content_OrderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_OrderDVLayout.createSequentialGroup()
                .addComponent(pnOderDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Content_OrderDVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356))
        );
        Content_OrderDVLayout.setVerticalGroup(
            Content_OrderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_OrderDVLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOderDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Content_OrderDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Content_OrderDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int row = tbOrderDichVu.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chọn 1 dịch vụ  để  hủy !!!!");
        } else {
            System.out.println("gui.OrderDichVu.btnXoaActionPerformed()");

            String tenDV = (String) tbOrderDichVu.getValueAt(row, 0).toString();
            String donViDV = (String) tbOrderDichVu.getValueAt(row, 2).toString();
            int soLuongHienTai = dichVu_dao.getDichVuByTenVaDonVi(cboDichVu.getSelectedItem().toString(), cboDonVi.getSelectedItem().toString()).getSoLuongTon();
            int soLuongDVDat = Integer.parseInt((String) tbOrderDichVu.getValueAt(row, 1).toString());
            int maHDDV = Integer.parseInt((String) tbOrderDichVu.getValueAt(row, 5).toString());
            int maDV = dichVu_dao.getDichVuByTenVaDonVi(tenDV, donViDV).getMaDichVu();

//            
            if (dichVu_dao.capNhatSoLuongDichVu(soLuongHienTai + soLuongDVDat, cboDichVu.getSelectedItem().toString(), donVi_dao.getMaDonViByTenDonVi(cboDonVi.getSelectedItem().toString())) && chiTietHoaDonDV_dao.xoaDichVuOrder(maHDDV, maDV)) {
                JOptionPane.showMessageDialog(this, "hủy dịch vụ thành công !!");
                emptyTable();
                loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(txtMaPhong.getText()));
                if (mdlDichVu.getRowCount() <= 0) {
                    try {
                        hoaDonDichVu_dao.xoaHoaDonDichVu(txtMaPhong.getText());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void cboLoaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiDichVuActionPerformed

        loadDuLieuLenCboDichVu();


    }//GEN-LAST:event_cboLoaiDichVuActionPerformed

    private void cboDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDichVuActionPerformed

        loadDuLieuLenCboDonVi();
    }//GEN-LAST:event_cboDichVuActionPerformed

    private void cboDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDonViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDonViActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        if (valiData()) {
            try {
                if (hoaDonDichVu_dao.KiemTraTrangThaiHoaDonDichVu(txtMaPhong.getText())) {
                    if (!themHoaDonDichVu()) {
                        JOptionPane.showMessageDialog(this, "Loi !!");
                    }
                }
//        
            } catch (ParseException ex) {
                Logger.getLogger(Dialog_DatDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }

            String tenDichVu = cboDichVu.getSelectedItem().toString();
            String donVi = cboDonVi.getSelectedItem().toString();
            String maPhong = txtMaPhong.getText();
            int maDichVu = dichVu_dao.getDichVuByTenVaDonVi(tenDichVu, donVi).getMaDichVu();
            if (chiTietHoaDonDV_dao.KiemTraDichVuTonTai(maDichVu, maPhong)) {

                DichVu dichVu = dichVu_dao.getDichVuByTenVaDonVi(cboDichVu.getSelectedItem().toString(), cboDonVi.getSelectedItem().toString());
                int soLuongTon = dichVu.getSoLuongTon();
                int soLuongDat = Integer.parseInt(txtSoLuong.getText());
                System.out.println(soLuongTon);
                System.out.println(soLuongDat);
                if (soLuongDat > soLuongTon) {
                    JOptionPane.showMessageDialog(this, "không đủ dịch vụ để đặt" + "\n" + "số lượng tồn hiện tại là:" + soLuongTon + cboDonVi.getSelectedItem().toString());
                } else {

                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    int soLuongCu = chiTietHoaDonDV_dao.laySoLuongDichVuDatDat(maDichVu, hoaDonDichVu_dao.layHoaDonDichVu(txtMaPhong.getText()).getMaHDDV());
                    System.out.println(soLuong + "\t" + soLuongCu);
                    if (dichVu_dao.capNhatSoLuongDichVu(soLuongTon - soLuongDat, tenDichVu, donVi_dao.getMaDonViByTenDonVi(cboDonVi.getSelectedItem().toString())) && chiTietHoaDonDV_dao.capNhatSoLuongDichVu(soLuong + soLuongCu, maDichVu, hoaDonDichVu_dao.layHoaDonDichVuTheoPhong(maPhong).getMaHDDV())) {
                        loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(txtMaPhong.getText()));
                        JOptionPane.showMessageDialog(this, "Order Dich Vu Thanh Cong !!");
                    }
                }
            } else {
                if (themCTHDDV()) {
                    JOptionPane.showMessageDialog(this, "Order Dich Vu Thanh Cong !!");

                    loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(txtMaPhong.getText()));
                }
            }
        }
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dialog_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dialog_DatDichVu("L1_001").setVisible(true);
            }
        });
    }

    private boolean valiData() {
        String thongbao = "";
        if (txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống trường dữ liệu");
            return false;
        }
        String regexSoLuong = "^[1-9][0-9]*$";
        Pattern patternSoLuong = Pattern.compile(regexSoLuong);
        Matcher matchSoLuong = patternSoLuong.matcher(txtSoLuong.getText());
        boolean checkSoLuong = matchSoLuong.matches();

        if (!checkSoLuong) {
            thongbao += "Số lượng phải lớn hơn 0\n";
        }

        if (thongbao.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(this, thongbao);
        return false;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content_OrderDV;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDichVu;
    private javax.swing.JComboBox<String> cboDonVi;
    private javax.swing.JComboBox<String> cboLoaiDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnOderDV;
    private javax.swing.JTable tbOrderDichVu;
    private javax.swing.JLabel txtGia;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
