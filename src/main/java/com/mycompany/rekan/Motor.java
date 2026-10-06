package com.mycompany.rekan;

public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String platNomor, String merk, int tahunKeluaran, int biayaSewa, String jenisTransmisi) {
        super(platNomor, merk, tahunKeluaran, biayaSewa); 
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() { return this.jenisTransmisi; }
    public void setJenisTransmisi(String jenisTransmisi) { this.jenisTransmisi = jenisTransmisi; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Motor] Plat: %-10s | Merk: %-12s | Tahun: %d | Sewa: Rp%-7d | Transmisi: %s\n",
            this.getPlatNomor(), this.getMerk(), this.getTahunKeluaran(), this.getBiayaSewa(), this.jenisTransmisi);
    }

    @Override
    public void caraSewa() {
        System.out.println("-> Syarat Sewa Motor: Wajib jaminan KTP asli dan memiliki SIM C.");
    }
}