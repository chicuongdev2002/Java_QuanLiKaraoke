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
import entity.TaiKhoan;
import entity.NhanVien;

public class TaiKhoan_DAO {

    private Connection con;

    public TaiKhoan_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<TaiKhoan> GetAllTaiKhoan() {
        ArrayList<TaiKhoan> dstk = new ArrayList<>();
        try {
            String sql = "select * from TaiKhoan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                dstk.add(new TaiKhoan(rs.getInt(5), rs.getString(1), rs.getString(2), new NhanVien(rs.getInt(3)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstk;
    }

    public boolean capNhatTrangThaiDangNhap(String tenDangNhap, int trangThai) {

        try {
            String sql = "update TaiKhoan set TrangThai=" + trangThai + "where  TenDangNhap=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, tenDangNhap);

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
