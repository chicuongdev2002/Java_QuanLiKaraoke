

package entity;

public class HoaDonPhong {
   
    private int maHDP;
    private NhanVien maNV;
    private PhieuDatPhong maPD;
    private boolean tinhTrang;

    public HoaDonPhong(int maHDP, NhanVien maNV, PhieuDatPhong maPD, boolean tinhTrang) {
        this.maHDP = maHDP;
        this.maNV = maNV;
        this.maPD = maPD;
        this.tinhTrang = tinhTrang;
    }

    public HoaDonPhong(NhanVien maNV, PhieuDatPhong maPD, boolean tinhTrang) {
        this.maNV = maNV;
        this.maPD = maPD;
        this.tinhTrang = tinhTrang;
    }

    public HoaDonPhong(int maHDP) {
        this.maHDP = maHDP;
    }

    public int getMaHDP() {
        return maHDP;
    }

    public void setMaHDP(int maHDP) {
        this.maHDP = maHDP;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public PhieuDatPhong getMaPD() {
        return maPD;
    }

    public void setMaPD(PhieuDatPhong maPD) {
        this.maPD = maPD;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDonPhong{" + "maHDP=" + maHDP + ", maNV=" + maNV + ", maPD=" + maPD + ", tinhTrang=" + tinhTrang + '}';
    }
    
    


    
}
