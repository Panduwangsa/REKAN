

package com.mycompany.rekan;

import com.mycompany.rekan.Kendaraan;

// Biarkan baris package di sini

public class SepedaListrik extends Kendaraan {
    private int kapasitasBaterai; 

    public SepedaListrik(String platNomor, String merk, int tahunKeluaran, int biayaSewa, int kapasitasBaterai) {
        super(platNomor, merk, tahunKeluaran, biayaSewa);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public int getKapasitasBaterai() { return this.kapasitasBaterai; }
    public void setKapasitasBaterai(int kapasitasBaterai) { this.kapasitasBaterai = kapasitasBaterai; }

    @Override
    public void tampilkanInfo() {
        String teksStatus = this.getStatusDipinjam() ? "Dipinjam" : "Tersedia";
        System.out.printf("[Sepeda Listrik] Plat: %-7s | Merk: %-12s | Tahun: %d | Sewa: Rp%-7d | Baterai: %d Wh | Status: %s\n",
            this.getPlatNomor(), this.getMerk(), this.getTahunKeluaran(), this.getBiayaSewa(), this.kapasitasBaterai, teksStatus);
    }

    @Override
    public void caraSewa() {
        System.out.println("-> Syarat Sewa Sepeda Listrik: Wajib jaminan Kartu Pelajar/KTM dan KTP asli.");
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Denda Sepeda Listrik: Rp 10.000 / hari keterlambatan.");
    }
}