package com.mycompany.rekan;

import java.io.FileWriter;
import java.io.IOException;

public class TransaksiSewa {
    public static void prosesSewa(Pelanggan p, Kendaraan k, int durasi) {
        System.out.println("\n--- STRUK TRANSAKSI SEWA ---");
        System.out.println("Penyewa  : " + p.getNama() + " (NIK: " + p.getNik() + ")");
        System.out.println("Kendaraan: " + k.getMerk() + " (" + k.getPlatNomor() + ")");
        k.caraSewa();
        
        int total = k.getBiayaSewa() * durasi;
        k.setStatusDipinjam(true);
        
        System.out.println("Durasi   : " + durasi + " hari");
        System.out.println("Total    : Rp" + total);
        System.out.println("Status   : BERHASIL DICATAT SISTEM");
        System.out.println("----------------------------");
        
        try (FileWriter pipaTulis = new FileWriter("log_transaksi.txt", true)) {
            String log = "Penyewa: " + p.getNama() + " (" + p.getNik() +") | Kendaraan: " + k.getMerk() + " | Durasi: " + durasi + " hr | Total: Rp" + total + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {    
            System.out.println("Peringatan: Gagal mencatat  log transaksi. " + e.getMessage());
        }
    }
}
