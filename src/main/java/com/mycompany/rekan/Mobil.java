package com.mycompany.rekan;

public class Mobil extends Kendaraan implements DapatDiservis, DapatAsuransi {
    private int jumlahKursi;

    public Mobil(String platNomor, String merk, int tahunKeluaran, int biayaSewa, int jumlahKursi) {
        super(platNomor, merk, tahunKeluaran, biayaSewa); 
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() { return this.jumlahKursi; }
    public void setJumlahKursi(int jumlahKursi) { this.jumlahKursi = jumlahKursi; }

    @Override
    public void tampilkanInfo() {
        String teksStatus = this.getStatusDipinjam() ? "Dipinjam" : "Tersedia";
        System.out.printf("[Mobil] Plat: %-10s | Merk: %-12s | Tahun: %d | Sewa: Rp%-7d | Kursi: %d | Status: %s\n",
            this.getPlatNomor(), this.getMerk(), this.getTahunKeluaran(), this.getBiayaSewa(), this.jumlahKursi, teksStatus);
    }

    @Override
    public void caraSewa() {
        System.out.println("-> Syarat Sewa Mobil: Wajib jaminan KTP asli, KK, dan memiliki SIM A.");
    }

    // Overriding abstract method dari superclass[cite: 77, 88]
    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Denda Mobil: Rp 50.000 / hari keterlambatan.");
    }

    // Overriding method dari interface DapatDiservis[cite: 79, 88]
    @Override
    public void prosesServis() {
        System.out.println("-> PROSES: Mobil masuk bengkel untuk ganti oli dan cek mesin.");
    }

    // Overriding method dari interface DapatAsuransi[cite: 79, 88]
    @Override
    public void klaimAsuransi() {
        System.out.println("-> ASURANSI: Asuransi All-Risk mobil aktif dicover 100%.");
    }
}