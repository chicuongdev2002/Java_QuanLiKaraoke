/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author HieuPCW
 */
public class PhieuDatPhong {
      
    private int maPhieu;
    private KhachHang maKH;
    private Phong maPhong;
    private Date ngayLap;

    public PhieuDatPhong(int maPhieu, KhachHang maKH, Phong maPhong, Date ngayLap) {
        this.maPhieu = maPhieu;
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.ngayLap = ngayLap;
    }

    public PhieuDatPhong(KhachHang maKH, Phong maPhong, Date ngayLap) {
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.ngayLap = ngayLap;
    }
    
    
    

    public PhieuDatPhong(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public KhachHang getMaKH() {
        return maKH;
    }

    public void setMaKH(KhachHang maKH) {
        this.maKH = maKH;
    }

    public Phong getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(Phong maPhong) {
        this.maPhong = maPhong;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    @Override
    public String toString() {
        return "PhieuDatPhong{" + "maPhieu=" + maPhieu + ", maKH=" + maKH + ", maPhong=" + maPhong + ", ngayLap=" + ngayLap + '}';
    }
    
    
    
    
    
    
}
