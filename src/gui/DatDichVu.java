package gui;

import dao.ChiTietHoaDonDichVu_DAO;
import dao.ChiTietHoaDonPhong_DAO;
import dao.DichVuOrder_DAO;
import dao.DichVu_DAO;
import dao.DonVi_DAO;
import dao.HoaDonDichVu_DAO;
import dao.LoaiDichVu_DAO;
import dao.Phong_DAO;

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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class DatDichVu extends javax.swing.JFrame {

    private DefaultTableModel mdlDichVu;
    private Phong_DAO phong_dao = new Phong_DAO();
    private DichVu_DAO dichVu_dao = new DichVu_DAO();
    private DonVi_DAO donVi_dao = new DonVi_DAO();
    private HoaDonDichVu_DAO hoaDonDichVu_dao = new HoaDonDichVu_DAO();
    private ChiTietHoaDonDichVu_DAO chiTietHoaDonDV_dao = new ChiTietHoaDonDichVu_DAO();
    private DichVuOrder_DAO dichVuOrder_dao = new DichVuOrder_DAO();
    private LoaiDichVu_DAO loaiDichVu_dao = new LoaiDichVu_DAO();
//
    private ChiTietHoaDonPhong_DAO chiTietHoaDonPhong_dao = new ChiTietHoaDonPhong_DAO();

    public DatDichVu(String maPhong) {
        initComponents();
        lblMaPhong.setText(maPhong);
        loadDuLieuLenCboPhong();
        loadDuLieuLenCboLoaiDichVu();
        mdlDichVu = (DefaultTableModel) tbOrderDichVu.getModel();
        this.setLocationRelativeTo(null);

    }

    private void loadDuLieuLenCboPhong() {
        cboMaPhong.addItem("");
        ArrayList<Phong> dsPhong = phong_dao.GetPhongTheoTrangThai(true);
        if (dsPhong.size() > 0) {
            for (Phong phong : dsPhong) {

                cboMaPhong.addItem(phong.getMaPhong());

            }

        } else {
            btnThemDichVu.setEnabled(false);
            btnXoa.setEnabled(false);
        }

        AutoCompleteDecorator.decorate(cboMaPhong);
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
        String maPhong = cboMaPhong.getSelectedItem().toString();
        Date ngayLap = df.parse(ngayLapHD);
        String GioVao = chiTietHoaDonPhong_dao.getGioVao(maPhong);
        if (hoaDonDichVu_dao.themHoaDonDichVu(new entity.HoaDonDichVu(new java.sql.Date(ngayLap.getTime()), new Phong(maPhong), false, GioVao))) {
            return true;
        }
        return false;

    }

    private boolean themCTHDDV() {
        DichVu dichVu = dichVu_dao.getDichVuByTenVaDonVi(cboDichVu.getSelectedItem().toString(), cboDonVi.getSelectedItem().toString());
        HoaDonDichVu hddv = hoaDonDichVu_dao.layHoaDonDichVu(cboMaPhong.getSelectedItem().toString());

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
        cboMaPhong = new javax.swing.JComboBox<>();
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
        lblMaPhong = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderDichVu = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Đặt dịch vụ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Order dịch vụ")));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Phòng:");

        cboMaPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaPhongActionPerformed(evt);
            }
        });
        cboMaPhong.setEditable(true);

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

        lblMaPhong.setText("");
        lblMaPhong.setVisible(false);

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
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboLoaiDichVu, 0, 171, Short.MAX_VALUE)
                                    .addComponent(cboDichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMaPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(lblMaPhong)))
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblMaPhong))
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
                .addGap(18, 18, 18)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addGap(12, 12, 12))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Beer-icon (1).png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/drink-coca-cola-icon.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Fruits-Vegetables-icon -64.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Cigarette-icon.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Alcohol-Brandy-icon.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/32376-pancakes-icon.png"))); // NOI18N

        javax.swing.GroupLayout pnOderDVLayout = new javax.swing.GroupLayout(pnOderDV);
        pnOderDV.setLayout(pnOderDVLayout);
        pnOderDVLayout.setHorizontalGroup(
            pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOderDVLayout.createSequentialGroup()
                .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnOderDVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnOderDVLayout.createSequentialGroup()
                        .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel11)))
                        .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jLabel7))
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel14))
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(13, 13, 13)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnOderDVLayout.setVerticalGroup(
            pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOderDVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOderDVLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnOderDVLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnOderDVLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)))))
                        .addGap(36, 36, 36)
                        .addGroup(pnOderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(241, 241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Content_OrderDVLayout = new javax.swing.GroupLayout(Content_OrderDV);
        Content_OrderDV.setLayout(Content_OrderDVLayout);
        Content_OrderDVLayout.setHorizontalGroup(
            Content_OrderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_OrderDVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnOderDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Content_OrderDVLayout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Content_OrderDVLayout.setVerticalGroup(
            Content_OrderDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_OrderDVLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnOderDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
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
                .addComponent(Content_OrderDV, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(cboMaPhong.getSelectedItem().toString()));
                if (mdlDichVu.getRowCount() <= 0) {
                    try {
                        hoaDonDichVu_dao.xoaHoaDonDichVu(cboMaPhong.getSelectedItem().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaPhongActionPerformed

        try {

            emptyTable();
            String maPhong = cboMaPhong.getSelectedItem().toString();
            loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(maPhong));
        } catch (Exception e) {
            System.out.println("ngoai le");
        }

//        }
//        

    }//GEN-LAST:event_cboMaPhongActionPerformed

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
                if (hoaDonDichVu_dao.KiemTraTrangThaiHoaDonDichVu(cboMaPhong.getSelectedItem().toString())) {
                    if (!themHoaDonDichVu()) {
                        JOptionPane.showMessageDialog(this, "Loi !!");
                    }
                }
//        
            } catch (ParseException ex) {
                Logger.getLogger(DatDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }

            String tenDichVu = cboDichVu.getSelectedItem().toString();
            String donVi = cboDonVi.getSelectedItem().toString();
            String maPhong = cboMaPhong.getSelectedItem().toString();
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
                    int soLuongCu = chiTietHoaDonDV_dao.laySoLuongDichVuDatDat(maDichVu, hoaDonDichVu_dao.layHoaDonDichVu(cboMaPhong.getSelectedItem().toString()).getMaHDDV());
                    System.out.println(soLuong + "\t" + soLuongCu);
                    if (dichVu_dao.capNhatSoLuongDichVu(soLuongTon - soLuongDat, tenDichVu, donVi_dao.getMaDonViByTenDonVi(cboDonVi.getSelectedItem().toString())) && chiTietHoaDonDV_dao.capNhatSoLuongDichVu(soLuong + soLuongCu, maDichVu, hoaDonDichVu_dao.layHoaDonDichVuTheoPhong(maPhong).getMaHDDV())) {
                        loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(cboMaPhong.getSelectedItem().toString()));
                        JOptionPane.showMessageDialog(this, "Order Dich Vu Thanh Cong !!");
                    }
                }
            } else {
                if (themCTHDDV()) {
                    JOptionPane.showMessageDialog(this, "Order Dich Vu Thanh Cong nha !!");

                    loadDataToTable(dichVuOrder_dao.GetAllDichVuOrder(cboMaPhong.getSelectedItem().toString()));
                }
            }
        }
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatDichVu("L1_001").setVisible(true);
            }
        });
    }

    private boolean valiData() {
        String thongbao = "";
        if (txtSoLuong.getText().isEmpty()||cboMaPhong.getSelectedItem().toString()=="") {
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
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDichVu;
    private javax.swing.JComboBox<String> cboDonVi;
    private javax.swing.JComboBox<String> cboLoaiDichVu;
    private javax.swing.JComboBox<String> cboMaPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JPanel pnOderDV;
    private javax.swing.JTable tbOrderDichVu;
    private javax.swing.JLabel txtGia;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
