/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//
import entity.PhieuTraPhong;

public class PhieuTraPhong_DAO {

    private Connection con;

    public PhieuTraPhong_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<PhieuTraPhong> GetAllPhieuTraPhong(int trangThai) {

        ArrayList<PhieuTraPhong> dsPhieuTra = new ArrayList<>();
        try {
            String sql = "SELECT        KhachHang.TenKhachHang, KhachHang.SDT, KhachHang.CMND, PhieuDatPhong.MaPhieuDat, Phong.MaPhong, PhieuDatPhong.NgayLapPhieu, ChiTietHoaDonPhong.GioVao\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat INNER JOIN\n"
                    + "                         KhachHang ON PhieuDatPhong.MaKhachHang = KhachHang.MaKhachHang INNER JOIN\n"
                    + "                         Phong ON ChiTietHoaDonPhong.MaPhong = Phong.MaPhong AND PhieuDatPhong.MaPhong = Phong.MaPhong where HoaDonPhong.TinhTrang =" + trangThai + "order by  PhieuDatPhong.NgayLapPhieu asc";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                dsPhieuTra.add(new PhieuTraPhong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhieuTra;
    }

    public ArrayList<PhieuTraPhong> GetPhieuTraPhongTheoPhong(String maPhong, int TrangThai) {
        ArrayList<PhieuTraPhong> dsPhieuTra = new ArrayList<>();
        try {
            String sql = "SELECT        KhachHang.TenKhachHang, KhachHang.SDT, KhachHang.CMND, PhieuDatPhong.MaPhieuDat, Phong.MaPhong, PhieuDatPhong.NgayLapPhieu, ChiTietHoaDonPhong.GioVao\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat INNER JOIN\n"
                    + "                         KhachHang ON PhieuDatPhong.MaKhachHang = KhachHang.MaKhachHang INNER JOIN\n"
                    + "                         Phong ON ChiTietHoaDonPhong.MaPhong = Phong.MaPhong AND PhieuDatPhong.MaPhong = Phong.MaPhong where Phong.MaPhong=? and HoaDonPhong.TinhTrang = " + TrangThai;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhieuTra.add(new PhieuTraPhong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhieuTra;
    }

    public ArrayList<PhieuTraPhong> GetPhieuTraPhongTheoSDT(String SDT, int trangThai) {
        ArrayList<PhieuTraPhong> dsPhieuTra = new ArrayList<>();
        try {
            String sql = "SELECT        KhachHang.TenKhachHang, KhachHang.SDT, KhachHang.CMND, PhieuDatPhong.MaPhieuDat, Phong.MaPhong, PhieuDatPhong.NgayLapPhieu, ChiTietHoaDonPhong.GioVao\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat INNER JOIN\n"
                    + "                         KhachHang ON PhieuDatPhong.MaKhachHang = KhachHang.MaKhachHang INNER JOIN\n"
                    + "                         Phong ON ChiTietHoaDonPhong.MaPhong = Phong.MaPhong AND PhieuDatPhong.MaPhong = Phong.MaPhong where   KhachHang.SDT=? and HoaDonPhong.TinhTrang =" + "" + trangThai;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, SDT);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhieuTra.add(new PhieuTraPhong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhieuTra;
    }

}
