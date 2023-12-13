/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Date;
import connect.Connect;
import entity.HoaDonPhong;
import entity.KhachHang;
import entity.Phong;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

//
public class HoaDonThanhToan_DAO {

    private Connection con;

    public HoaDonThanhToan_DAO() {

        con = Connect.getInstance().getConnection();
    }

    private String demGio(String gioden, String giodi) {
        String dateStart = gioden;
        String dateStop = giodi;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
//	long diffDays = diff / (24 * 60 * 60 * 1000);

            return diffHours + "h" + "\t" + diffMinutes + "p";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "lỗi đếm giờ: " + e.toString());
            return "1";
        }
    }

    public entity.HoaDonThanhToan GetHoaDonThanhToan(int maPhieuDat) {

        try {
            String sql = "SELECT        HoaDonPhong.MaHDP, KhachHang.MaKhachHang, KhachHang.TenKhachHang, KhachHang.CMND, Phong.MaPhong, PhieuDatPhong.NgayLapPhieu, ChiTietHoaDonPhong.GioVao,PhieuDatPhong.MaPhieuDat\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         Phong ON ChiTietHoaDonPhong.MaPhong = Phong.MaPhong INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat AND Phong.MaPhong = PhieuDatPhong.MaPhong INNER JOIN\n"
                    + "                         KhachHang ON PhieuDatPhong.MaKhachHang = KhachHang.MaKhachHang where PhieuDatPhong.MaPhieuDat=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maPhieuDat);

            ResultSet rs = stm.executeQuery();

            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

            while (rs.next()) {
                String gioVao = rs.getString(7);

                String gioRa = formatter.format(new java.util.Date());

                String thoiGian = demGio(gioVao, gioRa);
                return new entity.HoaDonThanhToan(new HoaDonPhong(rs.getInt(1)), new KhachHang(rs.getInt(2), rs.getString(3), rs.getString(4)), new Phong(rs.getString(5)), rs.getDate(6), gioVao, gioRa, thoiGian);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public entity.HoaDonThanhToan GetHoaDonThanhToanXemLai(int maPhieuDat) {

        try {
            String sql = "SELECT        HoaDonPhong.MaHDP, KhachHang.MaKhachHang, KhachHang.TenKhachHang, KhachHang.CMND, Phong.MaPhong, PhieuDatPhong.NgayLapPhieu, ChiTietHoaDonPhong.GioVao,PhieuDatPhong.MaPhieuDat,ChiTietHoaDonPhong.GioRa\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         Phong ON ChiTietHoaDonPhong.MaPhong = Phong.MaPhong INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat AND Phong.MaPhong = PhieuDatPhong.MaPhong INNER JOIN\n"
                    + "                         KhachHang ON PhieuDatPhong.MaKhachHang = KhachHang.MaKhachHang where PhieuDatPhong.MaPhieuDat=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maPhieuDat);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String gioVao = rs.getString(7);

                String gioRa = rs.getString(9);

                String thoiGian = demGio(gioVao, gioRa);
                return new entity.HoaDonThanhToan(new HoaDonPhong(rs.getInt(1)), new KhachHang(rs.getInt(2), rs.getString(3), rs.getString(4)), new Phong(rs.getString(5)), rs.getDate(6), gioVao, gioRa, thoiGian);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
