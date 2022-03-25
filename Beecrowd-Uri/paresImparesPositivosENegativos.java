/*
Leia 5 valores Inteiros. A seguir mostre quantos valores digitados foram pares, quantos valores digitados foram ímpares, 
quantos valores digitados foram positivos e quantos valores digitados foram negativos.
*/

import java.util.Scanner;
public class paresImparesPositivosENegativos {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int i = 0, numero=0, par=0, impar=0, positivo=0, negativo=0;

        while(i<5){
            i++;
            numero = input.nextInt();

            if(numero%2 == 0){
                par++;
            }
            if(numero%2 != 0){
                impar++;
            }

            if(numero > 1){
                positivo++;
            }
            if(numero < 0){
                negativo++;
            }
        }
        System.out.println(par + " valor(es) par(es)");
        System.out.println(impar + " valor(es) impar(es)");
        System.out.println(positivo + " valor(es) positivo(s)");
        System.out.println(negativo + " valor(es) negativo(s)");

    }
}