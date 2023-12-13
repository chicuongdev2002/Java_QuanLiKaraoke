/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.ChucVu;
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
public class ChucVu_DAO {

    private Connection con;

    public ChucVu_DAO() {
        con = Connect.getInstance().getConnection();
    }

    //Lấy tên Chức vụ bởi mã chức vụ
    public String getTenChucVuByMaChucVu(int maChucVu) {
        String sql = "select TenChucVu from ChucVu where MaChucVu= ?";
        PreparedStatement s = null;
        String ten = "";
        try {
            s = con.prepareStatement(sql);
            s.setInt(1, maChucVu);

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

    public int getMaChucVuByTenChucVu(String tenChucVu) {
        String sql = "select MaChucVu from ChucVu where TenChucVu= ?";
        PreparedStatement s = null;
        int ma = 0;
        try {
            s = con.prepareStatement(sql);
            s.setString(1, tenChucVu);

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

    public ArrayList<ChucVu> getAllChucVu() {
        String sql = "SELECT * FROM dbo.ChucVu";
        ArrayList<ChucVu> dscv = new ArrayList<ChucVu>();
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ChucVu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getInt(1), rs.getString(2));

                dscv.add(cv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dscv;
    }
    ///Thêm chức vụ

    public boolean ThemChucVu(ChucVu cv) {
        PreparedStatement s = null;
        int n = 0;
        try {
            String sql = "insert into dbo.ChucVu ( TenChucVu )"
                    + " values ( ? )";
            s = con.prepareStatement(sql);
            s.setString(1, cv.getTenChucVu());
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

    //Cập nhật chức vụ
    public boolean CapNhatChucVu(ChucVu cv) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.ChucVu "
                    + "set TenChucVu = ? " + " where MaChucVu = ?";
            s = con.prepareStatement(sql);
            s.setString(1, cv.getTenChucVu());
            s.setInt(2, cv.getMaChucVu());
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
//Xóa chức vụ

    public boolean XoaChucVu(ChucVu cv) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.ChucVu " + "where MaChucVu = ?";
            s = con.prepareStatement(sql);
            s.setInt(1, cv.getMaChucVu());
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
