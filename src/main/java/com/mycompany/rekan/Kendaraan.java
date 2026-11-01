package com.mycompany.rekan;

public abstract class Kendaraan {
    private String platNomor;
    private String merk;
    private int tahunKeluaran;
    private int biayaSewa; 
    private boolean statusDipinjam; 

    public static int totalKendaraanBerhasilDibuat = 0;

    public Kendaraan(String platNomor, String merk, int tahunKeluaran, int biayaSewa) throws Exception {
        if (tahunKeluaran < 2000) {
            throw new Exception("Tahun keluaran tidak valid (harus di atas tahun 2000).");
        }
        this.platNomor = platNomor;
        this.merk = merk;
        this.tahunKeluaran = tahunKeluaran;
        this.biayaSewa = biayaSewa;
        this.statusDipinjam = false;
        totalKendaraanBerhasilDibuat++;
    }

    public String getPlatNomor() { return this.platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getMerk() { return this.merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public int getTahunKeluaran() { return this.tahunKeluaran; }
    public void setTahunKeluaran(int tahunKeluaran) { this.tahunKeluaran = tahunKeluaran; }

    public int getBiayaSewa() { return this.biayaSewa; }
    public void setBiayaSewa(int biayaSewa) { this.biayaSewa = biayaSewa; }

    public boolean getStatusDipinjam() { return this.statusDipinjam; }
    public void setStatusDipinjam(boolean status) { this.statusDipinjam = status; }

    public void tampilkanInfo() {
        String teksStatus = this.statusDipinjam ? "Dipinjam" : "Tersedia";
        System.out.printf("Plat: %-10s | Merk: %-15s | Tahun: %d | Sewa: Rp%d/hari | Status: %s\n", 
                          this.platNomor, this.merk, this.tahunKeluaran, this.biayaSewa, teksStatus);
    }

    public void caraSewa() {
        System.out.println("-> Syarat Sewa: Membawa KTP Asli.");
    }

    public abstract void hitungDendaKeterlambatan();
}   