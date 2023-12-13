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
import entity.KhachHang;
import java.sql.SQLException;

public class KhachHang_DAO {

    private Connection con;

    public KhachHang_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<KhachHang> GetAllKhachHang() {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "select * from KhachHang";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                dsKH.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public KhachHang getKhachHangTheoSDT(String SDT) {

        KhachHang kh;
        try {
            String sql = "select * from  KhachHang where  SDT=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, SDT);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                return kh;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public KhachHang getKhachHangTheoMaKH(int maKH) {

        KhachHang kh;
        try {
            String sql = "select * from  KhachHang where  MaKhachHang=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maKH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                return kh;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

//        
    public boolean themKhachHang(KhachHang kh) {

        try {
            String sql = "insert into KhachHang (TenKhachHang,CMND,NgaySinh,SDT) values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, kh.getTenKH());
            stm.setString(2, kh.getCMND());
            stm.setDate(3, kh.getNgaySinh());
            stm.setString(4, kh.getSDT());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    //Cập nhật khách hàng

    public boolean CapNhatKhachHang(KhachHang kh) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.KhachHang "
                    + "set TenKhachHang = ?, CMND = ?, NgaySinh = ?, SDT = ? " + " where MaKhachHang = ?";
            s = con.prepareStatement(sql);
            s.setString(1, kh.getTenKH());
            s.setString(2, kh.getCMND());
            s.setDate(3, (java.sql.Date) kh.getNgaySinh());
            s.setString(4, kh.getSDT());
            s.setInt(5, kh.getMaKH());
            try {
                n = s.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
public ArrayList<KhachHang> getListKhachHangByName(String tenKH) {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.KhachHang kh where kh.TenKhachHang like ?";
            s = con.prepareStatement(sql);
            s.setString(1, "%" + tenKH + "%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                dskh.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dskh;
    }
}
