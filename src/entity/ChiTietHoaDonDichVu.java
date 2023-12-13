/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HieuPCW
 */
public class ChiTietHoaDonDichVu {

    private HoaDonDichVu HDDV;
    private DichVu DV;
    private int SoLuong;

    public ChiTietHoaDonDichVu(HoaDonDichVu HDDV, DichVu DV, int SoLuong) {
        this.HDDV = HDDV;
        this.DV = DV;
        this.SoLuong = SoLuong;
    }

    public HoaDonDichVu getHDDV() {
        return HDDV;
    }

    public void setHDDV(HoaDonDichVu HDDV) {
        this.HDDV = HDDV;
    }

    public DichVu getDV() {
        return DV;
    }

    public void setDV(DichVu DV) {
        this.DV = DV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
