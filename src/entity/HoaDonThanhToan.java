
package entity;

import java.sql.Date;


public class HoaDonThanhToan {
       
    private HoaDonPhong hoaDon;
    private KhachHang khachHang;
    private Phong phong;
    private Date ngayLap;
    private String gioVao;
    private String gioRa;
    private String thoiGian;

    public HoaDonThanhToan(HoaDonPhong hoaDon, KhachHang khachHang, Phong phong, Date ngayLap, String gioVao, String gioRa, String thoiGian) {
        this.hoaDon = hoaDon;
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayLap = ngayLap;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.thoiGian = thoiGian;
    }

    public HoaDonPhong getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonPhong hoaDon) {
        this.hoaDon = hoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
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

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public String toString() {
        return "ThanhToanHoaDon{" + "hoaDon=" + hoaDon + ", khachHang=" + khachHang + ", phong=" + phong + ", ngayLap=" + ngayLap + ", gioVao=" + gioVao + ", gioRa=" + gioRa + ", thoiGian=" + thoiGian + '}';
    }
    
    
    
    
}
