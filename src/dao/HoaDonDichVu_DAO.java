/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//
import entity.HoaDonDichVu;

public class HoaDonDichVu_DAO {

    private Connection con;

    public HoaDonDichVu_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public boolean themHoaDonDichVu(HoaDonDichVu hoaDonDichVu) {

        try {
            String sql = "insert into HoaDonDichVu (NgayLap,MaPhong,TinhTrang,GioVao) values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1, hoaDonDichVu.getNgayLap());
            stm.setString(2, hoaDonDichVu.getPhong().getMaPhong());
            stm.setBoolean(3, hoaDonDichVu.isTinhTrang());
            stm.setString(4, hoaDonDichVu.getGioVao());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public HoaDonDichVu layHoaDonDichVu(String maPhong) {

        try {
            String sql = "	 SELECT * FROM HoaDonDichVu WHERE MaPhong= ? and TinhTrang=0";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                return new HoaDonDichVu(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public HoaDonDichVu layHoaDonDichVuTheoThoiGian(String gioVao, String ngayLap) {

        try {
            String sql = "	 SELECT MaHDDV FROM HoaDonDichVu WHERE GioVao=? and ngayLap=?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, gioVao);
            stm.setString(2, ngayLap);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                return new HoaDonDichVu(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean xoaHoaDonDichVu(String maPhong) {

        try {
            String sql = "	 delete HoaDonDichVu WHERE MaPhong= ? and TinhTrang=0";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);

            while (stm.executeUpdate() > 0) {
                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public HoaDonDichVu layHoaDonDichVuTheoPhong(String maPhong) {

        try {
            String sql = "SELECT * FROM HoaDonDichVu WHERE MaPhong = ? and TinhTrang=0";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                return new HoaDonDichVu(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean KiemTraTrangThaiHoaDonDichVu(String maPhong) {

        boolean trangThai = false;
        try {

            String sql = "SELECT COUNT(MaPhong) as SL  FROM HoaDonDichVu where MaPhong=?  and TinhTrang=0";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            String sqlCheck = "SELECT COUNT(MaPhong) as SL\n"
                    + "  FROM HoaDonDichVu where MaPhong=?";

            PreparedStatement stmCheck = con.prepareStatement(sqlCheck);
            stmCheck.setString(1, maPhong);
            ResultSet rsCheck = stmCheck.executeQuery();

            rsCheck.next();

            if (rsCheck.getInt(1) == 0) {

                return true;

            }
            while (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangThai;

    }

    public boolean capNhatTrangThaiHoaDonDichVu(int maHD, boolean trangThai) {

        try {
            String sql = "update  HoaDonDichVu  set TinhTrang=? where MaHDDV =? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setBoolean(1, trangThai);
            stm.setInt(2, maHD);

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
