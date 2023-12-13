/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import gui.DatPhong;
import gui.QuanLiKhachHang;
import gui.TrangChu;
import javax.swing.JPanel;

import java.awt.*;

/**
 *
 * @author HieuPCW
 */
public class Global_Layout_NhanVien extends javax.swing.JFrame {

    NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
    TaiKhoan_DAO taiKhoan_dao = new TaiKhoan_DAO();

    DatPhong datPhongGUI = new DatPhong();
    QuanLiKhachHang khachHangGUI = new QuanLiKhachHang();

    TrangChu trangChuNhanVienGUI;
    QuanLiPhong phongGUI;
    TimKiemPhongHat timKiemPhongGUI;
    TimKiemKhachHang timKiemKhachHangGUI;

    DatDichVu orderdichVuGUI;
    TimKiemDichVu timKiemDichVuGUI;

    QuanLiLoaiDichVu loaiDVGUI;
    QuanLiDonViDichVu donViDichVuGUI;
    QuanLiLoaiPhong loaiPhongGUI;
    TroGiup trogiupGUI;

//    Dialog_HoaDonThanhToan hoaDonPhongGUI = new Dialog_HoaDonThanhToan(1);
    TimKiemNhanVien timKiemNhanVienGUI;
    QuanLiNhanVien nhanVienGUI;
    TrangChu trangChuQLGUI;
    boolean active_CapNhatPhong = false;

    public void setActive_CapNhatPhong(boolean active_CapNhatPhong) {
        this.active_CapNhatPhong = active_CapNhatPhong;
    }

