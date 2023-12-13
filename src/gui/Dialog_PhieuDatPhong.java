package gui;

import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import dao.NhanVien_DAO;
import dao.HoaDonPhong_DAO;
import dao.ChiTietHoaDonPhong_DAO;
import entity.ChiTietHoaDonPhong;

import entity.HoaDonPhong;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Dialog_PhieuDatPhong extends javax.swing.JFrame {

    private KhachHang_DAO khachHang_dao = new KhachHang_DAO();
    private PhieuDatPhong_DAO phieuDat_dao = new PhieuDatPhong_DAO();
    private Phong_DAO phong_dao = new Phong_DAO();
    private NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
    private HoaDonPhong_DAO hoaDonPhong_dao = new HoaDonPhong_DAO();
    private ChiTietHoaDonPhong_DAO chiTietHoaDonPhong_dao = new ChiTietHoaDonPhong_DAO();

    private Set<String> s;

    public Dialog_PhieuDatPhong(String maPhong) {
        initComponents();
        this.setLocationRelativeTo(null);
        lblMaPhong.setText(maPhong);
        setDanhSachSDT();

    }

    private void setDanhSachSDT() {
        s = new TreeSet<String>();
        ArrayList<KhachHang> dsKH = khachHang_dao.GetAllKhachHang();

        for (KhachHang kh : dsKH) {
            s.add(kh.getSDT());
        }

    }

    private boolean valiData() {
        String thongbao = "";
        if (txtSDT.getText().isEmpty() || txtTenKH.getText().isEmpty() || txtCMND.getText().isEmpty() || jdcNgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống trường dữ liệu");
            return false;
        }

        // vali số điện thoại
        String regexSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Pattern patternSDT = Pattern.compile(regexSDT);
        Matcher matchSDT = patternSDT.matcher(txtSDT.getText());
        boolean checkSDT = matchSDT.matches();
        //vali CMND
        String regexCMND = "^[0-9]{9}";
        Pattern patternCMND = Pattern.compile(regexCMND);
        Matcher matchCMND = patternCMND.matcher(txtCMND.getText());
        boolean checkCMND = matchCMND.matches();

        if (!checkSDT) {
            thongbao += "Số Điện Thoại Không Hợp Lệ\n";
        }
        if (!checkCMND) {
            thongbao += "chứng minh nhân phải 9 số !!";
        }

        if (thongbao.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(this, thongbao);
        return false;

    }

    private void lamMoiTxt() {
        txtCMND.setText("");
        txtTenKH.setText("");
        jdcNgaySinh.setDate(null);
        txtSDT.setText("");

        setTrangThaiTxt(true);

    }

    private boolean themPhieuDat() throws ParseException {
        KhachHang kh = khachHang_dao.getKhachHangTheoSDT(txtSDT.getText());
        Phong phong = phong_dao.getPhongTheoMa(lblMaPhong.getText()).get(0);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date ngayLap = df.parse(txtNgayDen.getText());

        if (phieuDat_dao.themPhieuDatPhong(new PhieuDatPhong(kh, phong, new java.sql.Date(ngayLap.getTime())))) {
            return true;
        }
        return false;

    }

    private boolean themHoaDonPhong() {
        NhanVien nhanVien = nhanVien_dao.getNhanVienDangNhap();
        if (nhanVien == null) {
            nhanVien = new NhanVien(2);
        }
        PhieuDatPhong phieuDat = phieuDat_dao.layPhieuDat();

        if (hoaDonPhong_dao.themHoaDonPhong(new HoaDonPhong(nhanVien, phieuDat, false))) {
            return true;
        }
        return false;

    }

    private boolean themChiTietHoaDonPhong() {
        HoaDonPhong hdp = hoaDonPhong_dao.layHoaDonPhong();
        Phong phong = phong_dao.getPhongTheoMa(lblMaPhong.getText()).get(0);

        if (chiTietHoaDonPhong_dao.themChiTietHoaDonPhong(new ChiTietHoaDonPhong(hdp, phong))) {
            return true;
        }
        return false;

    }

    private boolean capNhatTrangThaiPhong() {

        if (phong_dao.capNhatTrangThaiPhong(lblMaPhong.getText(), true)) {
            return true;
        }
        return false;

    }

    private void xuLiDatPhong() throws ParseException {

        if (themPhieuDat() && themHoaDonPhong() && themChiTietHoaDonPhong() && capNhatTrangThaiPhong()) {

            JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
            this.dispose();
            new Dialog_DatDichVu(lblMaPhong.getText()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Đặt phòng thành thất bại");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        txtNgayDen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        btnDatPhong = new javax.swing.JButton();
        txtMaKH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jLabel8.setText("jLabel8");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Số điện thoại");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tên Khách Hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cmnd");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Ngày Sinh");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Ngày đến");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jdcNgaySinh.setDateFormatString("yyy-MMM-d");

        txtNgayDen.setEnabled(true);
        txtNgayDen.setText(java.time.LocalDate.now().toString());

        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Phòng đặt");

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblMaPhong.setText("L1_P001");

        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        txtMaKH.setText("maKH");
        txtMaKH.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT)
                                    .addComponent(txtTenKH)
                                    .addComponent(txtCMND)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 45, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayDen))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtMaKH)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblMaPhong))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 25)); // NOI18N
        jLabel13.setText("Phiếu Đặt Phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed


    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
//
        if (valiData()) {
            KhachHang kh = khachHang_dao.getKhachHangTheoSDT(txtSDT.getText());
            if (kh == null) {
                try {
                    khachHang_dao.themKhachHang(createKH());
                } catch (ParseException ex) {
                    Logger.getLogger(Dialog_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
//       sự kiện xảy ra khi bấm nút đặt phòng       
            try {
                xuLiDatPhong();
            } catch (ParseException ex) {
                Logger.getLogger(Dialog_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

        } else {

            String sdtCheck = txtSDT.getText();
            int sdt_lenght = sdtCheck.length();

            for (String sdt : s) {
                String check_from_data = "";
                for (int i = 0; i < sdt_lenght; i++) {
                    if (sdt_lenght <= sdt.length()) {
                        check_from_data = check_from_data + sdt.charAt(i);

                    }

                }
                if (check_from_data.equals(sdtCheck)) {
                    txtSDT.setText(sdt);
                    txtSDT.setSelectionStart(sdt_lenght);
                    txtSDT.setSelectionEnd(sdt.length());
                    break;
                }
            }
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost

        KhachHang kh = khachHang_dao.getKhachHangTheoSDT(txtSDT.getText());
        if (kh != null) {
            txtCMND.setText(kh.getCMND());
            txtTenKH.setText(kh.getTenKH());
            jdcNgaySinh.setDate(kh.getNgaySinh());
            txtMaKH.setText(kh.getMaKH() + "");
            setTrangThaiTxt(false);

        }


    }//GEN-LAST:event_txtSDTFocusLost

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

        lamMoiTxt();


    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked
//  các hàm xử li logic

    private void setTrangThaiTxt(Boolean trangThai) {
        txtCMND.setEnabled(trangThai);
        txtTenKH.setEnabled(trangThai);
        txtCMND.setEnabled(trangThai);
        jdcNgaySinh.setEnabled(trangThai);
        txtSDT.setEnabled(trangThai);

    }

    private KhachHang createKH() throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String ngaySinh = df.format(jdcNgaySinh.getDate());
        Date ngay = df.parse(ngaySinh);
        KhachHang kh = new KhachHang(txtTenKH.getText(), txtCMND.getText(), new java.sql.Date(ngay.getTime()), txtSDT.getText());
        return kh;

    }

//    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dialog_PhieuDatPhong("L1_001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JTextField txtNgayDen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
