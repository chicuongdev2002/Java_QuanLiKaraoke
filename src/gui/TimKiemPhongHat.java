package gui;

import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class TimKiemPhongHat extends javax.swing.JFrame {

    private ButtonGroup btnGrLoc = new ButtonGroup();

    private Phong_DAO phong_dao = new Phong_DAO();
    private LoaiPhong_DAO loaiPhong_dao = new LoaiPhong_DAO();
    private DefaultTableModel mdlPhong;
    private Set<String> s;
    public TimKiemPhongHat() {
        initComponents();
        btnGrLoc.add(rbtnTinhTrang);
        btnGrLoc.add(rbtnViTri);
        btnGrLoc.add(rbtnTatCa);
        rbtnTatCa.setSelected(false);
        mdlPhong = (DefaultTableModel) tbPhong.getModel();
        //loadDataToTable(phong_dao.GetAllPhong());

//        cboLoaiPhong.removeAllItems();
//        for (LoaiPhong loaiPhong : loaiPhong_dao.getAllLoaiPhong()) {
//
//            cboLoaiPhong.addItem(loaiPhong.getTenLoaiPhong().toString().trim());
//        }
setDanhSSachPhong();
    }

       private void setDanhSSachPhong() {
        s = new TreeSet<String>();
        ArrayList<Phong> dsPhong = phong_dao.GetAllPhong();

        for (Phong phong : dsPhong) {
            s.add(phong.getMaPhong());
        }

    }
    
    
    public void loadDataToTable(ArrayList<Phong> ds) {
        if (ds == null || ds.size() <= 0) {
            return;
        }
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

    private void resetCboLoc() {
        cboLoc.removeAllItems();

    }

    private void loadDuLieuVaoCboLoc(String duLieu) {

        cboLoc.addItem(duLieu);
//        cboLoc.setSelectedItem(null);

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
        pnTimKiem = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cboLoc = new javax.swing.JComboBox<>();
        rbtnTinhTrang = new javax.swing.JRadioButton();
        rbtnViTri = new javax.swing.JRadioButton();
        rbtnTatCa = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtMaPhong = new javax.swing.JTextField();

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/filter-16.png"))); // NOI18N
        jLabel8.setText("Lọc:");

        cboLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocActionPerformed(evt);
            }
        });

        rbtnTinhTrang.setText("Trạng thái");
        rbtnTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTinhTrangActionPerformed(evt);
            }
        });

        rbtnViTri.setText("Vị trí");
        rbtnViTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnViTriActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnTinhTrang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnViTri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnTinhTrang)
                    .addComponent(rbtnViTri)
                    .addComponent(rbtnTatCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Tìm kiếm phòng");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Mã phòng:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Search-icon.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtMaPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaPhongKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTimKiemLayout = new javax.swing.GroupLayout(pnTimKiem);
        pnTimKiem.setLayout(pnTimKiemLayout);
        pnTimKiemLayout.setHorizontalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addGroup(pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTimKiemLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTimKiemLayout.setVerticalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        int row = tbPhong.getSelectedRow();

        txtMaPhong.setText(mdlPhong.getValueAt(row, 0).toString());

        String viTri = mdlPhong.getValueAt(row, 2).toString().substring(4);

        String loaiPhong = mdlPhong.getValueAt(row, 3).toString();

        for (int i = 0; i < loaiPhong_dao.getAllLoaiPhong().size(); i++) {
            System.out.println(loaiPhong_dao.getAllLoaiPhong().get(i).getTenLoaiPhong());
            System.out.println(loaiPhong);
            if (loaiPhong_dao.getAllLoaiPhong().get(i).getTenLoaiPhong().equals(loaiPhong)) {
//                cboLoaiPhong.setSelectedIndex(i);
                break;
            }

        }


    }//GEN-LAST:event_tbPhongMouseClicked

    private void rbtnTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTinhTrangActionPerformed

        resetCboLoc();
        loadDuLieuVaoCboLoc("Trống");
        loadDuLieuVaoCboLoc("Đã có khách");


    }//GEN-LAST:event_rbtnTinhTrangActionPerformed

    private void rbtnViTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnViTriActionPerformed
        System.out.println("gui.QuanLyPhong.rbtnViTriActionPerformed()");
        resetCboLoc();

        ArrayList<Phong> DSphong = phong_dao.GetAllPhong();
        String item = "";

        for (Phong phong : DSphong) {
            if (!phong.getViTri().equals(item)) {
                item = phong.getViTri();
                loadDuLieuVaoCboLoc(item);
            }

        }


    }//GEN-LAST:event_rbtnViTriActionPerformed

    private void cboLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocActionPerformed
        System.out.println("");
        emptyTable();
//        
        if (rbtnTinhTrang.isSelected()) {
            if (cboLoc.getSelectedIndex() == 0) {
                loadDataToTable(phong_dao.GetPhongTheoTrangThai(false));
            } else {
                loadDataToTable(phong_dao.GetPhongTheoTrangThai(true));
            }

        } else if (rbtnViTri.isSelected()) {

            if (cboLoc.getSelectedItem() != null) {
                String lau = cboLoc.getSelectedItem().toString().trim().substring(4);
                System.out.println(lau);
                loadDataToTable(phong_dao.GetPhongTheoViTri("%" + lau));
            }
        }
//        


    }//GEN-LAST:event_cboLocActionPerformed

    private void rbtnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTatCaActionPerformed
        resetCboLoc();
        resetTable();


    }//GEN-LAST:event_rbtnTatCaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String maPhong = txtMaPhong.getText().trim();
        ArrayList<Phong> dsp = phong_dao.GetPhongTheoMaPhong(maPhong);
        if (dsp.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy");
        } else {
            mdlPhong.getDataVector().removeAllElements();
            loadDataToTable(dsp);
        }
        if (txtMaPhong.equals("")) {
           // timKiemTheoLoaiPhong();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtMaPhong.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtMaPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaPhongKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

        } else {

            String sdtCheck = txtMaPhong.getText();
            int sdt_lenght = sdtCheck.length();

            for (String sdt : s) {
                String check_from_data = "";
                for (int i = 0; i < sdt_lenght; i++) {
                    if (sdt_lenght <= sdt.length()) {
                        check_from_data = check_from_data + sdt.charAt(i);

                    }

                }
                if (check_from_data.equals(sdtCheck)) {
                    txtMaPhong.setText(sdt);
                    txtMaPhong.setSelectionStart(sdt_lenght);
                    txtMaPhong.setSelectionEnd(sdt.length());
                    break;
                }
            }
        }      
       
    }//GEN-LAST:event_txtMaPhongKeyReleased
    public JPanel getPnPhong() {
        return pnTimKiem;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimKiemPhongHat().setVisible(true);
            }
        });
    }

//    private void timKiemTheoLoaiPhong() {
////        String lp = cboLoaiPhong.getSelectedItem().toString();
//        int loaiPhong = phong_dao.getMaLoaiPhongByTenLoaiPhong(lp);
//        ArrayList<Phong> p = phong_dao.getPhongTheoLoaiPhong(loaiPhong);
//        if (p.size() <= 0) {
//            JOptionPane.showMessageDialog(null, "Không tìm thấy");
//        } else {
//            mdlPhong.getDataVector().removeAllElements();
//            loadDataToTable(p);
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JRadioButton rbtnTatCa;
    private javax.swing.JRadioButton rbtnTinhTrang;
    private javax.swing.JRadioButton rbtnViTri;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtMaPhong;
    // End of variables declaration//GEN-END:variables
}
