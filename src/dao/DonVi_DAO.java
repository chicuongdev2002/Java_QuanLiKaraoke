/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.DonViDichVu;
import entity.LoaiDichVu;
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
public class DonVi_DAO {

    private Connection con;

    public DonVi_DAO() {
        con = Connect.getInstance().getConnection();
    }
//Lấy toàn bộ danh sách đơn vị dịch vụ

    public ArrayList<DonViDichVu> getAllDonVi() {
        String sql = "SELECT * FROM dbo.DonViDichVu";
        ArrayList<DonViDichVu> dsloai = new ArrayList<DonViDichVu>();
        LoaiDichVu_DAO ldv_dao = new LoaiDichVu_DAO();
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DonVi_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int maDonVi = rs.getInt("MaDonVi");
                String tenDonVi = rs.getString("TenDonVi");
                int maLoaiDV = rs.getInt("MaLoaiDV");
                LoaiDichVu loaiDV = ldv_dao.getTenLoaiDichVu(maLoaiDV);
                DonViDichVu dvdv = new DonViDichVu(maDonVi, tenDonVi, loaiDV);

                dsloai.add(dvdv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsloai;
    }
    ///Thêm đơn vị dịch vụ

    public boolean ThemDonVi(String tenDonVi, int maLoai) {

        try {
            String sql = "insert into dbo.DonViDichVu ( TenDonVi, MaLoaiDV )"
                    + " values ( ? , ? )";
            PreparedStatement s = con.prepareStatement(sql);

            s = con.prepareStatement(sql);
            s.setString(1, tenDonVi);
            s.setInt(2, maLoai);

            if (s.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public String getTenDonViByMaDonVi(int maDonVi) {
        String sql = "select TenDonVi from DonViDichVu where MaDonVi= ?";
        PreparedStatement s = null;
        String ten = "";
        try {
            s = con.prepareStatement(sql);
            s.setInt(1, maDonVi);

            ResultSet r = s.executeQuery();
            r.next();
            ten = r.getString(1);
        } catch (SQLException e) {
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ten;
    }

    public int getMaDonViByTenDonVi(String tenDonVi) {
        String sql = "select MaDonVi from DonViDichVu where TenDonVi= ?";
        PreparedStatement s = null;
        int ma = 0;
        try {
            s = con.prepareStatement(sql);
            s.setString(1, tenDonVi);

            ResultSet r = s.executeQuery();
            r.next();
            ma = r.getInt(1);
        } catch (SQLException e) {
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ma;
    }
//

    public ArrayList<DonViDichVu> getTenDonViByMaLoai(int maLoai) {
        String sql = "select TenDonVi from DonViDichVu where MaLoaiDV= ?";
        PreparedStatement s = null;
        ArrayList<DonViDichVu> dsdv = new ArrayList<DonViDichVu>();
        try {
            s = con.prepareStatement(sql);
            s.setInt(1, maLoai);

            ResultSet r = s.executeQuery();
            while (r.next()) {
                dsdv.add(new DonViDichVu(r.getString(1)));
            }

        } catch (SQLException e) {
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dsdv;

    }

    public ArrayList<DonViDichVu> getTenDonViByTenDichVu(String tenDichVu) {
        String sql = "SELECT        DichVu.TenDichVu, DonViDichVu.TenDonVi\n"
                + "FROM            DichVu INNER JOIN\n"
                + "                         DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi where TenDichVu=?";
        PreparedStatement s = null;
        ArrayList<DonViDichVu> dsdv = new ArrayList<DonViDichVu>();
        try {
            s = con.prepareStatement(sql);
            s.setString(1, tenDichVu);

            ResultSet r = s.executeQuery();
            while (r.next()) {
                dsdv.add(new DonViDichVu(r.getString(2)));
            }

        } catch (SQLException e) {
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dsdv;

    }

    //Cập nhật loại dịch vụ
    public boolean CapNhatDonViDichVu(int maDV, String tenDV, int maLoai) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.DonViDichVu "
                    + "set TenDonVi = ?, MaLoaiDV = ? " + " where MaDonVi = ?";
            s = con.prepareStatement(sql);
            s.setString(1, tenDV);
            s.setInt(2, maLoai);
            s.setInt(3, maDV);
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
//Xóa dịch vụ

    public boolean XoaDonVi(int maDonVi) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.DonViDichVu " + "where MaDonVi = ?";
            s = con.prepareStatement(sql);
            s.setInt(1, maDonVi);
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
