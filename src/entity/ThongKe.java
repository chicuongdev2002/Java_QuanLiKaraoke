/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class ThongKe {

    private String maHD;
    private String maPhong;
    private String ngay;
    private String gioVao;
    private String gioRa;
    private String tongSoGioSD;
    private float tongTien;
    private int maKH;
    private int soLanDat;

    public ThongKe() {
    }

    public ThongKe(int maKH, int soLanDat) {
        this.maKH = maKH;
        this.soLanDat = soLanDat;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getSoLanDat() {
        return soLanDat;
    }

    public void setSoLanDat(int soLanDat) {
        this.soLanDat = soLanDat;
    }

    public ThongKe(String maHD, String maPhong, String gioVao, String gioRa, String tongSoGioSD, float tongTien) {
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.tongSoGioSD = tongSoGioSD;
        this.tongTien = tongTien;
    }

    public ThongKe(String maPhong, float tongTien) {
        this.maPhong = maPhong;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getTongSoGioSD() {
        return tongSoGioSD;
    }

    public void setTongSoGioSD(String tongSoGioSD) {
        this.tongSoGioSD = tongSoGioSD;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.maHD);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThongKe other = (ThongKe) obj;
        return Objects.equals(this.maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "ThongKe{" + "maHD=" + maHD + ", maPhong=" + maPhong + ", ngay=" + ngay + ", gioVao=" + gioVao + ", gioRa=" + gioRa + ", tongSoGioSD=" + tongSoGioSD + ", tongTien=" + tongTien + '}';
    }

   

}
