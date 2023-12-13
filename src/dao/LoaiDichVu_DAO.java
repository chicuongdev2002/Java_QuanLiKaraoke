/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
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
public class LoaiDichVu_DAO {

    private Connection con;

    public LoaiDichVu_DAO() {
        con = Connect.getInstance().getConnection();
    }
//Lấy toàn bộ danh sách loại dịch vụ

    public ArrayList<LoaiDichVu> getAllLoaiDichVu() {
        String sql = "SELECT * FROM dbo.LoaiDichVu";
        ArrayList<LoaiDichVu> dsloai = new ArrayList<LoaiDichVu>();
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDichVu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LoaiDichVu dv = new LoaiDichVu(rs.getInt("MaLoaiDV"), rs.getString("TenLoaiDV"));

                dsloai.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsloai;
    }
    ///Thêm loại dịch vụ

    public boolean ThemLoaiDichVu(LoaiDichVu dv) {
        PreparedStatement s = null;
        int n = 0;
        try {
            String sql = "insert into dbo.LoaiDichVu ( TenLoaiDV )"
                    + " values ( ? )";
            s = con.prepareStatement(sql);
            s.setString(1, dv.getTenLoaiDichVu());
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
    public boolean CapNhatDichVu(LoaiDichVu dv) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.LoaiDichVu "
                    + "set TenLoaiDV = ? " + " where MaLoaiDV = ?";
            s = con.prepareStatement(sql);
            s.setString(1, dv.getTenLoaiDichVu());
            s.setInt(2, dv.getMaLoaiDichVu());
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

    public boolean XoaDichVu(LoaiDichVu dv) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.LoaiDichVu " + "where MaLoaiDV = ?";
            s = con.prepareStatement(sql);
            s.setInt(1, dv.getMaLoaiDichVu());
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
//Lấy tên loại từ mã loại dịch vụ

    public LoaiDichVu getTenLoaiDichVu(int maLoai) {
        LoaiDichVu ldv = new LoaiDichVu();
        String sql = "select * from LoaiDichVu where MaLoaiDV='" + maLoai + "'";
        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                int ma = rs.getInt(1);
                String tenLoai = rs.getString(2);
                ldv = new LoaiDichVu(ma, tenLoai);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ldv;
    }

    //Lấy mã loại bởi tên loại dịch vụ
    public int getMaByTenLoaiDichVu(String tenLoai) {
        String sql = "select MaLoaiDV from LoaiDichVu where TenLoaiDV= ?";
        PreparedStatement s = null;
        int ma = 0;
        try {
            s = con.prepareStatement(sql);
            s.setString(1, tenLoai);

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

    //Lấy tên dịch vụ bởi tên đơn vị
    public String getTenDichVuByTenDonVi(String tenDonVi) {
        String sql = "SELECT    DonViDichVu.TenDonVi, LoaiDichVu.TenLoaiDV\n"
                + "FROM         DichVu INNER JOIN\n"
                + "                      DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi INNER JOIN\n"
                + "                      LoaiDichVu ON DonViDichVu.MaLoaiDV = LoaiDichVu.MaLoaiDV where TenDonVi like ?";
        PreparedStatement s = null;

        try {
            s = con.prepareStatement(sql);
            s.setString(1, tenDonVi);

            ResultSet r = s.executeQuery();
            r.next();
            return r.getString(2);
        } catch (SQLException e) {
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
