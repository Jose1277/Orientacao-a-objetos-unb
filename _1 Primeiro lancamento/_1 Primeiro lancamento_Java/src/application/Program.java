package application;

import entities.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            Ponto a = new Ponto(scanner.nextInt(), scanner.nextInt());
            Ponto b = new Ponto(scanner.nextInt(), scanner.nextInt());
            Ponto c = new Ponto(scanner.nextInt(), scanner.nextInt());
            Ponto d = new Ponto(scanner.nextInt(), scanner.nextInt());

            Paralelepipedo paralelepipedo_abcd = new Paralelepipedo(a, b, c, d);
            System.out.println(paralelepipedo_abcd.area());

            Reta ac = new Reta(a, c);
            System.out.println(ac.comprimento());

            Triangulo abc = new Triangulo(a, b, c);
            System.out.println(abc.area());

            Circulo cO = new Circulo(c, scanner.nextDouble());
            System.out.println(cO.area());

        scanner.close();
    }
}