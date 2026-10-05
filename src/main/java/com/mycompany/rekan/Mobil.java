package com.mycompany.rekan;

public class Mobil extends Kendaraan {

    private int jumlahPenumpang;

    public Mobil(String platNomor, String merek, int tahunProduksi, double tarifPerHari,
                 int jumlahPenumpang) {

        super(platNomor, merek, tahunProduksi, tarifPerHari);

        this.setJumlahPenumpang(jumlahPenumpang);
    }

    public int getJumlahPenumpang() {
        return this.jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        if (jumlahPenumpang > 0) {
            this.jumlahPenumpang = jumlahPenumpang;
        } else {
            System.out.println("Jumlah penumpang harus lebih dari 0!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("[MOBIL] Plat: %-11s | Merek: %-14s | Tahun: %d | Tarif: Rp%.0f/hari | Penumpang: %d%n",
                this.getPlatNomor(),
                this.getMerek(),
                this.getTahunProduksi(),
                this.getTarifPerHari(),
                this.jumlahPenumpang);
    }

    public double hitungBiaya(int hari) {
        double asuransi = 0.1; // asuransi mobil 10%
        return super.hitungBiaya(hari) + (super.hitungBiaya(hari) * asuransi);
    }
}
