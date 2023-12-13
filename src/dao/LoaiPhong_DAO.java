/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.LoaiPhong;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class LoaiPhong_DAO {

    private Connection con;

    public LoaiPhong_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<LoaiPhong> getAllLoaiPhong() {

        ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<>();
        try {
            String sql = "select * from LoaiPhong";
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsLoaiPhong.add(new LoaiPhong(rs.getInt(1), rs.getString(2), rs.getDouble(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiPhong;

    }

    public ArrayList<LoaiPhong> getLoaiPhongTheoMa(int maLoaiPhong) {

        ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<>();
        try {
            String sql = "select * from LoaiPhong where MaLoaiPhong=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maLoaiPhong);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsLoaiPhong.add(new LoaiPhong(rs.getInt(1), rs.getString(2), rs.getDouble(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiPhong;

    }

    public String getTenLoaiPhongTheoMa(int maLoaiPhong) {

        try {
            String sql = "select  TenLoaiPhong from LoaiPhong where MaLoaiPhong= ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maLoaiPhong);

            ResultSet rs = stm.executeQuery();

            rs.next();

            return rs.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public int getMaLoaiTheoTen(String tenLoaiPhong) {

        try {
            String sql = "select  MaLoaiPhong from LoaiPhong where TenLoaiPhong= ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, tenLoaiPhong);

            ResultSet rs = stm.executeQuery();

            rs.next();

            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    public boolean ThemLoaiPhong(LoaiPhong lp) {
        PreparedStatement s = null;
        int n = 0;
        try {
            String sql = "insert into dbo.LoaiPhong ( TenLoaiPhong,DonGia )"
                    + " values ( ?, ? )";
            s = con.prepareStatement(sql);
            s.setString(1, lp.getTenLoaiPhong());
            s.setDouble(2, lp.getDonGia());
            try {
                n = s.executeUpdate();
            } catch (SQLException e) {
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

    //Cập nhật loại dịch vụ
    public boolean CapNhatLoaiPhong(LoaiPhong lp) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.LoaiPhong "
                    + "set TenLoaiPhong = ?, DonGia = ? " + " where MaLoaiPhong = ?";
            s = con.prepareStatement(sql);
            s.setString(1, lp.getTenLoaiPhong());
            s.setDouble(2, lp.getDonGia());
            s.setInt(3, lp.getMaLoaiPhong());
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
//Xóa loại phòng

    public boolean XoaLoaiPhong(LoaiPhong lp) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.LoaiPhong " + "where MaLoaiPhong = ? ";
            s = con.prepareStatement(sql);
            s.setInt(1, lp.getMaLoaiPhong());
            n = s.executeUpdate();
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
}
