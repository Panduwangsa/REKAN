package com.mycompany.rekan;

public class Mobil extends Kendaraan implements DapatDiservis, DapatAsuransi {
    private int jumlahKursi;

    public Mobil(String platNomor, String merk, int tahunKeluaran, int biayaSewa, int jumlahKursi) throws Exception {
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
    public void caraSewa() { System.out.println("-> Syarat Sewa Mobil: Wajib jaminan KTP, KK, dan SIM A."); }

    @Override
    public void hitungDendaKeterlambatan() { System.out.println("-> Denda Mobil: Rp 50.000 / hari keterlambatan."); }

    @Override
    public void prosesServis() { System.out.println("-> PROSES: Mobil masuk bengkel ganti oli."); }

    @Override
    public void klaimAsuransi() { System.out.println("-> ASURANSI: Asuransi All-Risk mobil aktif."); }
}