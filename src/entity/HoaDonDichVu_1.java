
package entity;

import java.sql.Date;




public class HoaDonDichVu_1 {
    private int maHDDV;
    private Date ngayLap;
    private Phong phong;
    private boolean tinhTrang;

    public HoaDonDichVu_1(int maHDDV, Date ngayLap, Phong phong, boolean tinhTrang) {
        this.maHDDV = maHDDV;
        this.ngayLap = ngayLap;
        this.phong = phong;
        this.tinhTrang = tinhTrang;
    }

    public HoaDonDichVu_1(int maHDDV) {
        this.maHDDV = maHDDV;
    }

    public HoaDonDichVu_1(Date ngayLap, Phong phong, boolean tinhTrang) {
        this.ngayLap = ngayLap;
        this.phong = phong;
        this.tinhTrang = tinhTrang;
    }

    public int getMaHDDV() {
        return maHDDV;
    }

    public void setMaHDDV(int maHDDV) {
        this.maHDDV = maHDDV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDonDichVu{" + "maHDDV=" + maHDDV + ", ngayLap=" + ngayLap + ", phong=" + phong + ", tinhTrang=" + tinhTrang + '}';
    }
    
    
    
}
