package com.mycompany.rekan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rekan {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        SistemRental sistemRekan = new SistemRental("Sistem REKAN Unila");
        sistemRekan.bukaSistem();
        
        sistemRekan.tambahPelanggan(new Pelanggan("320111", "M Pandu Wangsa"));
        sistemRekan.tambahPelanggan(new Pelanggan("320222", "Mayang Sari"));
        
        try {
            sistemRekan.tambahKendaraan(new Mobil("BE 1111 XX", "Toyota Avanza", 2022, 350000, 7));
            sistemRekan.tambahKendaraan(new Motor("BE 2222 YY", "Yamaha NMAX", 2021, 150000, "Matic"));
            sistemRekan.tambahKendaraan(new SepedaListrik("BE 3333 ZZ", "Uwinfly D8P", 2023, 50000, 800));
        } catch (Exception e) {
            System.out.println("Gagal memuat data awal.");
        }

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Cari Kendaraan");
            System.out.println("4. Kelola Pelanggan");
            System.out.println("5. Peminjaman Sewa");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu (1-6): ");

            try {
                int pilihan = scanner.nextInt(); scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        System.out.println("\n-- Pilih Jenis Kendaraan --");
                        System.out.println("1. Mobil | 2. Motor | 3. Sepeda Listrik");
                        System.out.print("Pilih (1/2/3): ");
                        int jenis = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Plat Nomor: "); String plat = scanner.nextLine();
                        System.out.print("Merk: "); String merk = scanner.nextLine();
                        System.out.print("Tahun Keluaran: "); int tahun = scanner.nextInt(); 
                        System.out.print("Biaya Sewa: "); int biaya = scanner.nextInt(); scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Jumlah Kursi: ");
                            sistemRekan.tambahKendaraan(new Mobil(plat, merk, tahun, biaya, scanner.nextInt()));
                        } else if (jenis == 2) {
                            System.out.print("Transmisi: ");
                            sistemRekan.tambahKendaraan(new Motor(plat, merk, tahun, biaya, scanner.nextLine()));
                        } else if (jenis == 3) {
                            System.out.print("Baterai (Wh): ");
                            sistemRekan.tambahKendaraan(new SepedaListrik(plat, merk, tahun, biaya, scanner.nextInt()));
                        }
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Kendaraan di Garasi ---");
                        sistemRekan.lihatSemuaKendaraan();
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Kendaraan --");
                        System.out.print("Masukkan Merk: ");
                        try {
                            sistemRekan.cariKendaraan(scanner.nextLine());
                        } catch (KendaraanTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Pelanggan --");
                        System.out.println("1. Tambah Pelanggan | 2. Cari Pelanggan | 3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuP = scanner.nextInt(); scanner.nextLine();
                        
                        if (menuP == 1) {
                            System.out.print("NIK: "); String nik = scanner.nextLine();
                            System.out.print("Nama: "); String nama = scanner.nextLine();
                            sistemRekan.tambahPelanggan(new Pelanggan(nik, nama));
                        } else if (menuP == 2) {
                            System.out.print("NIK yg dicari: ");
                            sistemRekan.cariPelanggan(scanner.nextLine());
                        } else if (menuP == 3) {
                            sistemRekan.lihatSemuaPelanggan();
                        }
                        break;

                    case 5:
                        System.out.println("\n-- Sistem Peminjaman (Association) --");
                        System.out.print("Masukkan NIK Pelanggan: ");
                        Pelanggan p = sistemRekan.getPelanggan(scanner.nextLine());
                        
                        if (p == null) {
                            System.out.println("Gagal: Pelanggan belum terdaftar!");
                        } else if (sistemRekan.getJumlahKendaraan() == 0) {
                            System.out.println("Gagal: Garasi kosong.");
                        } else {
                            sistemRekan.lihatSemuaKendaraan();
                            System.out.print("Pilih Nomor Kendaraan yg disewa: ");
                            int noKendaraan = scanner.nextInt() - 1; scanner.nextLine();
                            
                            if (noKendaraan >= 0 && noKendaraan < sistemRekan.getJumlahKendaraan()) {
                                Kendaraan k = sistemRekan.getKendaraanInt(noKendaraan);
                                if (!k.getStatusDipinjam()) {
                                    System.out.print("Durasi sewa (hari): ");
                                    int durasi = scanner.nextInt(); scanner.nextLine();
                                    TransaksiSewa.prosesSewa(p, k, durasi);
                                } else {
                                    System.out.println("Kendaraan sedang dipinjam.");
                                }
                            } else {
                                System.out.println("Nomor tidak valid!");
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Terima kasih telah menggunakan sistem REKAN!");
                        isRunning = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Anda memasukkan format yang salah.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}