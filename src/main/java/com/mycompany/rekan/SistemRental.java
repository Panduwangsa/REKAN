package com.mycompany.rekan;

import java.util.ArrayList;
import java.util.HashMap;

public class SistemRental {
    private String namaSistem;
    private Garasi garasiUtama;
    private ArrayList<Kendaraan> daftarKendaraan;
    private HashMap<String, Pelanggan> dataPelanggan; 

    public SistemRental(String namaSistem) {
        this.namaSistem = namaSistem;
        this.garasiUtama = new Garasi("Garasi Pusat REKAN", 50); 
        this.daftarKendaraan = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaSistem() {
        System.out.println("\n*** Menginisialisasi " + this.namaSistem + " ***");
        garasiUtama.bukaGarasi();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("Sukses! Kendaraan ditambahkan. (Total: " + daftarKendaraan.size() + ")");
    }

    public void lihatSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            Kendaraan k = daftarKendaraan.get(i);
            k.tampilkanInfo();
            k.hitungDendaKeterlambatan();
            if (k instanceof DapatDiservis) ((DapatDiservis) k).prosesServis();
            if (k instanceof DapatAsuransi) ((DapatAsuransi) k).klaimAsuransi();
            System.out.println();
        }
    }

    public void cariKendaraan(String merk) throws KendaraanTidakDitemukanException {
        boolean ditemukan = false;
        for (Kendaraan k : daftarKendaraan) {
            if (k.getMerk().equalsIgnoreCase(merk)) {
                k.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KendaraanTidakDitemukanException("Gagal: Kendaraan merk '" + merk + "' tidak ditemukan.");
        }
    }

    public void tambahPelanggan(Pelanggan p) {
        dataPelanggan.put(p.getNik(), p);
        System.out.println("Berhasil menambahkan pelanggan!");
    }

    public void cariPelanggan(String nik) {
        if (dataPelanggan.containsKey(nik)) {
            System.out.println("Ditemukan! Nama: " + dataPelanggan.get(nik).getNama());
        } else {
            System.out.println("Pelanggan dengan NIK tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
        for (Pelanggan p : dataPelanggan.values()) {
            System.out.println("- NIK: " + p.getNik() + " | Nama: " + p.getNama());
        }
    }

    public Pelanggan getPelanggan(String nik) { return dataPelanggan.get(nik); }
    public Kendaraan getKendaraanInt(int index) { return daftarKendaraan.get(index); }
    public int getJumlahKendaraan() { return daftarKendaraan.size(); }
}
