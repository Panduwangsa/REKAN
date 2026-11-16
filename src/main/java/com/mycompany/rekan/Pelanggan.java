package com.mycompany.rekan;

import java.io.Serializable;

public class Pelanggan implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nik;
    private String nama;

    public Pelanggan(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() { return nik; }
    public String getNama() { return nama; }
}
