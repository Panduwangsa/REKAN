package com.mycompany.rekan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rekan {
    
    public static void cariKendaraan(String merk, ArrayList<Kendaraan> daftarKendaraan) throws KendaraanTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Merk: " + merk + " ---");
        boolean ditemukan = false;
        
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            if (daftarKendaraan.get(i).getMerk().equalsIgnoreCase(merk)) {
                System.out.print("- Ditemukan: ");
                daftarKendaraan.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            throw new KendaraanTidakDitemukanException("Gagal: Kendaraan dengan merk '" + merk + "' tidak terdaftar di garasi!");
        }
    }

    public static void simulasiSewa(Kendaraan k) {
        k.caraSewa(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        HashMap<String, String> dataPelanggan = new HashMap<>();
        
        dataPelanggan.put("320111", "M Pandu Wangsa");
        dataPelanggan.put("320222", "Mayang Sari");
        
        try {
            daftarKendaraan.add(new Mobil("BE 1111 XX", "Toyota Avanza", 2022, 350000, 7));
            daftarKendaraan.add(new Motor("BE 2222 YY", "Yamaha NMAX", 2021, 150000, "Matic"));
            daftarKendaraan.add(new SepedaListrik("BE 3333 ZZ", "Uwinfly D8P", 2023, 50000, 800));
        } catch (Exception e) {
            System.out.println("Gagal memuat data awal: " + e.getMessage());
        }

        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("   RENTAL KENDARAAN (REKAN) - Ilmu Komputer UNILA ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Cari Kendaraan");
            System.out.println("4. Pinjam Kendaraan");
            System.out.println("5. Manajemen Pelanggan");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu (1-6): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        System.out.println("\n-- Pilih Jenis Kendaraan --");
                        System.out.println("1. Mobil | 2. Motor | 3. Sepeda Listrik");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt(); scanner.nextLine();

                        System.out.print("Masukkan Plat Nomor: ");
                        String platBaru = scanner.nextLine();
                        System.out.print("Masukkan Merk: ");
                        String merkBaru = scanner.nextLine();
                        System.out.print("Masukkan Tahun Keluaran (Wajib > 2000): ");
                        int tahunBaru = scanner.nextInt(); 
                        System.out.print("Masukkan Biaya Sewa per Hari (Rp): ");
                        int biayaBaru = scanner.nextInt(); scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Kursi: ");
                            int kursi = scanner.nextInt(); scanner.nextLine();
                            daftarKendaraan.add(new Mobil(platBaru, merkBaru, tahunBaru, biayaBaru, kursi));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Transmisi (Matic/Manual): ");
                            String transmisi = scanner.nextLine();
                            daftarKendaraan.add(new Motor(platBaru, merkBaru, tahunBaru, biayaBaru, transmisi));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kapasitas Baterai (Wh): ");
                            int baterai = scanner.nextInt(); scanner.nextLine();
                            daftarKendaraan.add(new SepedaListrik(platBaru, merkBaru, tahunBaru, biayaBaru, baterai));
                        } else {
                            System.out.println("Pilihan tidak valid.");
                            break;
                        }
                        System.out.println("Sukses! Kendaraan masuk garasi. Total: " + daftarKendaraan.size());
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Kendaraan (ArrayList) ---");
                        if (daftarKendaraan.isEmpty()) {
                            System.out.println("Belum ada kendaraan yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarKendaraan.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarKendaraan.get(i).tampilkanInfo();
                                simulasiSewa(daftarKendaraan.get(i)); 
                                daftarKendaraan.get(i).hitungDendaKeterlambatan(); 

                                if (daftarKendaraan.get(i) instanceof DapatDiservis) {
                                    DapatDiservis itemServis = (DapatDiservis) daftarKendaraan.get(i);
                                    itemServis.prosesServis();
                                }
                                if (daftarKendaraan.get(i) instanceof DapatAsuransi) {
                                    DapatAsuransi itemAsuransi = (DapatAsuransi) daftarKendaraan.get(i);
                                    itemAsuransi.klaimAsuransi();
                                }
                                System.out.println();
                            }
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Kendaraan --");
                        System.out.print("Masukkan Merk yang dicari: ");
                        String kataKunci = scanner.nextLine();
                        
                        try {
                            cariKendaraan(kataKunci, daftarKendaraan);
                        } catch (KendaraanTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                        break;

                    case 4:
                        System.out.println("\n-- Fitur Pinjam Kendaraan --");
                        if (daftarKendaraan.isEmpty()) {
                            System.out.println("Belum ada kendaraan di garasi.");
                            break;
                        }
                        for (int i = 0; i < daftarKendaraan.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKendaraan.get(i).tampilkanInfo();
                        }
                        
                        System.out.print("\nPilih nomor kendaraan: ");
                        int noPinjam = scanner.nextInt(); scanner.nextLine();
                        int index = noPinjam - 1;
                        
                        if (index >= 0 && index < daftarKendaraan.size()) {
                            if (!daftarKendaraan.get(index).getStatusDipinjam()) {
                                System.out.print("Berapa hari durasi sewa? ");
                                int durasi = scanner.nextInt(); scanner.nextLine();
                                
                                int total = daftarKendaraan.get(index).getBiayaSewa() * durasi;
                                daftarKendaraan.get(index).setStatusDipinjam(true); 
                                
                                System.out.println("\n--- STRUK PENYEWAAN ---");
                                System.out.println("Kendaraan: " + daftarKendaraan.get(index).getMerk());
                                System.out.println("Total Biaya: Rp" + total);
                                System.out.println("Status   : BERHASIL");
                                
                            } else {
                                System.out.println("Maaf, kendaraan sedang dipinjam.");
                            }
                        } else {
                            System.out.println("Nomor kendaraan tidak valid.");
                        }
                        break;

                    case 5:
                        System.out.println("\n-- Kelola Pelanggan (HashMap) --");
                        System.out.println("1. Tambah Pelanggan Baru");
                        System.out.println("2. Cari Pelanggan via NIK");
                        System.out.println("3. Tampilkan Semua Pelanggan");
                        System.out.print("Pilih: ");
                        int menuPelanggan = scanner.nextInt(); scanner.nextLine();
                        
                        if (menuPelanggan == 1) {
                            System.out.print("Masukkan NIK (sebagai Key): ");
                            String nik = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String nama = scanner.nextLine();
                            dataPelanggan.put(nik, nama);
                            System.out.println("Berhasil menambahkan pelanggan!");
                        } else if (menuPelanggan == 2) {
                            System.out.print("Masukkan NIK yang dicari: ");
                            String searchNik = scanner.nextLine();
                            if (dataPelanggan.containsKey(searchNik)) {
                                System.out.println("Ditemukan! Nama: " + dataPelanggan.get(searchNik));
                            } else {
                                System.out.println("Pelanggan dengan NIK tersebut tidak terdaftar.");
                            }
                        } else if (menuPelanggan == 3) {
                            System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
                            for (String keyNik : dataPelanggan.keySet()) {
                                System.out.println("- NIK: " + keyNik + " | Nama: " + dataPelanggan.get(keyNik));
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Terima kasih telah menggunakan sistem REKAN!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Format salah! Anda memasukkan teks/huruf saat sistem meminta angka.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}