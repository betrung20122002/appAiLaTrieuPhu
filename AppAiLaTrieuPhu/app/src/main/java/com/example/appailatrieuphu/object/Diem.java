package com.example.appailatrieuphu.object;

public class Diem {
    private  int id;
    private String ten;
    private long tienThuong;

    public Diem() {
    }

    public Diem(int id, String ten, long tienThuong) {
        this.id = id;
        this.ten = ten;
        this.tienThuong = tienThuong;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(long tienThuong) {
        this.tienThuong = tienThuong;
    }

    @Override
    public String toString() {
        return   id+"              "+ ten + "               "+ tienThuong +"\n";

    }
}
