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
import entity.ChiTietHoaDonPhong;
import java.text.SimpleDateFormat;

public class ChiTietHoaDonPhong_DAO {

    private Connection con;

    public ChiTietHoaDonPhong_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public boolean themChiTietHoaDonPhong(ChiTietHoaDonPhong chiTietHDP) {

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        try {
            String sql = "insert into ChiTietHoaDonPhong (MaHDP,MaPhong,GioVao) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, chiTietHDP.getMaHdp().getMaHDP());
            stm.setString(2, chiTietHDP.getMaPhong().getMaPhong());
            stm.setString(3, formatter.format(new java.util.Date()));

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean capNhatThoiGianVaTienPhong(String gioRa, String gioSuDung, double TongTien, int maHDP) {

        try {
            String sql = "update ChiTietHoaDonPhong set GioRa= ? ,SoGioSuDung=?,TongTien=? where MaHDP=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, gioRa);
            stm.setString(2, gioSuDung);
            stm.setDouble(3, TongTien);
            stm.setInt(4, maHDP);
            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public String getGioVao(String maPhong) {

        try {
            String sql = "					SELECT        ChiTietHoaDonPhong.GioVao\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP where HoaDonPhong.TinhTrang=0 and MaPhong=?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

}
