/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HieuPCW
 */
public class ChiTietHoaDonPhong {

    private HoaDonPhong maHdp;
    private Phong maPhong;
    private String gioVao;
    private String gioRa;
    private String gioSuDung;

    public ChiTietHoaDonPhong(HoaDonPhong maHdp, Phong maPhong, String gioVao, String gioRa, String gioSuDung) {
        this.maHdp = maHdp;
        this.maPhong = maPhong;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.gioSuDung = gioSuDung;
    }

    public ChiTietHoaDonPhong(HoaDonPhong maHdp, Phong maPhong) {
        this.maHdp = maHdp;
        this.maPhong = maPhong;
    }

    public HoaDonPhong getMaHdp() {
        return maHdp;
    }

    public void setMaHdp(HoaDonPhong maHdp) {
        this.maHdp = maHdp;
    }

    public Phong getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(Phong maPhong) {
        this.maPhong = maPhong;
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

    public String getGioSuDung() {
        return gioSuDung;
    }

    public void setGioSuDung(String gioSuDung) {
        this.gioSuDung = gioSuDung;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonPhong{" + "maHdp=" + maHdp + ", maPhong=" + maPhong + ", gioVao=" + gioVao + ", gioRa=" + gioRa + ", gioSuDung=" + gioSuDung + '}';
    }

}
