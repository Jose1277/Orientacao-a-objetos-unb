package application;

import entities.Ponto;
import entities.Triangulo;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ponto a = new Ponto(0, 0);
        Ponto b = new Ponto(10, 0);
        Ponto c = new Ponto(5, 10);

        Triangulo triangulo = new Triangulo(a, b, c);
        System.out.println(triangulo.area());

        scanner.close();
    }
}