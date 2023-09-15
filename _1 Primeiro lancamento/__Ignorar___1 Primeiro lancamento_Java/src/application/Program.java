package application;

import entities.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Cria quatro pontos;
        Ponto a = new Ponto(0, 0);
        Ponto b = new Ponto(10, 0);
        Ponto c = new Ponto(10, 10);
        Ponto d = new Ponto(0, 10);

        //Cria um quadrado
        Quadrilatero quadrilatero_abcd = new Quadrilatero(a, b, c, d);
        System.out.println(quadrilatero_abcd.area());

        //Cria uma reta
        Reta ac = new Reta(a, c);
        System.out.println(ac.comprimento());

        //Cria um triangulo retangulo
        Triangulo abc = new Triangulo(a, b, c);
        System.out.println(abc.area());

        Ponto e = new Ponto(-10, -10);
        //Cria um circulo com centro em (-10, -10)
        Circulo cO = new Circulo(e, scanner.nextDouble());
        System.out.println(cO.area());
        System.out.println(cO.quadrante());

        scanner.close();
    }
}