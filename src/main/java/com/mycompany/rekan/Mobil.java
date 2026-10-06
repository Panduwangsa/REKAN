package com.mycompany.rekan;

public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String platNomor, String merk, int tahunKeluaran, int biayaSewa, int jumlahKursi) {
        super(platNomor, merk, tahunKeluaran, biayaSewa); 
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() { return this.jumlahKursi; }
    public void setJumlahKursi(int jumlahKursi) { this.jumlahKursi = jumlahKursi; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Mobil] Plat: %-10s | Merk: %-12s | Tahun: %d | Sewa: Rp%-7d | Kursi: %d\n",
            this.getPlatNomor(), this.getMerk(), this.getTahunKeluaran(), this.getBiayaSewa(), this.jumlahKursi);
    }

    @Override
    public void caraSewa() {
        System.out.println("-> Syarat Sewa Mobil: Wajib jaminan KTP asli, KK, dan memiliki SIM A.");
    }
}