/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;


public class DichVuOrder {
      private DichVu DichVu;
            private Date ngayDat;
      private HoaDonDichVu HoaDonDV;

    public DichVuOrder(DichVu DichVu, Date ngayDat, HoaDonDichVu HoaDonDV) {
        this.DichVu = DichVu;
        this.ngayDat = ngayDat;
        this.HoaDonDV = HoaDonDV;
    }

    public DichVu getDichVu() {
        return DichVu;
    }

    public void setDichVu(DichVu DichVu) {
        this.DichVu = DichVu;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public HoaDonDichVu getHoaDonDV() {
        return HoaDonDV;
    }

    public void setHoaDonDV(HoaDonDichVu HoaDonDV) {
        this.HoaDonDV = HoaDonDV;
    }

  

      
  
    

      
    
}
