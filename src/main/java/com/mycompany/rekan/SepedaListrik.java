

package com.mycompany.rekan;

import com.mycompany.rekan.Kendaraan;

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
        System.out.printf("[Sepeda Listrik] Plat: %-7s | Merk: %-12s | Tahun: %d | Sewa: Rp%-7d | Baterai: %d Wh\n",
            this.getPlatNomor(), this.getMerk(), this.getTahunKeluaran(), this.getBiayaSewa(), this.kapasitasBaterai);
    }

    public void caraSewa() {
        System.out.println("-> Syarat Sewa Sepeda Listrik: Wajib jaminan Kartu Pelajar/KTM dan KTP asli.");
    }
}