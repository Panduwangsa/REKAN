package com.mycompany.rekan;

public abstract class Kendaraan {
    private String platNomor;
    private String merk;
    private int tahunKeluaran;
    private int biayaSewa; 
    private boolean statusDipinjam; 

    public static int totalKendaraanBerhasilDibuat = 0;

    public Kendaraan(String platNomor, String merk, int tahunKeluaran, int biayaSewa) {
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
    public void setTahunKeluaran(int tahunKeluaran) {
        if(tahunKeluaran > 2000) {
            this.tahunKeluaran = tahunKeluaran;
        } else {
            System.out.println("Tahun keluaran terlalu tua untuk disewakan!");
        }
    }

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

    // Abstract method baru (tanpa tubuh/logika)[cite: 77, 85]
    public abstract void hitungDendaKeterlambatan();

    public double hitungBiaya(int lamaHari, double diskonPersen) {
        throw new UnsupportedOperationException("Not supported yet.");
    } // <--- TAMBAHIN KURUNG KURAWAL INI DI BARIS 57

    public double hitungDenda(int hariTerlambat) {
        return 50000 * hariTerlambat;
    }

    public void setTersedia(boolean b) {
        this.statusDipinjam = !b;
    }

    public static String rupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

}