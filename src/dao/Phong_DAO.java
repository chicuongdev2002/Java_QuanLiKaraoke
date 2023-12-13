package dao;

import connect.Connect;

import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.LoaiPhong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Phong_DAO {

    private Connection con;

    public Phong_DAO() {

        con = Connect.getInstance().getConnection();
    }
//	kiểm tra acc có phải nhân viên hay không

    //lấy tên nhân viên đã đăng nhập
    public ArrayList<Phong> GetAllPhong() {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public ArrayList<Phong> GetPhongTheoViTri(String viTri) {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong  where ViTri like ?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, viTri);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public ArrayList<Phong> GetPhongTheoMaPhong(String maPhong) {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong  where MaPhong =?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public ArrayList<Phong> GetPhongTheoTrangThai(boolean trangThai) {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong  where TinhTrang=?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setBoolean(1, trangThai);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public boolean ThemPhong(Phong phong) {
        PreparedStatement s = null;
        int n = 0;

        try {
            String sql = "insert into Phong (MaPhong,SucChua,ViTri,TinhTrang,MaLoaiPhong) values (?,?,?,?,?)";
            s = con.prepareStatement(sql);

            s.setString(1, phong.getMaPhong());
            s.setInt(2, phong.getSucChua());
            s.setString(3, phong.getViTri());
            s.setBoolean(4, phong.getTinhTrang());
            s.setInt(5, phong.getLoaiPhong().getMaLoaiPhong());

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

    public boolean xoaPhong(String maPhong) {

        try {
            String sql = "delete  Phong   where MaPhong =? ";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, maPhong);

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean capNhatPhong(Phong phong) {

        try {
            String sql = "update  Phong  set SucChua=?,ViTri=? ,MaLoaiPhong=?  where MaPhong =? ";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, phong.getSucChua());
            stm.setString(2, phong.getViTri());
            stm.setInt(3, phong.getLoaiPhong().getMaLoaiPhong());
            stm.setString(4, phong.getMaPhong());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public ArrayList<Phong> getPhongTheoMa(String maPhong) {

        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong where MaPhong=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;

    }
    public ArrayList<Phong> getPhongTheoLoaiPhong(int maLoaiPhong) {

        ArrayList<Phong> dsPhong = new ArrayList<>();
        try {
            String sql = "select * from Phong where MaLoaiPhong=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maLoaiPhong);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsPhong.add(new Phong(rs.getString(1), rs.getInt(2), rs.getString(3), new LoaiPhong(rs.getInt(5)), rs.getBoolean(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;

    }

    public boolean capNhatTrangThaiPhong(String maPhong, boolean trangThai) {

        try {
            String sql = "update  Phong  set TinhTrang=? where MaPhong =? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setBoolean(1, trangThai);
            stm.setString(2, maPhong);

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public double getTienPhong(String maPhong) {

        try {
            String sql = "SELECT        LoaiPhong.DonGia, Phong.MaPhong\n"
                    + "FROM            LoaiPhong INNER JOIN\n"
                    + "                         Phong ON LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong  where MaPhong=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maPhong);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getDouble(1));
                return rs.getDouble(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public ArrayList<Phong> getMaLoaiTheoViTri(String viTri) {

        ArrayList<Phong> dsPhong = new ArrayList<>();

        try {
            String sql = "select * from Phong where MaPhong like  ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, viTri);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                dsPhong.add(new Phong(rs.getString(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPhong;

    }
     public int getMaLoaiPhongByTenLoaiPhong(String TenLoaiPhong) {
        String sql = "select MaLoaiPhong from LoaiPhong where TenLoaiPhong= ?";
        PreparedStatement s = null;
        int ma = 0;
        try {
            s = con.prepareStatement(sql);
            s.setString(1, TenLoaiPhong);

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

    

}
