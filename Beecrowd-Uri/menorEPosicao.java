/*
Faça um programa que leia um valor N. Este N será o tamanho de um vetor X[N]. A seguir, leia cada um dos valores de X,
encontre o menor elemento deste vetor e a sua posição dentro do vetor, mostrando esta informação.
*/

import java.io.IOException;
import java.util.Scanner;

public class menorEPosicao {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int n=input.nextInt(), lower, position;
        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = input.nextInt();
        }

        lower = numbers[1];
        position = 1;

        for(int i=0; i<n; i++){
            if(numbers[i]<lower){
                lower = numbers[i];
                position = i;
            }
        }
        System.out.printf("Menor valor: %d\n",lower);
        System.out.printf("Posicao: %d\n",position);
    }
}