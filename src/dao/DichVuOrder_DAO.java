/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Connect;
import entity.DichVu;
import entity.DichVuOrder;
import entity.DonViDichVu;
import entity.HoaDonDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuPCW
 */
public class DichVuOrder_DAO {

    private Connection con;

    public DichVuOrder_DAO() {

        con = Connect.getInstance().getConnection();
    }

    public ArrayList<DichVuOrder> GetAllDichVuOrder(String maPhong) {
        ArrayList<DichVuOrder> dsDV = new ArrayList<>();
        try {
            String sql = "SELECT        DichVu.TenDichVu, ChiTietHoaDonDichVu.SoLuong, DonViDichVu.TenDonVi, DichVu.DonGia, HoaDonDichVu.NgayLap, ChiTietHoaDonDichVu.MaHDDV, HoaDonDichVu.MaPhong\n"
                    + "FROM            DichVu INNER JOIN\n"
                    + "                         ChiTietHoaDonDichVu ON DichVu.MaDichVu = ChiTietHoaDonDichVu.MaDV INNER JOIN\n"
                    + "                         HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV INNER JOIN\n"
                    + "                         DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi  where  HoaDonDichVu.TinhTrang=0 and HoaDonDichVu.MaPhong=?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, maPhong);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsDV.add(new DichVuOrder(new DichVu(rs.getString(1), rs.getDouble(4), rs.getInt(2), new DonViDichVu(rs.getString(3))), rs.getDate(5), new HoaDonDichVu(rs.getInt(6))));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDV;
    }

    public ArrayList<DichVuOrder> GetAllDichVuOrderXemLai(int maDV) {
        ArrayList<DichVuOrder> dsDV = new ArrayList<>();
        try {
            String sql = "SELECT        DichVu.TenDichVu, ChiTietHoaDonDichVu.SoLuong, DonViDichVu.TenDonVi, DichVu.DonGia, HoaDonDichVu.NgayLap, ChiTietHoaDonDichVu.MaHDDV, HoaDonDichVu.MaPhong\n"
                    + "FROM            DichVu INNER JOIN\n"
                    + "                         ChiTietHoaDonDichVu ON DichVu.MaDichVu = ChiTietHoaDonDichVu.MaDV INNER JOIN\n"
                    + "                         HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV INNER JOIN\n"
                    + "                         DonViDichVu ON DichVu.MaDonVi = DonViDichVu.MaDonVi  where ChiTietHoaDonDichVu.MaHDDV=?";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, maDV);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                dsDV.add(new DichVuOrder(new DichVu(rs.getString(1), rs.getDouble(4), rs.getInt(2), new DonViDichVu(rs.getString(3))), rs.getDate(5), new HoaDonDichVu(rs.getInt(6))));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDV;
    }

}
