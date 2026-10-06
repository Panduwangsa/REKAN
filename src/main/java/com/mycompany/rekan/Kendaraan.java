package com.mycompany.rekan;

public class Kendaraan {
    private String platNomor;
    private String merk;
    private int tahunKeluaran;
    private int biayaSewa; 

    public static int totalKendaraanBerhasilDibuat = 0;

    public Kendaraan(String platNomor, String merk, int tahunKeluaran, int biayaSewa) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.tahunKeluaran = tahunKeluaran;
        this.biayaSewa = biayaSewa;
        totalKendaraanBerhasilDibuat++;
    }

    public String getPlatNomor() { return this.platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getMerk() { return this.merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public int getTahunKeluaran() { return this.tahunKeluaran; }
    public void setTahunKeluaran(int tahunKeluaran) {
        if(tahunKeluaran > 2000) {
            this.tahunKeluaran = tahunKeluaran;
        } else {
            System.out.println("Tahun keluaran terlalu tua untuk disewakan!");
        }
    }

    public int getBiayaSewa() { return this.biayaSewa; }
    public void setBiayaSewa(int biayaSewa) { this.biayaSewa = biayaSewa; }

    public void tampilkanInfo() {
        System.out.printf("Plat: %-10s | Merk: %-15s | Tahun: %d | Sewa: Rp%d/hari\n", 
                          this.platNomor, this.merk, this.tahunKeluaran, this.biayaSewa);
    }

    public void caraSewa() {
        System.out.println("-> Syarat Sewa: Membawa KTP Asli.");
    }
}