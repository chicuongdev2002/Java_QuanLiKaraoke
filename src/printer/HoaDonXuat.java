/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package printer;

import dao.DichVuOrder_DAO;
import dao.HoaDonDichVu_DAO;
import dao.HoaDonThanhToan_DAO;
import dao.NhanVien_DAO;
import dao.Phong_DAO;
import entity.DichVuOrder;
import entity.HoaDonThanhToan;
import gui.Dialog_ThanhToan;
import static gui.Dialog_ThanhToan.demGio;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HieuPCW
 */
public class HoaDonXuat extends javax.swing.JFrame {

    private DefaultTableModel mdlHDDV;
    private HoaDonThanhToan_DAO hoaDonThanhToan_dao = new HoaDonThanhToan_DAO();
    private Phong_DAO phong_dao = new Phong_DAO();

    private HoaDonDichVu_DAO hoaDonDichVu_dao = new HoaDonDichVu_DAO();
    private DichVuOrder_DAO dichVuOrder_dao = new DichVuOrder_DAO();
    private Locale localeVN = new Locale("vi", "VN");
    private NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
    private NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

    private int maHDDV;

    public HoaDonXuat(int maPhieu, boolean xemLai) throws ParseException {
        initComponents();
        mdlHDDV = (DefaultTableModel) tbHDDV.getModel();
        this.setLocationRelativeTo(null);
        HoaDonThanhToan HDTT = xemLai == true ? hoaDonThanhToan_dao.GetHoaDonThanhToanXemLai(maPhieu) : hoaDonThanhToan_dao.GetHoaDonThanhToan(maPhieu);

        loadDuLieuLenHD(HDTT);
        lblTenNhanVien.setText(nhanVien_dao.getTenNhanVienDangNhap() == "" ? "Nguyen Thanh Dat" : nhanVien_dao.getTenNhanVienDangNhap());

    }

    public void loadDuLieuLenHoaDonDichVu(ArrayList<DichVuOrder> ds) {
        if (ds.size() > 0) {

            for (DichVuOrder dv : ds) {
                double tongTien = dv.getDichVu().getSoLuongTon() * dv.getDichVu().getDonGia();

                Object[] obj = {dv.getDichVu().getTenDichVu(), dv.getDichVu().getSoLuongTon(), dv.getDichVu().getDonVi().getTenDonVi(), currencyVN.format(dv.getDichVu().getDonGia()), currencyVN.format(tongTien)};
                mdlHDDV.addRow(obj);

            }
        }
    }

    private void loadDuLieuLenHD(HoaDonThanhToan hdtt) throws ParseException {

        lblMaPhong.setText(hdtt.getPhong().getMaPhong());

        double TongTienPhong = 0;
        long gio = demGio(hdtt.getGioVao(), hdtt.getGioRa(), true);
        long phut = demGio(hdtt.getGioVao(), hdtt.getGioRa(), false);

        double giaPhong = phong_dao.getTienPhong(lblMaPhong.getText());
        lblGiaPhong.setText(currencyVN.format(giaPhong));

        if (gio == 0) {
            TongTienPhong = giaPhong;
        } else if (gio != 0 && phut == 0) {

            TongTienPhong = giaPhong * gio;
        } else {

            TongTienPhong = giaPhong * (gio + 1);
        }
        lblMaHD.setText(hdtt.getHoaDon().getMaHDP() + "");
        lblNgayVao.setText(hdtt.getNgayLap() + "");
        lblNgayRa.setText(hdtt.getNgayLap() + "");
        lblGioVao.setText(hdtt.getGioVao());
        lblGioRa.setText(hdtt.getGioRa());
        lblThoiGian.setText(hdtt.getThoiGian());

        String ngayLap = lblNgayVao.getText();

        String gioVao = lblGioVao.getText();

        if (hoaDonDichVu_dao.layHoaDonDichVuTheoThoiGian(gioVao, ngayLap.substring(0, 10)) != null) {
            maHDDV = hoaDonDichVu_dao.layHoaDonDichVuTheoThoiGian(gioVao, ngayLap.substring(0, 10)).getMaHDDV();

            lblHDDV.setText(maHDDV + "");
            System.out.println("printer.HoaDonXuat.<init>()" + lblHDDV.getText());
            loadDuLieuLenHoaDonDichVu(dichVuOrder_dao.GetAllDichVuOrderXemLai(maHDDV));
        }

        lblTienPhong.setText(TongTienPhong + "");
        System.out.println("adu" + lblHDDV.getText());
        double TongTienDichVu = tinhTongTienDichVu(dichVuOrder_dao.GetAllDichVuOrderXemLai(Integer.parseInt(lblHDDV.getText())));
        System.out.println(TongTienDichVu);
        lblTienDichVu.setText(currencyVN.format(TongTienDichVu));
        double TongTienHoaDon = TongTienDichVu + TongTienPhong;
        lblTongTien.setText(currencyVN.format(TongTienHoaDon));
//        

//        lblThanhTien.setText(TongTienHoaDon+"");
//        lblMaHDP.setText(hdtt.getHoaDon().getMaHDP() + "");
//        lblMaHDP.setVisible(false);
    }

