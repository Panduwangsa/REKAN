package com.mycompany.rekan;

public class Motor extends Kendaraan {

    private int kapasitasMesin;

    public Motor(String platNomor, String merek, int tahunProduksi, double tarifPerHari, int kapasitasMesin) {

        super(platNomor, merek, tahunProduksi, tarifPerHari);

        this.setKapasitasMesin(kapasitasMesin);
    }

    public int getKapasitasMesin() {
        return this.kapasitasMesin;
    }

    public void setKapasitasMesin(int kapasitasMesin) {
        if (kapasitasMesin > 0) {
            this.kapasitasMesin = kapasitasMesin;
        } else {
            System.out.println("Kapasitas mesin harus lebih dari 0!");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[MOTOR] Plat: %-11s | Merek: %-14s | Tahun: %d | Tarif: Rp%.0f/hari | Mesin: %d cc%n",
                this.getPlatNomor(),
                this.getMerek(),
                this.getTahunProduksi(),
                this.getTarifPerHari(),
                this.kapasitasMesin);
    }

    @Override
    public double hitungBiaya(int hari) {
        double biayaHelm = 10000; // sewa helm
        return super.hitungBiaya(hari) + biayaHelm;
    }
}
