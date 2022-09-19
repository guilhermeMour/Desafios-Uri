
/*
Depois de capturar muitos Pomekons, Dabriel e Guarte resolveram batalhar. A forma de duelo é simples, cada treinador coloca um 
Pomekon na batalha e vence quem tem o Pomekon com maior valor de golpe, que é definido da seguinte maneira: 

valorGolpe = (ataque+defesa)/2 + bonus

O Bônus será dado ao Pomekon do treinador que estiver em um level de valor par.
*/


import java.util.Scanner;
public class pomekon {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Treinador dabriel = new Treinador();
        Treinador guarte =  new Treinador();
        Batalha batalha = new Batalha();

        int ataque, defesa, nivel, bonus, lutas = input.nextInt();

        for(int i = 0; i < lutas; i++){
            bonus = input.nextInt();

            //Dabriel:
            ataque = input.nextInt();
            defesa = input.nextInt();
            nivel = input.nextInt();

            dabriel.setNivel(nivel);
            dabriel.pomekon.atacar(ataque, defesa);

            //Guarte:
            ataque = input.nextInt();
            defesa = input.nextInt();
            nivel = input.nextInt();

            guarte.setNivel(nivel);
            guarte.pomekon.atacar(ataque, defesa);

            //Batalha:
            batalha.luta(dabriel, guarte, bonus);
            System.out.println(batalha.getVencedor());
        }
    }
}
class Batalha {
    private int bonus;
    private String vencedor;

    public void luta(Treinador a, Treinador b, int bonus){
        this.bonus = bonus;
        if(a.getNivel() % 2 == 0 && b.getNivel() % 2 != 0){
            if(a.pomekon.getDano()+bonus > b.pomekon.getDano()){
                this.vencedor = "Dabriel";
            }else if(a.pomekon.getDano()+bonus < b.pomekon.getDano()){
                this.vencedor = "Guarte";
            }else{
                this.vencedor = "Empate";
            }
        }else if(b.getNivel() % 2 == 0 && a.getNivel() % 2 != 0){
            if(a.pomekon.getDano() > b.pomekon.getDano()+bonus){
                this.vencedor = "Dabriel";
            }else if(a.pomekon.getDano() < b.pomekon.getDano()+bonus){
                this.vencedor = "Guarte";
            }else{
                this.vencedor = "Empate";
            }
        }else{
            if(a.pomekon.getDano() > b.pomekon.getDano()){
                this.vencedor = "Dabriel";
            }else if(a.pomekon.getDano() < b.pomekon.getDano()){
                this.vencedor = "Guarte";
            }else{
                this.vencedor = "Empate";
            }
        }
    }
    //Setter
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    //Getters
    public String getBonus() {
        return vencedor;
    }

    public String getVencedor() {
        return vencedor;
    }
}
class Pomekon {
    private int ataque;
    private int defesa;
    private int dano;

    public void atacar(int ataque, int defesa){
        this.ataque = ataque;
        this.defesa = defesa;
        this.dano = (this.ataque + this.defesa)/2;
    }

    //Setters
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    //Getters
    public int getDefesa() {
        return defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDano() {
        return dano;
    }
}
class Treinador {
    private int nivel;
    private String nome;
    public Pomekon pomekon = new Pomekon();

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    //Getter
    public int getNivel() {
        return nivel;
    }
}

//prova do gilson de lista
public class LinkedList {
    class Node {
        Object element = null;
        Node next;
        Node previous;
    }
    Node head = null;
    Node tail = null;
    int count = 0;

    public void add(Object element) {
        Node newNode = new Node();
        newNode.element = element;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        count++;
    }

    public void add(Object element, int index) {
        Node newNode = new Node();
        newNode.element = element;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == count) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node aux = head;

            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
            newNode.next = aux.next;
            aux.next = newNode;
        }
    }

    public void remove(Object element) {
        Node aux = head;

        for (int i = 0; i < count; i++) {
            if(aux.element.equals(element)) {
                if (i == 0) {
                    head = null;
                    count--;

                    break;
                } else if(i == count-1) {
                    aux.previous = tail.previous;

                    tail = aux;
                    aux.next = null;
                    count--;

                    break;
                } else {
                    aux.previous.next = aux.next;
                }
                aux = aux.next;
            }
        }
    }

    public int size() {
        return count;
    }

    public Node get(int index) {
        int aux = 0;
        Node auxElement = head;

        for (int i = 0; i < count; i++) {
            if(aux == index) {
                return auxElement;
            }
            auxElement = auxElement.next;
            aux++;
        }

        return null;
    }

    public int indexOf(Object element) {
        Node aux = head;
        int index = 0;

        while(aux != null) {
            if (aux.element == element) {
                return index;
            }
            index++;
            aux = aux.next;
        }
        return -1;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}
