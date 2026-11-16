package com.mycompany.rekan;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public void simpanDataKeFile() {
        try {
            FileOutputStream fileKeluar = new FileOutputStream("data_rekan.dat");
            ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar);
            mesinPembeku.writeObject(this.daftarKendaraan);
            mesinPembeku.writeObject(this.dataPelanggan);
            mesinPembeku.close();
            System.out.println("-> [SYSTEM LOG] Seluruh data berhasil disimpan (Serialization) ke Harddisk!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public boolean muatDataDariFile() {
        try {
            File cekFile = new File("data_rekan.dat");
            if (!cekFile.exists()) return false;

            FileInputStream fileMasuk = new FileInputStream(cekFile);
            ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk);

            this.daftarKendaraan = (ArrayList<Kendaraan>) mesinPembangkit.readObject();
            this.dataPelanggan = (HashMap<String, Pelanggan>) mesinPembangkit.readObject();
            Kendaraan.totalKendaraanBerhasilDibuat = this.daftarKendaraan.size();

            mesinPembangkit.close();
            System.out.println("-> [SYSTEM LOG] Data sistem berhasil dimuat ulang (Deserialization) dari penyimpanan.");
            return true;
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
            return false;
        }
    }

    public void bacaLogTransaksi() {
        System.out.println("\n--- Riwayat Log Transaksi (log_transaksi.txt) ---");
        try {
            File fileLog = new File("log_transaksi.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada riwayat log transaksi tersimpan.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membuka file log transaksi.");
        }
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