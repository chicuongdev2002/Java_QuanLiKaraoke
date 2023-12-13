/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class PhieuTraPhong {

private String tenKH;
private String SDT;
private String CMND;
private int maPhieuDat;
private String maPhong;
private String ngayLap;
private String gioVao;

    public PhieuTraPhong(String tenKH, String SDT, String CMND, int maPhieuDat, String maPhong, String ngayLap, String gioVao) {
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.CMND = CMND;
        this.maPhieuDat = maPhieuDat;
        this.maPhong = maPhong;
        this.ngayLap = ngayLap;
        this.gioVao = gioVao;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getMaPhieuDat() {
        return maPhieuDat;
    }

    public void setMaPhieuDat(int maPhieuDat) {
        this.maPhieuDat = maPhieuDat;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    @Override
    public String toString() {
        return "PhieuTraPhong{" + "tenKH=" + tenKH + ", SDT=" + SDT + ", CMND=" + CMND + ", maPhieuDat=" + maPhieuDat + ", maPhong=" + maPhong + ", ngayLap=" + ngayLap + ", gioVao=" + gioVao + '}';
    }




    
}
