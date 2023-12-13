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
import entity.PhieuDatPhong;

public class PhieuDatPhong_DAO {

    private Connection con;

    public PhieuDatPhong_DAO() {

        con = Connect.getInstance().getConnection();
    }

//        
    public boolean themPhieuDatPhong(PhieuDatPhong phieuDat) {

        try {
            String sql = "insert into PhieuDatPhong (MaKhachHang,MaPhong,NgayLapPhieu) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, phieuDat.getMaKH().getMaKH());
            stm.setString(2, phieuDat.getMaPhong().getMaPhong());
            stm.setDate(3, phieuDat.getNgayLap());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public PhieuDatPhong layPhieuDat() {

        try {
            String sql = "SELECT * FROM PhieuDatPhong WHERE MaPhieuDat = (SELECT MAX(MaPhieuDat) FROM PhieuDatPhong)";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                return new PhieuDatPhong(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
