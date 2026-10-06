package com.mycompany.rekan;

import java.util.Scanner;

public class Rekan {
    
    // Fitur Compile-Time Polymorphism (Overloading 1)
    public static void cariKendaraan(String merk, Kendaraan[] daftarKendaraan, int jumlah) {
        System.out.println("\n--- Mencari kendaraan dengan Merk (Teks): " + merk + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftarKendaraan[i].getMerk().equalsIgnoreCase(merk)) {
                System.out.print("- Ditemukan: ");
                daftarKendaraan[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Kendaraan tidak ditemukan.");
    }

    // Fitur Compile-Time Polymorphism (Overloading 2)
    public static void cariKendaraan(int tahun, Kendaraan[] daftarKendaraan, int jumlah) {
        System.out.println("\n--- Mencari kendaraan dengan Tahun (Angka): " + tahun + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftarKendaraan[i].getTahunKeluaran() == tahun) {
                System.out.print("- Ditemukan: ");
                daftarKendaraan[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Kendaraan tidak ditemukan.");
    }

    // Fitur Runtime Polymorphism / Dynamic Binding
    public static void simulasiSewa(Kendaraan k) {
        k.caraSewa(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Kendaraan[] daftarKendaraan = new Kendaraan[20];
        int jumlahKendaraan = 0;
        boolean isRunning = true;

        daftarKendaraan[jumlahKendaraan++] = new Mobil("BE 1111 XX", "Toyota Avanza", 2022, 350000, 7);
        daftarKendaraan[jumlahKendaraan++] = new Motor("BE 2222 YY", "Yamaha NMAX", 2021, 150000, "Matic");
        daftarKendaraan[jumlahKendaraan++] = new SepedaListrik("BE 3333 ZZ", "Uwinfly D8P", 2023, 50000, 800);

        System.out.println("==================================================");
        System.out.println("   RENTAL KENDARAAN (REKAN) - Ilmu Komputer UNILA ");
        System.out.println("   By: Muhammad Pandu Wangsa (2517051014)         ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Cari Kendaraan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    if (jumlahKendaraan < daftarKendaraan.length) {
                        System.out.println("\n-- Pilih Jenis Kendaraan --");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.println("3. Sepeda Listrik");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Plat Nomor: ");
                        String platBaru = scanner.nextLine();
                        System.out.print("Masukkan Merk: ");
                        String merkBaru = scanner.nextLine();
                        System.out.print("Masukkan Tahun Keluaran: ");
                        int tahunBaru = scanner.nextInt();
                        
                        System.out.print("Masukkan Biaya Sewa per Hari (Rp): ");
                        int biayaBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Kursi: ");
                            int kursi = scanner.nextInt();
                            scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Mobil(platBaru, merkBaru, tahunBaru, biayaBaru, kursi);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Transmisi (Matic/Manual): ");
                            String transmisi = scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Motor(platBaru, merkBaru, tahunBaru, biayaBaru, transmisi);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kapasitas Baterai (Wh): ");
                            int baterai = scanner.nextInt();
                            scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new SepedaListrik(platBaru, merkBaru, tahunBaru, biayaBaru, baterai);
                        } else {
                            System.out.println("Pilihan jenis kendaraan tidak valid.");
                            break;
                        }

                        jumlahKendaraan++;
                        System.out.println("Sukses! Kendaraan berhasil ditambahkan ke garasi.");
                    } else {
                        System.out.println("Maaf, kapasitas garasi sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Kendaraan di REKAN ---");
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada kendaraan yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahKendaraan; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKendaraan[i].tampilkanInfo();
                            
                            simulasiSewa(daftarKendaraan[i]); 
                            System.out.println();
                        }
                        System.out.println("* Total Kendaraan Terdaftar: " + Kendaraan.totalKendaraanBerhasilDibuat);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n-- Fitur Cari Kendaraan --");
                    System.out.println("1. Cari berdasarkan Merk (Teks)");
                    System.out.println("2. Cari berdasarkan Tahun (Angka)");
                    System.out.print("Pilih Mode Pencarian (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Merk Kendaraan: ");
                        String kataKunci = scanner.nextLine();
                        cariKendaraan(kataKunci, daftarKendaraan, jumlahKendaraan);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Tahun Keluaran: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariKendaraan(angkaKunci, daftarKendaraan, jumlahKendaraan); 
                    } else {
                        System.out.println("Pilihan mode cari tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem REKAN!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
                    break;
            }
        }
        scanner.close();
    }
}