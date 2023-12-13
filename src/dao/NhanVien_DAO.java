/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;

import entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_DAO {

    private Connection con;

    public NhanVien_DAO() {

        con = Connect.getInstance().getConnection();
    }
//	kiểm tra acc có phải nhân viên hay không

    public boolean resetLogin() {
        try {
            String sql = "update TaiKhoan set TrangThai=0 where TrangThai=1";
            PreparedStatement stm = con.prepareStatement(sql);

            if (stm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean checkQL(int maNV) {
        try {
            String sql = "select * from NhanVien join ChucVu on ChucVu.MaChucVu=NhanVien.ChucVu  where  MaNhanVien=?  and ChucVu.TenChucVu='QL'";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maNV);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //lấy tên nhân viên đã đăng nhập
    public String getTenNhanVienDangNhap() {

        try {
            String sql = "select HoTen from TaiKhoan tk  join NhanVien nv on  tk.MaNhanVien=nv.MaNhanVien where  TrangThai=1 ";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                return rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }
    //lấy  nhân viên đăng nhập

    public NhanVien getNhanVienDangNhap() {

        try {
            String sql = "select nv.MaNhanVien from NhanVien nv join TaiKhoan  tk on tk.MaNhanVien= nv.MaNhanVien where TrangThai =1 ";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                return new NhanVien(rs.getInt(1));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;

        return null;
    }

    public ArrayList<NhanVien> getAllNV() {
        String sql = "SELECT * FROM dbo.NhanVien order by ChucVu";
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt("MaNhanVien"), rs.getString("HoTen"), rs.getString("DiaChi"),
                        rs.getDate("NgaySinh"), rs.getString("SDT"), rs.getInt("ChucVu"), rs.getBoolean("GioiTinh"));

                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public boolean ThemNhanVien(NhanVien nv) {
        PreparedStatement s = null;
        int n = 0;
        java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "insert into dbo.NhanVien ( HoTen, DiaChi,NgaySinh, SDT, ChucVu, GioiTinh)"
                    + " values ( ?, ?, ?, ?, ?, ?)";
            s = con.prepareStatement(sql);
            // s.setInt(1, nv.getMaNV());
            s.setString(1, nv.getHoTen());
            s.setString(2, nv.getDiaChi());
            s.setDate(3, date);
            s.setString(4, nv.getSDT());
            s.setInt(5, nv.getChucVu());
            s.setBoolean(6, nv.getGioiTinh());
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

    //Cập nhật nhân viên
    public boolean CapNhatNhanVien(NhanVien nv) {
        PreparedStatement s = null;
        int n = 0;
        //java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
        try {
            String sql = "update dbo.NhanVien "
                    + "set HoTen = ?, DiaChi = ?, NgaySinh = ?, SDT = ?, ChucVu = ?, GioiTinh = ? " + " where MaNhanVien = ?";
            s = con.prepareStatement(sql);
            s.setString(1, nv.getHoTen());
            s.setString(2, nv.getDiaChi());
            s.setDate(3, (java.sql.Date) nv.getNgaySinh());
            s.setString(4, nv.getSDT());
            s.setInt(5, nv.getChucVu());
            s.setBoolean(6, nv.getGioiTinh());
            s.setInt(7, nv.getMaNV());
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
    ////////////////

//Xóa nhân viên
    public boolean XoaNhanVien(NhanVien nv) {
        PreparedStatement s = null;

        int n = 0;
        try {
            String sql = "delete from dbo.NhanVien " + "where MaNhanVien = ?";
            s = con.prepareStatement(sql);
            s.setInt(1, nv.getMaNV());
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

    public ArrayList<NhanVien> getListNhanVienByName(String tenNV) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.HoTen like ?";
            s = con.prepareStatement(sql);
            s.setString(1, "%" + tenNV + "%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> getListNhanVienByDiaChi(String diaChi) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.DiaChi like ?";
            s = con.prepareStatement(sql);
            s.setString(1, "%" + diaChi + "%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> getListNhanVienBySDT(String sdt) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.SDT like ?";
            s = con.prepareStatement(sql);
            s.setString(1, "%" + sdt + "%");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> getListNhanVienByChucVu(int maChucVu) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.ChucVu= ? ";
            s = con.prepareStatement(sql);
            s.setInt(1, maChucVu);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> getListNhanVienByGioiTinh(boolean gioiTinh) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.GioiTinh= ? ";
            s = con.prepareStatement(sql);
            s.setBoolean(1, gioiTinh);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> getListNhanVienByNgaySinh(String ngaySinh) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement s = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien nv where nv.NgaySinh='" + ngaySinh + "'";
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

}
