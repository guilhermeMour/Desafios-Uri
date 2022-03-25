/*
Dois times, Cormengo e Flaminthians, participam de um campeonato de futebol, juntamente com outros times. 
Cada vitória conta três pontos, cada empate um ponto. Fica melhor classificado no campeonato um time que tenha mais pontos. 
Em caso de empate no número de pontos, fica melhor classificado o time que tiver maior saldo de gols. Se o número de pontos 
e o saldo de gols forem os mesmos para os dois times então os dois times estão empatados no campeonato.
*/
import java.util.Scanner;
public class campeonato {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int vitoriaC = input.nextInt(), empateC = input.nextInt(), saldoC = input.nextInt();
        int vitoriaF = input.nextInt(), empateF = input.nextInt(), saldoF = input.nextInt();

        Campeonato teste = new Campeonato();
        teste.classificatorias(vitoriaC,empateC,saldoC,vitoriaF,empateF,saldoF);
        System.out.println(teste.getResultado());
    }
}

class Campeonato {
    Time cormengo = new Time();
    Time flaminthians = new Time();
    private char resultado;
    private int pontosC,pontosF;

    public void classificatorias(int vitoriaC, int empateC, int saldoC, int vitoriaF, int empateF, int saldoF){
        cormengo.setNome("Cormengo");
        cormengo.setVitorias(vitoriaC);
        cormengo.setEmpates(empateC);
        cormengo.setSaldoGols(saldoC);
        pontosC = (vitoriaC*3)+empateC;

        flaminthians.setNome("Flaminthians");
        flaminthians.setVitorias(vitoriaF);
        flaminthians.setEmpates(empateF);
        flaminthians.setSaldoGols(saldoF);
        pontosF = (vitoriaF*3)+empateF;

        if(pontosC > pontosF){
            resultado = 'C';
        }else if(pontosC < pontosF){
            resultado = 'F';
        }else if(pontosC == pontosF){
            if(saldoC > saldoF){
                resultado = 'C';
            }else if(saldoC < saldoF){
                resultado = 'F';
            }else if(saldoC == saldoF){
                resultado = '=';
            }
        }
    }
    //Setter
    public void setPontosC(int pontosC) {
        this.pontosC = pontosC;
    }

    public void setPontosF(int pontosF) {
        this.pontosF = pontosF;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    //Getters
    public int getPontosC() {
        return pontosC;
    }

    public int getPontosF() {
        return pontosF;
    }

    public char getResultado() {
        return resultado;
    }
}
class Time {
    private String nome = "";
    private int vitorias;
    private int empates;
    private int saldoGols;


    //Setters
    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    //Getters
    public int getEmpates() {
        return empates;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public int getVitorias() {
        return vitorias;
    }

    public String getNome() {
        return nome;
    }
}