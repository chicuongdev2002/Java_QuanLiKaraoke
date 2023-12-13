/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

public class KhachHang {
    
    private int maKH;
    private String tenKH;
    private String CMND;
    private Date ngaySinh;
    private String SDT;

    
      public KhachHang() {
   
    }

      
    public KhachHang(int maKH, String tenKH, String CMND, Date ngaySinh, String SDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.CMND = CMND;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
    }

    public KhachHang(String tenKH, String CMND, Date ngaySinh, String SDT) {
        this.tenKH = tenKH;
        this.CMND = CMND;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
    }

    public KhachHang(int maKH, String tenKH, String CMND) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.CMND = CMND;
    }

    public KhachHang(int maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String SDT) {
        this.SDT = SDT;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", CMND=" + CMND + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + '}';
    }
    
    
    
    


    
}
