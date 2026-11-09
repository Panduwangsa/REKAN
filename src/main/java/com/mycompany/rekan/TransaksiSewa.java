package com.mycompany.rekan;

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
    }
}
