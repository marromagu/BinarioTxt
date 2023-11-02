/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_ut2.ejercicios_ut2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM
 */
class A {

    private String nombre;
    private ArrayList<Integer> b;
    private ArrayList<Integer> c;

    public A(ArrayList<Integer> b, ArrayList<Integer> c, String nombre) {
        this.b = b;
        this.c = c;
        this.nombre = nombre;
    }

    public A(String Linea) {
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        Scanner sc = new Scanner(Linea).useDelimiter(";");
        this.nombre = sc.next();

        String textB = sc.next();
        if (textB == "[]") {
            this.b.add(0);
        } else {
            textB = textB.replace("[", "");
            textB = textB.replace("]", "");
            String[] arrayB = textB.split(", ");
            for (int i = 0; i < arrayB.length; i++) {
                this.b.add(Integer.parseInt(arrayB[i]));
            }
        }

        String textC = sc.next();
        if (textC == "[]") {
            this.c.add(0);
        } else {
            textC = textC.replace("[", "");
            textC = textC.replace("]", "");
            String[] arrayC = textC.split(", ");
            for (int i = 0; i < arrayC.length; i++) {
                this.c.add(Integer.parseInt(arrayC[i]));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(";").append(b);
        sb.append(";").append(c);
        return sb.toString();
    }

}