    public JPanel getPnHoaDon() {
        return pnHoaDon;
    }

    public double tinhTongTienDichVu(ArrayList<DichVuOrder> ds) {
        double TongTien = 0;

        for (DichVuOrder dv : ds) {
            TongTien = TongTien + dv.getDichVu().getSoLuongTon() * dv.getDichVu().getDonGia();

        }

        return TongTien;
    }

    public JButton getBtnInLai() {
        return btnInLai;
    }

    public void setBtnInLai(JButton btnInLai) {
        this.btnInLai = btnInLai;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public void setBtnThoat(JButton btnThoat) {
        this.btnThoat = btnThoat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGioVao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGioRa = new javax.swing.JLabel();
        lblNgayVao = new javax.swing.JLabel();
        lblNgayRa = new javax.swing.JLabel();
        lblNgayRa1 = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHDDV = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        lblTenNhanVien1 = new javax.swing.JLabel();
        lblTenNhanVien2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHDDV = new javax.swing.JLabel();
        btnInLai = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Karaoke Nice");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Hóa Đơn Phòng ");

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMaPhong.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Giờ vào:");

        lblGioVao.setText("20:20");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Giờ ra:");

        lblGioRa.setText("20:20");

        lblNgayVao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayVao.setText("Giờ vào:");

        lblNgayRa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayRa.setText("Giờ vào:");

        lblNgayRa1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayRa1.setText("Thời gian:");

        lblThoiGian.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblThoiGian.setText("Thời gian:");

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

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
        tbHDDV.setGridColor(new java.awt.Color(255, 255, 255));
        tbHDDV.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tbHDDV);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tổng Dịch Vụ:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Giá giờ:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Thanh Toán:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        lblTongTien.setText("10.000.000");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tổng Tiền Phòng:");

        lblGiaPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGiaPhong.setText("34.000đ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Mã HD:");

        lblMaHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaHD.setText("HD001");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nhân viên:");

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenNhanVien.setText("Nguyễn Thành Đạt");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienDichVu.setText("34.000đ");

        lblTienPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienPhong.setText("34.000đ");

        lblTenNhanVien1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenNhanVien1.setText("Quý khách vui lòng kiếm tra lại hóa đơn trước khi thanh toán ");

        lblTenNhanVien2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenNhanVien2.setText("Xin cảm ơn quý khách.");

        jLabel11.setText("Hẹn gặp lại quý khách lần sau");

        lblHDDV.setText("0");
        lblHDDV.setVisible(false);

        btnInLai.setText("In Lại");
        btnInLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInLaiActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTenNhanVien1)
                .addGap(88, 88, 88))
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel11))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(lblTenNhanVien2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInLai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat)
                .addContainerGap())
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblGioRa))
                                    .addComponent(lblNgayRa1))
                                .addGap(32, 32, 32)
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblThoiGian)
                                    .addComponent(lblNgayRa)))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGioVao)
                                .addGap(29, 29, 29)
                                .addComponent(lblNgayVao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHDDV)))
                        .addGap(90, 90, 90))
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGap(31, 31, 31))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(20, 20, 20)
                                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaHD)
                                    .addComponent(lblGiaPhong)
                                    .addComponent(lblTenNhanVien)))
                            .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnHoaDonLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTienPhong))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnHoaDonLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(30, 30, 30)
                                    .addComponent(lblTienDichVu)))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(lblTongTien))
                            .addGroup(pnHoaDonLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMaPhong)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaPhong)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblGioVao)
                    .addComponent(lblNgayVao)
                    .addComponent(lblHDDV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblGioRa)
                    .addComponent(lblNgayRa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayRa1)
                    .addComponent(lblThoiGian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblTienDichVu))
                        .addGap(13, 13, 13)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblTienPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblTongTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGiaPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMaHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblTenNhanVien))
                        .addGap(18, 18, 18)
                        .addComponent(lblTenNhanVien1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenNhanVien2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThoat)
                        .addComponent(btnInLai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnInLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInLaiActionPerformed
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
//If user does not hit cancel then print.
        if (preformat != postformat) {
            this.getBtnInLai().setVisible(false);
            this.getBtnThoat().setVisible(false);
            this.dispose();

            pjob.setPrintable(new Printer(this.getPnHoaDon()), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Dialog_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }


    }//GEN-LAST:event_btnInLaiActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInLai;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblGiaPhong;
    private javax.swing.JLabel lblGioRa;
    private javax.swing.JLabel lblGioVao;
    private javax.swing.JLabel lblHDDV;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayRa;
    private javax.swing.JLabel lblNgayRa1;
    private javax.swing.JLabel lblNgayVao;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenNhanVien1;
    private javax.swing.JLabel lblTenNhanVien2;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JTable tbHDDV;
    // End of variables declaration//GEN-END:variables
}
