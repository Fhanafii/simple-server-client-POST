package com.fhanafi.simpleserver;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        //open socket
        Socket s = new Socket("localhost", 1234);
        PrintStream output = new PrintStream(s.getOutputStream());
        BufferedReader pesan = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Connected to Server");
        try {
            do {
                //menghitung Roti dan minuman
                int jumlahRoti;
                int jumlahMinuman;

                System.out.print("Jumlah Roti @5000: ");
                jumlahRoti = Integer.parseInt(pesan.readLine());

                System.out.print("Jumla Minuman @3000: ");
                jumlahMinuman = Integer.parseInt(pesan.readLine());
                int roti = 5000 * jumlahRoti;
                int minuman = 3000 * jumlahMinuman;
                int harga = roti + minuman;
                System.out.println("Total Harga: " + harga);
                output.println(harga);

                //untuk memberi user pilihan lanjut atau tidak
                System.out.print("Lanjutkan ? (ya/tidak): ");
                String response = pesan.readLine();
                if(response.equalsIgnoreCase("tidak")){
                    break;
                }
            }while (true);
        }finally {
            //menutup Client
            output.close();
            s.close();
        }
    }
}