    public void logout() {
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });

    }

    public Global_Layout_NhanVien(String tenNhanVien) {
        initComponents();
        this.setSize(1650, 1080);
        this.setLocationRelativeTo(null);
        trangChuNhanVienGUI = new TrangChu(tenNhanVien);
        trangChuNhanVienGUI.getBtnLogout().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

//                   nhanVien_dao.resetLogin();
//                 
                logout();
                taiKhoan_dao.capNhatTrangThaiDangNhap(trangChuNhanVienGUI.getTaiKhoan().getText(), 0);

            }

        });

        RenderLayout(trangChuNhanVienGUI.getpanel_TrangChu());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Content = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuTrangChu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jmiDatPhong = new javax.swing.JMenuItem();
        jmiOrder = new javax.swing.JMenuItem();
        jmiTraPhong = new javax.swing.JMenuItem();
        MenuOrder = new javax.swing.JMenu();
        jmiTimKiemDV = new javax.swing.JMenuItem();
        MenuKH = new javax.swing.JMenu();
        jmiCapNhatKhach = new javax.swing.JMenuItem();
        jmiTimKiemKhach = new javax.swing.JMenuItem();
        MenuDatPhong = new javax.swing.JMenu();
        jmiTimKiemPhong = new javax.swing.JMenuItem();
        jmiHoaDon = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_Content.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Panel_ContentMouseMoved(evt);
            }
        });
        Panel_Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ContentMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_ContentMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Panel_ContentMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout Panel_ContentLayout = new javax.swing.GroupLayout(Panel_Content);
        Panel_Content.setLayout(Panel_ContentLayout);
        Panel_ContentLayout.setHorizontalGroup(
            Panel_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        Panel_ContentLayout.setVerticalGroup(
            Panel_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        MenuTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/trangchu-icon.png"))); // NOI18N
        MenuTrangChu.setText("Trang chủ");
        MenuTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTrangChuMouseClicked(evt);
            }
        });
        MenuTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTrangChuActionPerformed(evt);
            }
        });
        jMenuBar1.add(MenuTrangChu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/NhanVien-icon-24.png"))); // NOI18N
        jMenu1.setText("Nhân Viên");

        jmiDatPhong.setText("Đặt Phòng");
        jmiDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDatPhongActionPerformed(evt);
            }
        });
        jMenu1.add(jmiDatPhong);

        jmiOrder.setText(" Đặt Dịch Vụ");
        jmiOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOrderActionPerformed(evt);
            }
        });
        jMenu1.add(jmiOrder);

        jmiTraPhong.setText("Trả Phòng");
        jmiTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTraPhongActionPerformed(evt);
            }
        });
        jMenu1.add(jmiTraPhong);

        jMenuBar1.add(jMenu1);

        MenuOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/dichvu-icon.png"))); // NOI18N
        MenuOrder.setText("Dịch vụ");

        jmiTimKiemDV.setText("Tìm kiếm Dịch Vụ");
        jmiTimKiemDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTimKiemDVActionPerformed(evt);
            }
        });
        MenuOrder.add(jmiTimKiemDV);

        jMenuBar1.add(MenuOrder);

        MenuKH.setBackground(new java.awt.Color(0, 0, 0));
        MenuKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/KhachHang-icon.png"))); // NOI18N
        MenuKH.setText("Khách hàng");

        jmiCapNhatKhach.setText("Cập nhật khách hàng");
        jmiCapNhatKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCapNhatKhachActionPerformed(evt);
            }
        });
        MenuKH.add(jmiCapNhatKhach);

        jmiTimKiemKhach.setText("Tìm kiếm khách hàng");
        jmiTimKiemKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTimKiemKhachActionPerformed(evt);
            }
        });
        MenuKH.add(jmiTimKiemKhach);

        jMenuBar1.add(MenuKH);

        MenuDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/phong-icon.png"))); // NOI18N
        MenuDatPhong.setText(" Phòng");

        jmiTimKiemPhong.setText("Tìm kiếm phòng");
        jmiTimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTimKiemPhongActionPerformed(evt);
            }
        });
        MenuDatPhong.add(jmiTimKiemPhong);

        jMenuBar1.add(MenuDatPhong);

        jmiHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/hoaDn-icon.png"))); // NOI18N
        jmiHoaDon.setText("Hóa Đơn");
        jmiHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiHoaDonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmiHoaDon);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons-menuBar/help-icon.png"))); // NOI18N
        jMenu3.setText("Trợ giúp");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        jMenuItem2.setText("Hướng dẫn sử dụng");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Panel_Content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Panel_ContentMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ContentMouseMoved

        if (active_CapNhatPhong) {

            enableActionMovedPhong();

        } else {
            disableActionMovedPhong();
        }
    }//GEN-LAST:event_Panel_ContentMouseMoved

    private void Panel_ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ContentMouseClicked
        System.out.println("gui.Global_Layout_QuanLi.Panel_ContentMouseClicked()");
    }//GEN-LAST:event_Panel_ContentMouseClicked

    private void Panel_ContentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ContentMouseExited

    }//GEN-LAST:event_Panel_ContentMouseExited

    private void Panel_ContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ContentMouseReleased

    }//GEN-LAST:event_Panel_ContentMouseReleased

    private void MenuTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTrangChuMouseClicked
        this.setActive_CapNhatPhong(false);
        ;
        RenderLayout(trangChuNhanVienGUI.getpanel_TrangChu());
    }//GEN-LAST:event_MenuTrangChuMouseClicked

    private void MenuTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTrangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuTrangChuActionPerformed

    private void jmiDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDatPhongActionPerformed
        this.setActive_CapNhatPhong(true);
        ;
        datPhongGUI = new DatPhong();
        RenderLayout(datPhongGUI.getContent_DP());
    }//GEN-LAST:event_jmiDatPhongActionPerformed

    private void jmiOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOrderActionPerformed

        this.setActive_CapNhatPhong(false);
        ;
        orderdichVuGUI = new DatDichVu("");
        RenderLayout(orderdichVuGUI.getContent_OrderDV());
    }//GEN-LAST:event_jmiOrderActionPerformed

    private void jmiTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTraPhongActionPerformed
        this.setActive_CapNhatPhong(false);
        ;
        RenderLayout(new TraPhong().getPnTraPhong());

    }//GEN-LAST:event_jmiTraPhongActionPerformed

    private void jmiTimKiemDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTimKiemDVActionPerformed
        this.setActive_CapNhatPhong(false);
        ;
        timKiemDichVuGUI = new TimKiemDichVu();
        RenderLayout(timKiemDichVuGUI.getPnTimKiemDichVu());
    }//GEN-LAST:event_jmiTimKiemDVActionPerformed

    private void jmiCapNhatKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCapNhatKhachActionPerformed
        this.setActive_CapNhatPhong(false);
        ;
        khachHangGUI = new QuanLiKhachHang();
        RenderLayout(khachHangGUI.getContent_KH());
    }//GEN-LAST:event_jmiCapNhatKhachActionPerformed

    private void jmiTimKiemKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTimKiemKhachActionPerformed
        this.setActive_CapNhatPhong(false);
        ;
        timKiemKhachHangGUI = new TimKiemKhachHang();
        RenderLayout(timKiemKhachHangGUI.getPnTimKiemKhachHang());
    }//GEN-LAST:event_jmiTimKiemKhachActionPerformed

    private void jmiTimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTimKiemPhongActionPerformed
        this.setActive_CapNhatPhong(false);
        ;
       timKiemPhongGUI = new TimKiemPhongHat();
        RenderLayout(timKiemPhongGUI.getPnPhong());
    }//GEN-LAST:event_jmiTimKiemPhongActionPerformed

    private void jmiHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiHoaDonMouseClicked

        QuanLiHoaDon QLHoaDon = new QuanLiHoaDon();

        RenderLayout(QLHoaDon.getPnTraPhong());

    }//GEN-LAST:event_jmiHoaDonMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setActive_CapNhatPhong(false);
        trogiupGUI = new TroGiup();
        RenderLayout(trogiupGUI.getPnHelp());// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked
    private void enableActionMovedPhong() {
        datPhongGUI = new DatPhong();
        RenderLayout(datPhongGUI.getContent_DP());

    }

    private void disableActionMovedPhong() {

    }

    private void enableActionMovedTraPhong() {
        RenderLayout(new TraPhong().getPnTraPhong());
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuDatPhong;
    private javax.swing.JMenu MenuKH;
    private javax.swing.JMenu MenuOrder;
    private javax.swing.JMenu MenuTrangChu;
    private javax.swing.JPanel Panel_Content;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmiCapNhatKhach;
    private javax.swing.JMenuItem jmiDatPhong;
    private javax.swing.JMenu jmiHoaDon;
    private javax.swing.JMenuItem jmiOrder;
    private javax.swing.JMenuItem jmiTimKiemDV;
    private javax.swing.JMenuItem jmiTimKiemKhach;
    private javax.swing.JMenuItem jmiTimKiemPhong;
    private javax.swing.JMenuItem jmiTraPhong;
    // End of variables declaration//GEN-END:variables

    public void RenderLayout(JPanel GUI) {

        Panel_Content.setLayout(new BorderLayout());
        Panel_Content.removeAll();

        Panel_Content.add(GUI, BorderLayout.CENTER);
        Panel_Content.setVisible(false);

        Panel_Content.setVisible(true);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Global_Layout_NhanVien("nvNgocNhu").setVisible(true);
            }
        });
    }

}
