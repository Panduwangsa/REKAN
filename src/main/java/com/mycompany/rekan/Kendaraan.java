package com.mycompany.rekan;

public class Kendaraan {

    private String platNomor;
    private String merek;
    private int tahunProduksi;
    private double tarifPerHari;

    public static int totalKendaraanBerhasilDibuat = 0;

    public Kendaraan(String platNomor, String merek, int tahunProduksi, double tarifPerHari) {
        this.setPlatNomor(platNomor);
        this.setMerek(merek);
        this.setTahunProduksi(tahunProduksi);
        this.setTarifPerHari(tarifPerHari);

        totalKendaraanBerhasilDibuat++;
    }

    public String getPlatNomor() {
        return this.platNomor;
    }

    public void setPlatNomor(String platNomor) {
        if (platNomor != null && !platNomor.isEmpty()) {
            this.platNomor = platNomor;
        } else {
            System.out.println("Plat nomor tidak boleh kosong!");
        }
    }

    public String getMerek() {
        return this.merek;
    }

    public void setMerek(String merek) {
        if (merek != null && !merek.isEmpty()) {
            this.merek = merek;
        } else {
            System.out.println("Merek tidak boleh kosong!");
        }
    }

    public int getTahunProduksi() {
        return this.tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        if (tahunProduksi > 1990) {
            this.tahunProduksi = tahunProduksi;
        } else {
            System.out.println("Tahun produksi harus lebih dari 1990!");
        }
    }

    public double getTarifPerHari() {
        return this.tarifPerHari;
    }

    public void setTarifPerHari(double tarifPerHari) {
        if (tarifPerHari > 0) {
            this.tarifPerHari = tarifPerHari;
        } else {
            System.out.println("Tarif per hari harus lebih dari 0!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("[KENDARAAN] Plat: %-11s | Merek: %-14s | Tahun: %d | Tarif: Rp%.0f/hari%n",
                this.platNomor, this.merek, this.tahunProduksi, this.tarifPerHari);
    }

    public double hitungBiaya(int hari) {
        return this.tarifPerHari * hari;
    }
}
