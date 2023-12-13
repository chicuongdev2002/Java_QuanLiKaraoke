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

//
import entity.HoaDonPhong;

public class HoaDonPhong_DAO {

    private Connection con;

    public HoaDonPhong_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public boolean themHoaDonPhong(HoaDonPhong hoaDonPhong) {

        try {
            String sql = "insert into HoaDonPhong (MaNV,MaPhieuDat,TinhTrang) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, hoaDonPhong.getMaNV().getMaNV());
            stm.setInt(2, hoaDonPhong.getMaPD().getMaPhieu());
            stm.setBoolean(3, hoaDonPhong.isTinhTrang());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public HoaDonPhong layHoaDonPhong() {

        try {
            String sql = "SELECT * FROM HoaDonPhong WHERE MaHDP = (SELECT MAX(MaHDP) FROM HoaDonPhong)";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                return new HoaDonPhong(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean capNhatTrangThaiHoaDonPhong(int maHD, boolean trangThai) {

        try {
            String sql = "update  HoaDonPhong  set TinhTrang=? where MaHDP =? ";
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
