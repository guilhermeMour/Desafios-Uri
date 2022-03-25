/*
Faça um algoritmo para ler um número indeterminado de dados, contendo cada um, a idade de um indivíduo. 
O último dado, que não entrará nos cálculos, contém o valor de idade negativa. 
Calcular e imprimir a idade média deste grupo de indivíduos.
*/

import java.util.Scanner;
public class idades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int idade, total=0, i=1;
        double contagem=0.00;
        
        while(i == 1) {
        	idade = input.nextInt();
        	if(idade<0) {
        		i = 0;
        	} else {
        		total = total + idade;
        		contagem++;
        	}
        }
        System.out.printf("%.2f\n", total/contagem);
    }
}