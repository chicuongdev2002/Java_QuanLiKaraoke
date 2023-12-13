/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import connect.Connect;
import dao.KhachHang_DAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import entity.KhachHang;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HieuPCW
 */
public class QuanLiKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form KhachHang
     */
    public QuanLiKhachHang() {
        Connect.getInstance().getConnection(); // TODO Auto-generated catch block
        this.modelKH = new DefaultTableModel();
        initComponents();
        modelKH = (DefaultTableModel) tableKH.getModel();
        dskh = kh_dao.GetAllKhachHang();
        DocDuLieuVaoTable();
        txtMaKH.setEnabled(true);
    
    }

    public JPanel getContent_KH() {
        return Content_KH;
    }

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jDialog1 = new javax.swing.JDialog();
        Content_KH = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txTenKH = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        Sửa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin của khách hàng"));

        jLabel13.setText("Tên khách hàng:");

        jLabel14.setText("CMND:");

        jLabel15.setText("Ngày sinh:");

        jLabel16.setText("Số điện thoại:");

        dateNgaySinh.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txTenKH)
                    .addComponent(txtCMND)
                    .addComponent(txtSDT)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Sửa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/fix-16.png"))); // NOI18N
        Sửa.setText("Sửa");
        Sửa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SửaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Khách Hàng");

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "CMND", "NgaySinh", "SDT"
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
        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKH);

        javax.swing.GroupLayout Content_KHLayout = new javax.swing.GroupLayout(Content_KH);
        Content_KH.setLayout(Content_KHLayout);
        Content_KHLayout.setHorizontalGroup(
            Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_KHLayout.createSequentialGroup()
                .addGroup(Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Content_KHLayout.createSequentialGroup()
                        .addGroup(Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Content_KHLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jLabel2))
                            .addGroup(Content_KHLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(txtMaKH))
                            .addGroup(Content_KHLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE))
                    .addGroup(Content_KHLayout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Content_KHLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Sửa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(432, 432, 432))
        );
        Content_KHLayout.setVerticalGroup(
            Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_KHLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(Content_KHLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(txtMaKH)))
                    .addGroup(Content_KHLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Content_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sửa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Content_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Content_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SửaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SửaActionPerformed
      if(valiData()){
          CapNhatKhachHang();
      } // TODO add your handling code here:
    
    }//GEN-LAST:event_SửaActionPerformed

    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKHMouseClicked
 int row = tableKH.getSelectedRow();
        txtMaKH.setText(modelKH.getValueAt(row, 0).toString());
        txTenKH.setText(modelKH.getValueAt(row, 1).toString());
        txtCMND.setText(modelKH.getValueAt(row, 2).toString());
        try {

            java.util.Date date = (java.util.Date) new SimpleDateFormat("dd-MM-yyyy").parse((String) modelKH.getValueAt(row, 3).toString());
            dateNgaySinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:// TODO add your handling code here:// TODO add your handling code here:// TODO add your handling code here:
        txtSDT.setText(modelKH.getValueAt(row, 4).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_tableKHMouseClicked

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
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }
    private void DocDuLieuVaoTable() {
        if (dskh.size() == 0) {
            JOptionPane.showMessageDialog(null, "Không có khách hàng nào trong máy!");
            modelKH.addRow(new Object[]{"Không có thông tin", "Không có thông tin", "Không có thông tin",
                "Không có thông tin", "Không có thông tin"});
            return;
        }
        for (KhachHang item : dskh) {
            String date = formatDate((Date) item.getNgaySinh());
            modelKH.addRow(new Object[]{item.getMaKH(), item.getTenKH(),item.getCMND(), date, 
                item.getSDT()});
        }
    }
     private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        return sdf.format(date);
    }
      private void CapNhatKhachHang() {
        String ma = txtMaKH.getText().trim().equals("") ? "0" : txtMaKH.getText().trim();
        int maKH = Integer.parseInt(ma);
        String hoTen = txTenKH.getText().trim();
        String sdt = txtSDT.getText().trim();
        java.sql.Date date = new java.sql.Date(dateNgaySinh.getDate().getTime());
        String cmnd = txtCMND.getText().trim();
       KhachHang dskh=new KhachHang(maKH, hoTen, cmnd, date, sdt);
        boolean updateKH = kh_dao.CapNhatKhachHang(dskh);
        if (updateKH == true) {
            updateTable();
            JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật không thành công");
        }
    }
      private void updateTable() {
        modelKH.setRowCount(0);
        for (KhachHang kh : kh_dao.GetAllKhachHang()) {
            String date = formatDate((Date) kh.getNgaySinh());
            Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getCMND(), date,kh.getSDT()};
            modelKH.addRow(row);
        }
    }
      private boolean valiData() {
        String thongbao = "";
        if (txtSDT.getText().isEmpty() || txTenKH.getText().isEmpty() || txtCMND.getText().isEmpty() || dateNgaySinh.getDate() == null) {
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
//        if(!dateNgaySinh.getDate().after(java.time.LocalDate.now()))
//        {
//            
//        }
        if (thongbao.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(this, thongbao);
        return false;

    }
    DefaultTableModel modelKH;
    KhachHang_DAO kh_dao = new KhachHang_DAO();
    ArrayList<KhachHang> dskh;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content_KH;
    private javax.swing.JButton Sửa;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKH;
    private javax.swing.JTextField txTenKH;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
