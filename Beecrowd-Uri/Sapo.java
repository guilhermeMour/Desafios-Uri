import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Sapo sapo = new Sapo();
        Canos canos = new Canos();

        List<Integer> lista = new ArrayList<Integer>();

        int alturaPulo = input.nextInt(), quantidadeCanos = input.nextInt(), alturaCano;
        boolean flag = false;


        sapo.setPulo(alturaPulo);
        canos.setQuantidade(quantidadeCanos);

        for (int i = 0; i < canos.getQuantidade(); i++) {
            alturaCano = input.nextInt();
            lista.add(alturaCano);
        }

        for (int i = 0; i < canos.getQuantidade()-1; i++) {
            if(sapo.getPulo()+lista.get(i) < lista.get(i+1) || (lista.get(i) - lista.get(i+1)) > sapo.getPulo() || (lista.get(i) - lista.get(i+1))*-1 > sapo.getPulo()){
                flag = true;
            }
        }
        if(!flag)
            System.out.println("YOU WIN");
        else
            System.out.println("GAME OVER");
    }

}


class Sapo {
    private int pulo;

    public void setPulo(int pulo) {
        this.pulo = pulo;
    }

    public int getPulo() {
        return pulo;
    }
}
class Canos {
    private int quantidade;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
