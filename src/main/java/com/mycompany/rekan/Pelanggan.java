package com.mycompany.rekan;

/**
 *
 * @author a c e r
 */
public class Pelanggan {
    private String nik;
    private String nama;

    public Pelanggan(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() { return nik; }
    public String getNama() { return nama; }
}
