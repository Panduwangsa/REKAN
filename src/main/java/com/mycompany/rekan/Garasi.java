package com.mycompany.rekan;

public class Garasi {
    private String namaGarasi;
    private int kapasitas;

    public Garasi(String namaGarasi, int kapasitas) {
        this.namaGarasi = namaGarasi;
        this.kapasitas = kapasitas;
    }

    public void bukaGarasi() {
        System.out.println("-> " + namaGarasi + " dibuka. Kapasitas: " + kapasitas + " kendaraan.");
    }
}
