package com.mycompany.rekan;

import java.util.Scanner;

public class Rekan {

    // Method overloading: cariKendaraan berdasarkan merek (String)
    public static void cariKendaraan(String merek, Kendaraan[] daftar, int jumlah) {
        System.out.println("\nMencari kendaraan dengan merek: " + merek);

        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getMerek().toLowerCase().contains(merek.toLowerCase())) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kendaraan tidak ditemukan.");
        }
    }

    // Method overloading: cariKendaraan berdasarkan tahun produksi (int)
    public static void cariKendaraan(int tahun, Kendaraan[] daftar, int jumlah) {
        System.out.println("\nMencari kendaraan dengan tahun: " + tahun);

        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getTahunProduksi() == tahun) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kendaraan tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kendaraan[] daftarKendaraan = new Kendaraan[10];

        int jumlahKendaraan = 0;
        boolean isRunning = true;

        System.out.println("==============================================");
        System.out.println("   SELAMAT DATANG DI REKAN (Rental Kendaraan) ");
        System.out.println("==============================================");
        System.out.println("REKAN membantu mengelola data rental mobil dan motor.");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Cari Kendaraan (Fitur Overloading)");
            System.out.println("4. Hitung Biaya Sewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahKendaraan < daftarKendaraan.length) {
                        System.out.println("\n-- Pilih Jenis Kendaraan --");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.print("Pilihan (1/2): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Plat Nomor: ");
                        String platBaru = scanner.nextLine();

                        System.out.print("Masukkan Merek: ");
                        String merekBaru = scanner.nextLine();

                        System.out.print("Masukkan Tahun Produksi: ");
                        int tahunBaru = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Tarif per Hari: ");
                        double tarifBaru = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Penumpang: ");
                            int penumpangBaru = scanner.nextInt();
                            scanner.nextLine();

                            daftarKendaraan[jumlahKendaraan] =
                                    new Mobil(platBaru, merekBaru, tahunBaru, tarifBaru, penumpangBaru);
                            jumlahKendaraan++;
                            System.out.println("Sukses! Mobil berhasil ditambahkan.");
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Mesin (cc): ");
                            int ccBaru = scanner.nextInt();
                            scanner.nextLine();

                            daftarKendaraan[jumlahKendaraan] =
                                    new Motor(platBaru, merekBaru, tahunBaru, tarifBaru, ccBaru);
                            jumlahKendaraan++;
                            System.out.println("Sukses! Motor berhasil ditambahkan.");
                        } else {
                            System.out.println("Jenis kendaraan tidak valid.");
                        }
                    } else {
                        System.out.println("Maaf, kapasitas garasi sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Kendaraan Rental ---");
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada kendaraan yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahKendaraan; i++) {
                            System.out.printf("%d. ", (i + 1));
                            daftarKendaraan[i].tampilkanInfo();
                        }
                        System.out.println("\n* Total Kendaraan yang Terdaftar: "
                                + Kendaraan.totalKendaraanBerhasilDibuat);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n-- Fitur Cari Kendaraan --");
                    System.out.println("1. Cari berdasarkan Merek");
                    System.out.println("2. Cari berdasarkan Tahun");
                    System.out.print("Pilih (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Merek: ");
                        String kataKunci = scanner.nextLine();
                        cariKendaraan(kataKunci, daftarKendaraan, jumlahKendaraan);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Tahun: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariKendaraan(angkaKunci, daftarKendaraan, jumlahKendaraan);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }

                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 4:
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada kendaraan yang tersimpan.");
                    } else {
                        System.out.print("\nMasukkan nomor kendaraan (1-" + jumlahKendaraan + "): ");
                        int nomor = scanner.nextInt();
                        scanner.nextLine();

                        if (nomor >= 1 && nomor <= jumlahKendaraan) {
                            System.out.print("Lama sewa (hari): ");
                            int hari = scanner.nextInt();
                            scanner.nextLine();

                            Kendaraan dipilih = daftarKendaraan[nomor - 1];
                            System.out.println("\n--- Rincian Biaya Sewa ---");
                            dipilih.tampilkanInfo();
                            System.out.printf("Lama sewa  : %d hari%n", hari);
                            System.out.printf("Total biaya: Rp%.0f%n", dipilih.hitungBiaya(hari));
                        } else {
                            System.out.println("Nomor kendaraan tidak valid.");
                        }
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan REKAN!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");
                    break;
            }
        }

        scanner.close();
    }
}
