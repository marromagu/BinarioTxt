/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ejercicios_ut2.ejercicios_ut2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DAM
 */
public class Ejercicios_UT2 {

    public static void main(String[] args) {

        var lista = new ArrayList<A>();
        var m = new Ejercicios_UT2();
        lista.add(m.generarA("Pepe", 2, 7, 9, 12));
        lista.add(m.generarA("Juan", 0, 1, 5, 10));
        lista.add(m.generarA("Pablo Garcia", 4, 9, 0, 1));
        lista.add(m.generarA("Vacio", 0, 1, 0, 1));
        //Descomentar para ver tamaño de fichero texto y fichero binario
        //lista.add(m.generarA("Enorme", 100000, 200000, 100000, 200000));
        // m.EscribirTxt(lista);
        m.LeerTxt();
        // m.EscribirTxtBinario(lista);
        m.LeerTxtBinario();

    }

    private void LeerTxt() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("A.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                A miA = new A(linea);
                System.out.println(miA.toString());
            }
            br.close();
            //return lista;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //return null;
    }

    private void EscribirTxt(ArrayList<A> lista) {
        File archivo = null;
        FileWriter fr = null;
        BufferedWriter escritor = null;
        try {
            archivo = new File("A.txt");
            fr = new FileWriter(archivo);
            escritor = new BufferedWriter(fr);

            for (int i = 0; i < lista.size(); i++) {
                escritor.write(lista.get(i).toString() + "\n");

            }
            escritor.close();
        } catch (IOException e) {
        }

    }

    private void LeerTxtBinario() {
        FileInputStream archivo = null;
        DataInputStream leer = null;
        try {
            archivo = new FileInputStream("A_Binario.txt");
            leer = new DataInputStream(archivo);
            while (leer.available() > 0) {
             
            }

        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            try {
                leer.close();
            } catch (Exception e) {
                System.out.println("Error 2");
            }

        }
    }

    private void EscribirTxtBinario(ArrayList<A> lista) {
        FileOutputStream archivo = null;
        DataOutputStream escritor = null;
        try {
            archivo = new FileOutputStream("A_Binario.txt");
            escritor = new DataOutputStream(archivo);

            for (int i = 0; i < lista.size(); i++) {
                escritor.writeUTF(lista.get(i).getNombre());
                for (int j = 0; j < lista.get(i).getB().size(); j++) {
                    escritor.writeInt(lista.get(i).getB().get(j));
                }
                for (int j = 0; j < lista.get(i).getC().size(); j++) {
                    escritor.writeInt(lista.get(i).getC().get(j));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private A generarA(String nombre, int minimoB, int maximoB, int minimoC, int maximoC) {
        Random rn = new Random();
        int minValue = 147483647;
        int maxValue = 1147483647;
        var tamB = rn.nextInt(minimoB, maximoB);
        var tamC = rn.nextInt(minimoC, maximoC);
        ArrayList<Integer> b = new ArrayList<>(tamB);
        ArrayList<Integer> c = new ArrayList<>(tamC);

        for (int i = 0; i < tamB; i++) {
            b.add(rn.nextInt(minValue, maxValue));
        }
        for (int i = 0; i < tamC; i++) {
            c.add(rn.nextInt(minValue, maxValue));
        }

        return new A(b, c, nombre);
    }
}
