package gui;

import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class QuanLiPhong extends javax.swing.JFrame {

    private ButtonGroup btnGrLoc = new ButtonGroup();

    private Phong_DAO phong_dao = new Phong_DAO();
    private LoaiPhong_DAO loaiPhong_dao = new LoaiPhong_DAO();
    private DefaultTableModel mdlPhong;

    public QuanLiPhong() {
        initComponents();
//        btnGrLoc.add(rbtnTinhTrang);
//        btnGrLoc.add(rbtnViTri);
        btnGrLoc.add(rbtnTatCa);
        rbtnTatCa.setSelected(true);
        mdlPhong = (DefaultTableModel) tbPhong.getModel();
        loadDataToTable(phong_dao.GetAllPhong());

        cboLoaiPhong.removeAllItems();
        for (LoaiPhong loaiPhong : loaiPhong_dao.getAllLoaiPhong()) {

            cboLoaiPhong.addItem(loaiPhong.getTenLoaiPhong().toString().trim());
        }

    }

    public void loadDataToTable(ArrayList<Phong> ds) {

        for (Phong x : ds) {

            String trangThaiphong = "";
            boolean tinhTrang = x.getTinhTrang();
            if (!tinhTrang) {
                trangThaiphong = "Trống";
            } else {
                trangThaiphong = "Có người thuê";
            }
//               

            Object[] obj = {x.getMaPhong(), x.getSucChua(), x.getViTri(), loaiPhong_dao.getTenLoaiPhongTheoMa(x.getLoaiPhong().getMaLoaiPhong()), trangThaiphong};
            mdlPhong.addRow(obj);
        }
    }

//    private void resetCboLoc() {
//        cboLoc.removeAllItems();
//   
//    }
//    private void loadDuLieuVaoCboLoc(String duLieu) {
//
//        cboLoc.addItem(duLieu);
////        cboLoc.setSelectedItem(null);
//
//    }
    private boolean valiData() {
        String thongbao = "";
        if (txtLau.getText().isEmpty() || txtSucChua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống trường dữ liệu");
            return false;
        }

        // vali lầu
        String regexLau = "[1-9]*$";
        Pattern patternLau = Pattern.compile(regexLau);
        Matcher matchLau = patternLau.matcher(txtLau.getText());
        boolean checkLau = matchLau.matches();
        //vali sức chứa
        String regexSucChua = "^[1-9][0-9]*$";
        Pattern patternSucChua = Pattern.compile(regexSucChua);
        Matcher matchSucChua = patternSucChua.matcher(txtSucChua.getText());
        boolean checkSucChua = matchSucChua.matches();

        if (!checkLau) {
            thongbao += "số lầu không hợp lệ (phải dương)\n";
        }
        if (!checkSucChua) {
            thongbao += "sức chứa không hợp lệ(phải dương)";
        }

        if (thongbao.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(this, thongbao);
        return false;

    }

    private void resetTable() {

        for (int i = mdlPhong.getRowCount() - 1; i >= 0; i--) {
            mdlPhong.removeRow(i);
        }

        loadDataToTable(phong_dao.GetAllPhong());

    }

    private void emptyTable() {

        for (int i = mdlPhong.getRowCount() - 1; i >= 0; i--) {
            mdlPhong.removeRow(i);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        pnPhong = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        rbtnTatCa = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cboLoaiPhong = new javax.swing.JComboBox<>();
        txtMaPhong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamLai = new javax.swing.JButton();
        txtSucChua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLau = new javax.swing.JTextField();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Sức chứa", "Vị trí", "Loại phòng", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhong);

        rbtnTatCa.setText("Tất cả");
        rbtnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnTatCa)
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(rbtnTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Quản  lí phòng");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Mã phòng");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Sức chứa");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Vị Trí");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Loại Phòng");

        cboLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaPhong.setEnabled(false);
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/add-16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemjButton7ActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/delete-16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/fix-16.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Reset-icon.png"))); // NOI18N
        btnLamLai.setText("Rỗng");
        btnLamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamLaiActionPerformed(evt);
            }
        });

        txtSucChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucChuaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Lầu:");

        txtLau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSucChua)
                            .addComponent(cboLoaiPhong, 0, 179, Short.MAX_VALUE)
                            .addComponent(txtMaPhong)
                            .addComponent(btnLamLai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLau, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 44, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel2)
                    .addComponent(txtLau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cboLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamLai)
                    .addComponent(btnSua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPhongLayout = new javax.swing.GroupLayout(pnPhong);
        pnPhong.setLayout(pnPhongLayout);
        pnPhongLayout.setHorizontalGroup(
            pnPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhongLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addGroup(pnPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPhongLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPhongLayout.setVerticalGroup(
            pnPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemjButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemjButton7ActionPerformed

        if (valiData()) {

            int Lau = Integer.parseInt(txtLau.getText());  //1
            String checkLau = "L" + Lau + "%";  //L1
            Phong phong = new Phong();
            if (phong_dao.getMaLoaiTheoViTri(checkLau).size() > 0) {
                phong = phong_dao.getMaLoaiTheoViTri(checkLau).get(phong_dao.getMaLoaiTheoViTri(checkLau).size() - 1);
            } else {
                phong = null;
            }
            System.out.println(phong);
            String maPhong = "";
            int maLoaiPhong = loaiPhong_dao.getMaLoaiTheoTen(cboLoaiPhong.getSelectedItem().toString());
            int maPhongThem = 0; // khởi tạo
            if (phong != null) {
                maPhong = phong.getMaPhong().substring(3);
                maPhongThem = Integer.parseInt(maPhong) + 1;

            } else {
                maPhongThem = 1;
            }

            if (phong_dao.ThemPhong(new Phong("L" + Lau + "_00" + maPhongThem, Integer.parseInt(txtSucChua.getText()), "Lầu " + Lau, new LoaiPhong(maLoaiPhong), false))) {
                resetTable();
            }

        }


    }//GEN-LAST:event_btnThemjButton7ActionPerformed

    private void txtSucChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucChuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucChuaActionPerformed

    private void txtLauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLauActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbPhong.getSelectedRow();
        if (row > 0) {

            Phong phong = new Phong(txtMaPhong.getText(), Integer.parseInt(txtSucChua.getText()), "Lầu " + txtLau.getText(), new LoaiPhong(loaiPhong_dao.getMaLoaiTheoTen(cboLoaiPhong.getSelectedItem().toString())));
            if (phong_dao.capNhatPhong(phong)) {
                JOptionPane.showMessageDialog(this, "cập nhật thành công");
                resetTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn 1 phòng để sửa !!!");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamLaiActionPerformed

        txtLau.setText("");
        txtSucChua.setText("");
        txtMaPhong.setText("");
    }//GEN-LAST:event_btnLamLaiActionPerformed

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        int row = tbPhong.getSelectedRow();

        txtMaPhong.setText(mdlPhong.getValueAt(row, 0).toString());
        txtSucChua.setText(mdlPhong.getValueAt(row, 1).toString());
        String viTri = mdlPhong.getValueAt(row, 2).toString().substring(4);
        txtLau.setText(viTri);
        String loaiPhong = mdlPhong.getValueAt(row, 3).toString();

        for (int i = 0; i < loaiPhong_dao.getAllLoaiPhong().size(); i++) {
            System.out.println(loaiPhong_dao.getAllLoaiPhong().get(i).getTenLoaiPhong());
            System.out.println(loaiPhong);
            if (loaiPhong_dao.getAllLoaiPhong().get(i).getTenLoaiPhong().equals(loaiPhong)) {
                cboLoaiPhong.setSelectedIndex(i);
                break;
            }

        }


    }//GEN-LAST:event_tbPhongMouseClicked

    private void rbtnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTatCaActionPerformed
//        resetCboLoc();
//        resetTable();


    }//GEN-LAST:event_rbtnTatCaActionPerformed
    public JPanel getPnPhong() {
        return pnPhong;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboLoaiPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel pnPhong;
    private javax.swing.JRadioButton rbtnTatCa;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtLau;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSucChua;
    // End of variables declaration//GEN-END:variables
}
