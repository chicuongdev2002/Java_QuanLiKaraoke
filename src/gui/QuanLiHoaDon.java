/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.HoaDonDichVu_DAO;
import printer.HoaDonXuat;
import dao.PhieuTraPhong_DAO;
import entity.PhieuTraPhong;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author HieuPCW
 */
public class QuanLiHoaDon extends javax.swing.JFrame {

    private Dialog_ThanhToan frThanhToan;
    private DefaultTableModel mdlKHDP;
    private PhieuTraPhong_DAO phieuTraPhong_dao = new PhieuTraPhong_DAO();
    private ButtonGroup grbLoc = new ButtonGroup();
    private HoaDonDichVu_DAO hoaDonDichVu_dao = new HoaDonDichVu_DAO();

    public QuanLiHoaDon() {
        initComponents();
        grbLoc.add(rdbSDT);
        grbLoc.add(rdbPhong);
        this.grbLoc.add(rdbAll);
        rdbAll.setSelected(true);
        this.setLocationRelativeTo(null);
        mdlKHDP = (DefaultTableModel) tbKHDP.getModel();
        loadDataToTable(phieuTraPhong_dao.GetAllPhieuTraPhong(1));

    }

    public void removeAllItemsCbo() {

        cboLoc.removeAllItems();
        cboLoc.addItem("");
        AutoCompleteDecorator.decorate(cboLoc);
    }

    public void addItemsCboSDT(ArrayList<PhieuTraPhong> dsPhieu) {
        removeAllItemsCbo();
        String flag = "";
        if (dsPhieu.size() > 0) {
            for (PhieuTraPhong phieuTraPhong : dsPhieu) {
                if (phieuTraPhong.getSDT() != flag) {
                    flag = phieuTraPhong.getSDT();
                    cboLoc.addItem(flag);
                }

            }

        }

    }

    public void addItemsCboPhong(ArrayList<PhieuTraPhong> dsPhieu) {
        removeAllItemsCbo();
        if (dsPhieu.size() > 0) {

            String flag = "";

            for (PhieuTraPhong phieuTraPhong : dsPhieu) {
                if (flag != phieuTraPhong.getMaPhong()) {
                    flag = phieuTraPhong.getMaPhong();
                         cboLoc.addItem(flag);
                }
           
            }

        }

    }

    private void resetTable() {

        for (int i = mdlKHDP.getRowCount() - 1; i >= 0; i--) {
            mdlKHDP.removeRow(i);
        }

    }

    public void loadDataToTable(ArrayList<PhieuTraPhong> ds) {

        if (ds.size() <= 0) {
            JOptionPane.showMessageDialog(this, "Không tồn tại dữ liệu !!!");
        } else {
            resetTable();
            for (PhieuTraPhong phieuTra : ds) {
                Object[] obj = {phieuTra.getTenKH(), phieuTra.getSDT(), phieuTra.getCMND(), phieuTra.getMaPhieuDat(), phieuTra.getMaPhong(), phieuTra.getNgayLap(), phieuTra.getGioVao()};
                mdlKHDP.addRow(obj);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHoaDon = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboLoc = new javax.swing.JComboBox<>();
        rdbPhong = new javax.swing.JRadioButton();
        rdbSDT = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKHDP = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();
        rdbAll = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lí hóa đơn đã thanh toán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(427, 427, 427))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboLoc.setEditable(true);

        rdbPhong.setText("Phòng");
        rdbPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongActionPerformed(evt);
            }
        });

        rdbSDT.setText("SDT");
        rdbSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSDTActionPerformed(evt);
            }
        });

        tbKHDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Khách Hàng", "Số ĐT", "CMND", "Mã Phiếu đặt", "Phòng", "Ngày Đặt", "Giờ đặt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbKHDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKHDPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKHDP);

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        rdbAll.setText("Tất Cả");
        rdbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(rdbAll, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(rdbPhong)
                .addGap(84, 84, 84)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPhong)
                    .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(rdbAll)
                    .addComponent(rdbSDT))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Chọn vào hóa đơn trong bảng để xem chi tiết !!!");

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKHDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKHDPMouseClicked
        int row = tbKHDP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chọn phòng để xem hóa đơn!!!!");
        } else {

            int maPhieuDat = Integer.parseInt((String) tbKHDP.getValueAt(row, 3).toString());
            String ngayLap = (String) tbKHDP.getValueAt(row, 5).toString();
            String gioVao = ((String) tbKHDP.getValueAt(row, 6).toString());

            if (hoaDonDichVu_dao.layHoaDonDichVuTheoThoiGian(gioVao, ngayLap.substring(0, 10)) != null) {
                int maHDDV = hoaDonDichVu_dao.layHoaDonDichVuTheoThoiGian(gioVao, ngayLap.substring(0, 10)).getMaHDDV();

            }

            try {
                new HoaDonXuat(maPhieuDat, true).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(QuanLiHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tbKHDPMouseClicked

    private void rdbSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSDTActionPerformed
        addItemsCboSDT(phieuTraPhong_dao.GetAllPhieuTraPhong(1));
    }//GEN-LAST:event_rdbSDTActionPerformed

    private void rdbPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongActionPerformed
        addItemsCboPhong(phieuTraPhong_dao.GetAllPhieuTraPhong(1));
    }//GEN-LAST:event_rdbPhongActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        String duLieuTim = cboLoc.getSelectedItem().toString();
        if (rdbSDT.isSelected()) {

            loadDataToTable(phieuTraPhong_dao.GetPhieuTraPhongTheoSDT(duLieuTim, 1));
        } else {

            loadDataToTable(phieuTraPhong_dao.GetPhieuTraPhongTheoPhong(duLieuTim, 1));
        }


    }//GEN-LAST:event_btnTimActionPerformed

    private void rdbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAllActionPerformed
        loadDataToTable(phieuTraPhong_dao.GetAllPhieuTraPhong(1));
    }//GEN-LAST:event_rdbAllActionPerformed

    public JPanel getPnTraPhong() {
        return pnHoaDon;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiHoaDon().setVisible(true);
                //xin chao
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JRadioButton rdbAll;
    private javax.swing.JRadioButton rdbPhong;
    private javax.swing.JRadioButton rdbSDT;
    private javax.swing.JTable tbKHDP;
    // End of variables declaration//GEN-END:variables
}
