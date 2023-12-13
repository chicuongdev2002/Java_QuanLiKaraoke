package gui;

import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import entity.Phong;
import entity.LoaiPhong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DatPhong extends javax.swing.JFrame {

    private JButton[] arrayDanhSachPhong = new JButton[30];
    private Phong_DAO phong_dao = new Phong_DAO();
    private LoaiPhong_DAO loaiPhong_dao = new LoaiPhong_DAO();

    public DatPhong() {
        initComponents();
        customeGiaoDienDatPhong();
    }

    public void customeGiaoDienDatPhong() {

        GridLayout layoutDanhSachPhong = new GridLayout(4, 4);
        layoutDanhSachPhong.setHgap(40);
        layoutDanhSachPhong.setVgap(25);

        pnDanhSachPhong.setLayout(layoutDanhSachPhong);

        renderDanhSachPhong();

    }

    private void renderDanhSachPhong() {

        ArrayList<Phong> danhSachPhong = phong_dao.GetAllPhong();

        int i = 0;

        while (i < danhSachPhong.size()) {
            boolean kiemTraCoNgươiThue = danhSachPhong.get(i).getTinhTrang();
            String maPhong = danhSachPhong.get(i).getMaPhong();
            LoaiPhong loaiPhong = loaiPhong_dao.getLoaiPhongTheoMa(danhSachPhong.get(i).getLoaiPhong().getMaLoaiPhong()).get(0);
            arrayDanhSachPhong[i] = new JButton();
            arrayDanhSachPhong[i].setPreferredSize(new Dimension(300, 100));
            if (!danhSachPhong.get(i).getTinhTrang()) {

                arrayDanhSachPhong[i].setBackground(new java.awt.Color(0, 153, 0));
                arrayDanhSachPhong[i].setForeground(new java.awt.Color(240, 240, 240));

            } else {

                arrayDanhSachPhong[i].setBackground(new java.awt.Color(255, 0, 0));
                arrayDanhSachPhong[i].setForeground(new java.awt.Color(63, 6, 150));

            }

            arrayDanhSachPhong[i].setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

            arrayDanhSachPhong[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/Microphone-icon-64.png"))); // NOI18N
            arrayDanhSachPhong[i].setText(danhSachPhong.get(i).getMaPhong() + "(" + loaiPhong.getTenLoaiPhong() + ")");

            arrayDanhSachPhong[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (kiemTraCoNgươiThue) {

                        JOptionPane.showMessageDialog(Content_DP, "Phong da co  khach");
                    } else {

                        new Dialog_ThongTinPhongDat(maPhong).setVisible(true);

                    }

                }
            });

            pnDanhSachPhong.add(arrayDanhSachPhong[i]);
            i++;

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content_DP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnDanhSachPhong = new javax.swing.JPanel();
        pnChuThich = new javax.swing.JPanel();
        lblTrong = new javax.swing.JLabel();
        lblCoKhach = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Đặt Phòng");

        pnDanhSachPhong.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phòng hiện có"));

        javax.swing.GroupLayout pnDanhSachPhongLayout = new javax.swing.GroupLayout(pnDanhSachPhong);
        pnDanhSachPhong.setLayout(pnDanhSachPhongLayout);
        pnDanhSachPhongLayout.setHorizontalGroup(
            pnDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1188, Short.MAX_VALUE)
        );
        pnDanhSachPhongLayout.setVerticalGroup(
            pnDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        pnChuThich.setBorder(javax.swing.BorderFactory.createTitledBorder("Chú Thích"));

        lblTrong.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTrong.setText("có khách");

        lblCoKhach.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCoKhach.setText("Trống");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/red-home-icon.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons_global/green-home-icon.png"))); // NOI18N

        javax.swing.GroupLayout pnChuThichLayout = new javax.swing.GroupLayout(pnChuThich);
        pnChuThich.setLayout(pnChuThichLayout);
        pnChuThichLayout.setHorizontalGroup(
            pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChuThichLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblTrong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoKhach)
                    .addComponent(jLabel3))
                .addGap(72, 72, 72))
        );
        pnChuThichLayout.setVerticalGroup(
            pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChuThichLayout.createSequentialGroup()
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoKhach)
                    .addComponent(lblTrong))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout Content_DPLayout = new javax.swing.GroupLayout(Content_DP);
        Content_DP.setLayout(Content_DPLayout);
        Content_DPLayout.setHorizontalGroup(
            Content_DPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_DPLayout.createSequentialGroup()
                .addGroup(Content_DPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Content_DPLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(pnDanhSachPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Content_DPLayout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(pnChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Content_DPLayout.createSequentialGroup()
                        .addGap(503, 503, 503)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        Content_DPLayout.setVerticalGroup(
            Content_DPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Content_DPLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDanhSachPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Content_DP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Content_DP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatPhong().setVisible(true);
            }
        });
    }

    public JPanel getContent_DP() {
        return Content_DP;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content_DP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCoKhach;
    private javax.swing.JLabel lblTrong;
    private javax.swing.JPanel pnChuThich;
    private javax.swing.JPanel pnDanhSachPhong;
    // End of variables declaration//GEN-END:variables
}
