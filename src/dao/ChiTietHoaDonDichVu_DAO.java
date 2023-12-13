/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.ChiTietHoaDonDichVu;

public class ChiTietHoaDonDichVu_DAO {

    private Connection con;

    public ChiTietHoaDonDichVu_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public boolean themChiTietHoaDonDichVu(ChiTietHoaDonDichVu chiTietHDDV) {

        try {
            String sql = "insert into ChiTietHoaDonDichVu (MaHDDV,MaDV,SoLuong) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, chiTietHDDV.getHDDV().getMaHDDV());
            stm.setInt(2, chiTietHDDV.getDV().getMaDichVu());
            stm.setInt(3, chiTietHDDV.getSoLuong());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean xoaDichVuOrder(int maHDDV, int maDV) {

        try {
            String sql = "delete ChiTietHoaDonDichVu where MaHDDV=? and MaDV=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maHDDV);
            stm.setInt(2, maDV);

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean capNhatSoLuongDichVu(int soLuong, int maDV, int MaHDDV) {

        try {
            String sql = "update ChiTietHoaDonDichVu set SoLuong=? where MaDV= ? and  MaHDDV = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setInt(2, maDV);
            stm.setInt(3, MaHDDV);
            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean KiemTraDichVuTonTai(int maDV, String maPhong) {

        try {
            String sql = "select count(*)  as SL  from ChiTietHoaDonDichVu cthd join HoaDonDichVu hd on hd.MaHDDV=cthd.MaHDDV where TinhTrang=0 and MaDV =? and MaPhong=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maDV);
            stm.setString(2, maPhong);
            ResultSet rs = stm.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public int laySoLuongDichVuDatDat(int maDV, int maHDDV) {

        try {
            String sql = "select SoLuong from ChiTietHoaDonDichVu where MaDV= ? and maHDDV=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maDV);
            stm.setInt(2, maHDDV);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

}
