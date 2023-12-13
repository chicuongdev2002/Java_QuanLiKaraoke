/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.PhieuTraPhong_DAO;
import entity.PhieuTraPhong;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author HieuPCW
 */
public class TraPhong extends javax.swing.JFrame {

    private Dialog_ThanhToan frThanhToan;
    private DefaultTableModel mdlKHDP;
    private PhieuTraPhong_DAO phieuTraPhong_dao = new PhieuTraPhong_DAO();
    private ButtonGroup grbLoc = new ButtonGroup();

    public TraPhong() {
        initComponents();
        grbLoc.add(rdbSDT);
        grbLoc.add(rdbPhong);
        this.grbLoc.add(rdbAll);
        rdbAll.setSelected(true);
        this.setLocationRelativeTo(null);
        mdlKHDP = (DefaultTableModel) tbKHDP.getModel();
        loadDataToTable(phieuTraPhong_dao.GetAllPhieuTraPhong(0));


    }

    public void removeAllItemsCbo() {

        cboLoc.removeAllItems();
        cboLoc.addItem("");
        AutoCompleteDecorator.decorate(cboLoc);
    }

    public void addItemsCboSDT(ArrayList<PhieuTraPhong> dsPhieu) {
        removeAllItemsCbo();
        String flag="";
        if (dsPhieu.size() > 0) {
            for (PhieuTraPhong phieuTraPhong : dsPhieu) {
                if(phieuTraPhong.getSDT()!=flag)
                {
                    flag=phieuTraPhong.getSDT();
                   cboLoc.addItem(flag);
                }
         
            }

        }

    }

    public void addItemsCboPhong(ArrayList<PhieuTraPhong> dsPhieu) {
        removeAllItemsCbo();
        if (dsPhieu.size() > 0) {
            for (PhieuTraPhong phieuTraPhong : dsPhieu) {
                cboLoc.addItem(phieuTraPhong.getMaPhong());
            }

        }

    }

    private void resetTable() {

        for (int i = mdlKHDP.getRowCount() - 1; i >= 0; i--) {
            mdlKHDP.removeRow(i);
        }

    }

    public void loadDataToTable(ArrayList<PhieuTraPhong> ds) {
          
        if(ds.size()<=0)
        {
            JOptionPane.showMessageDialog(this,"Không tồn tại dữ liệu !!!");
            resetTable();
        }
        else
        {
                resetTable();
        for (PhieuTraPhong phieuTra : ds) {
            Object[] obj = {phieuTra.getTenKH(), phieuTra.getSDT(), phieuTra.getCMND(), phieuTra.getMaPhieuDat(), phieuTra.getMaPhong(), phieuTra.getNgayLap(), phieuTra.getGioVao()};
            mdlKHDP.addRow(obj);
        }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTraPhong = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Trả Phòng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(514, 514, 514)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout pnTraPhongLayout = new javax.swing.GroupLayout(pnTraPhong);
        pnTraPhong.setLayout(pnTraPhongLayout);
        pnTraPhongLayout.setHorizontalGroup(
            pnTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTraPhongLayout.setVerticalGroup(
            pnTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKHDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKHDPMouseClicked
        int row = tbKHDP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chọn phòng để  tra!!!!");
        } else {

            int maPhieuDat = Integer.parseInt((String) tbKHDP.getValueAt(row, 3).toString());

            try {
                frThanhToan = new Dialog_ThanhToan(maPhieuDat);

                frThanhToan.setVisible(true);
                frThanhToan.getBtnThanhToan().addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        frThanhToan.xuLiBtnThanhToan();

                 
                        loadDataToTable(phieuTraPhong_dao.GetAllPhieuTraPhong(0));
                    }
                });

            } catch (ParseException ex) {
                Logger.getLogger(TraPhong.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tbKHDPMouseClicked

    private void rdbSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSDTActionPerformed
        addItemsCboSDT(phieuTraPhong_dao.GetAllPhieuTraPhong(0));
    }//GEN-LAST:event_rdbSDTActionPerformed

    private void rdbPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongActionPerformed
         addItemsCboPhong(phieuTraPhong_dao.GetAllPhieuTraPhong(0));
    }//GEN-LAST:event_rdbPhongActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       
         String duLieuTim=cboLoc.getSelectedItem().toString();
         if(rdbSDT.isSelected())
         {
      
          loadDataToTable(phieuTraPhong_dao.GetPhieuTraPhongTheoSDT(duLieuTim,0));
         }
         else
         {
       
          loadDataToTable(phieuTraPhong_dao.GetPhieuTraPhongTheoPhong(duLieuTim,0));
         }
        
        
    }//GEN-LAST:event_btnTimActionPerformed

    private void rdbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAllActionPerformed
        loadDataToTable(phieuTraPhong_dao.GetAllPhieuTraPhong(0));
    }//GEN-LAST:event_rdbAllActionPerformed

    public JPanel getPnTraPhong() {
        return pnTraPhong;
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
            java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraPhong().setVisible(true);
                //xin chao
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnTraPhong;
    private javax.swing.JRadioButton rdbAll;
    private javax.swing.JRadioButton rdbPhong;
    private javax.swing.JRadioButton rdbSDT;
    private javax.swing.JTable tbKHDP;
    // End of variables declaration//GEN-END:variables
}
