/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.DichVu;
import entity.DonViDichVu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DichVu_DAO {

    private Connection con;

    public DichVu_DAO() {
        con = Connect.getInstance().getConnection();
    }
//Lấy toàn bộ danh sách loại dịch vụ

    public ArrayList<DichVu> getAllDichVu() {
        String sql = "SELECT * FROM dbo.DichVu";
        ArrayList<DichVu> dsloai = new ArrayList<DichVu>();
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DichVu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DichVu dv = new DichVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), new DonViDichVu(rs.getInt(5)));

                dsloai.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsloai;
    }

    public ArrayList<DichVu> getTenDichVuByLoaiDichVu(String loaiDichVu) {

        ArrayList<DichVu> dsDv = new ArrayList<>();
        try {
            String sql = "SELECT        DichVu.TenDichVu, LoaiDichVu.TenLoaiDV\n"
                    + "FROM            DichVu INNER JOIN\n"
                    + "                         DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi INNER JOIN\n"
                    + "                         LoaiDichVu ON DonViDichVu.MaLoaiDV = LoaiDichVu.MaLoaiDV  where TenLoaiDV= ?  order by DichVu.TenDichVu ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, loaiDichVu);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                dsDv.add(new DichVu(rs.getString(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDv;

    }

    public boolean ThemDichVu(DichVu dv, int maDonVi) {
        PreparedStatement s = null;
        int n = 0;
        try {
            String sql = "insert into dbo.DichVu (TenDichVu,SoLuongTon,DonGia,MaDonVi)"
                    + " values ( ?, ?, ?, ?)";
            s = con.prepareStatement(sql);
            s.setString(1, dv.getTenDichVu());
            s.setInt(2, dv.getSoLuongTon());
            s.setDouble(3, dv.getDonGia());
            s.setInt(4, maDonVi);
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

    //Cập nhật  dịch vụ
    public boolean CapNhatDichVu(DichVu dv, int maDonVi) {
        PreparedStatement s = null;
        int n = 0;

        try {
            String sql = "update dbo.DichVu "
                    + "set TenDichVu = ?,SoLuongTon= ?,DonGia= ?,MaDonVi= ? " + " where MaDichVu = ?";
            s = con.prepareStatement(sql);
            s.setString(1, dv.getTenDichVu());
            s.setInt(2, dv.getSoLuongTon());
            s.setDouble(3, dv.getDonGia());
            s.setInt(4, maDonVi);
            s.setInt(5, dv.getMaDichVu());
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
//Lấy ra danh sách dịch vụ bởi tên dịch vụ

    public ArrayList<DichVu> getListDichVuByName(String tenDichVu) {
        ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.DichVu dv where dv.TenDichVu like ?";
            s = con.prepareStatement(sql);
            s.setString(1, "%" + tenDichVu + "%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), new DonViDichVu(rs.getInt(5)));
                dsdv.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsdv;
    }

    public ArrayList<DichVu> getListDichVuByMaDonVi(int maDonVi) {
        ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.DichVu dv where dv.MaDonVi= ? ";
            s = con.prepareStatement(sql);
            s.setInt(1, maDonVi);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), new DonViDichVu(rs.getInt(5)));
                dsdv.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsdv;
    }

    public ArrayList<DichVu> getListDichVuBySoLuongTon() {
        ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.DichVu dv where dv.SoLuongTon <5";
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), new DonViDichVu(rs.getInt(5)));
                dsdv.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsdv;
    }

    public DichVu getDichVuByTenVaDonVi(String tenDichVu, String tenDonVi) {

        try {
            String sql = "SELECT        DichVu.MaDichVu, DichVu.TenDichVu, DonViDichVu.TenDonVi,DichVu.SoLuongTon\n"
                    + "FROM            DichVu INNER JOIN\n"
                    + "                         DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi where DichVu.TenDichVu=? and DonViDichVu.TenDonVi=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, tenDichVu);
            stm.setString(2, tenDonVi);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                return new DichVu(rs.getInt(1), rs.getInt(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean capNhatSoLuongDichVu(int soLuongTon, String tenDichVu, int maDonVi) {

        try {
            String sql = "update DichVu set SoLuongTon=? where TenDichVu =? and MaDonVi =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(2, tenDichVu);
            stm.setInt(3, maDonVi);
            stm.setInt(1, soLuongTon);

            while (stm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean XoaDichVu(DichVu dv) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.DichVu " + "where MaDichVu = ?";
            s = con.prepareStatement(sql);
            s.setInt(1,dv.getMaDichVu());
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
