package dao;

import connect.Connect;
import entity.KhachHang;
import entity.ThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ThongKe_DAO {

    private Connection con;

    public ThongKe_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<ThongKe> thongKeNgay(String ngay) {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT    PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien\n"
                    + "FROM         HoaDonPhong INNER JOIN\n"
                    + "                      ChiTietHoaDonPhong ON HoaDonPhong.MaHDP = ChiTietHoaDonPhong.MaHDP INNER JOIN\n"
                    + "                      PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat CROSS JOIN\n"
                    + "                      ChiTietHoaDonDichVu INNER JOIN\n"
                    + "                      HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV where NgayLapPhieu='" + ngay + "'\n"
                    + "GROUP BY PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<ThongKe> thongKeNgayThang(String thang, String ngay) {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT      ChiTietHoaDonPhong.MaPhong,PhieuDatPhong.NgayLapPhieu,  sum(ChiTietHoaDonPhong.TongTien) as tong\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat where MONTH(PhieuDatPhong.NgayLapPhieu) =" + thang + " and DAY(PhieuDatPhong.NgayLapPhieu)=" + ngay + " and YEAR(PhieuDatPhong.NgayLapPhieu)= YEAR(GETDATE())  group by ChiTietHoaDonPhong.MaPhong,  PhieuDatPhong.NgayLapPhieu";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getString(1), rs.getFloat(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<ThongKe> thongKeThangNam(String nam, String thang) {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT    PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien\n"
                    + "FROM         HoaDonPhong INNER JOIN\n"
                    + "                      ChiTietHoaDonPhong ON HoaDonPhong.MaHDP = ChiTietHoaDonPhong.MaHDP INNER JOIN\n"
                    + "                      PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat CROSS JOIN\n"
                    + "                      ChiTietHoaDonDichVu INNER JOIN\n"
                    + "                      HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV where YEAR(NgayLapPhieu)=" + nam + " and MONTH(NgayLapPhieu)= " + thang
                    + "GROUP BY PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getString(1), rs.getFloat(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<ThongKe> thongKeNam(String nam) {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT    PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien\n"
                    + "FROM         HoaDonPhong INNER JOIN\n"
                    + "                      ChiTietHoaDonPhong ON HoaDonPhong.MaHDP = ChiTietHoaDonPhong.MaHDP INNER JOIN\n"
                    + "                      PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat CROSS JOIN\n"
                    + "                      ChiTietHoaDonDichVu INNER JOIN\n"
                    + "                      HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV where YEAR(NgayLapPhieu)=" + nam
                    + "GROUP BY PhieuDatPhong.MaPhieuDat, PhieuDatPhong.NgayLapPhieu, PhieuDatPhong.MaPhong, ChiTietHoaDonPhong.GioVao, ChiTietHoaDonPhong.GioRa, ChiTietHoaDonPhong.SoGioSuDung, \n"
                    + "                      ChiTietHoaDonPhong.TongTien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getString(1), rs.getFloat(7)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<ThongKe> thongKeThang(String thang) {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT      ChiTietHoaDonPhong.MaPhong,PhieuDatPhong.NgayLapPhieu,  sum(ChiTietHoaDonPhong.TongTien) as tong\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat where MONTH(PhieuDatPhong.NgayLapPhieu) =" + thang + "and YEAR(PhieuDatPhong.NgayLapPhieu)= YEAR(GETDATE())  group by ChiTietHoaDonPhong.MaPhong,  PhieuDatPhong.NgayLapPhieu";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getString(1), rs.getFloat(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<ThongKe> thongKhachHang() {
        ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
        try {
            String sql = "SELECT        PhieuDatPhong.MaKhachHang, count(*) as TongHoaDon\n"
                    + "FROM            ChiTietHoaDonPhong INNER JOIN\n"
                    + "                         HoaDonPhong ON ChiTietHoaDonPhong.MaHDP = HoaDonPhong.MaHDP INNER JOIN\n"
                    + "                         PhieuDatPhong ON HoaDonPhong.MaPhieuDat = PhieuDatPhong.MaPhieuDat group by  PhieuDatPhong.MaKhachHang";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                ds.add(new ThongKe(rs.getInt(1), rs.getInt(2)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

}
