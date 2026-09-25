package Proiecte_lab;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private int numarSala;
    private String denumire;
    private int capacitate;
    private List<Elev> lista_elevi;

    public Sala(){
        this.lista_elevi = new ArrayList<>();
    }

    public Sala(int numarSala, String denumire, int capacitate){
        this.lista_elevi = new ArrayList<>();
        set_numarSala(numarSala);
        set_denumire(denumire);
        set_capacitate(capacitate);
    }


    public Sala(int numarSala, String denumire, int capacitate, List<Elev> lista_elevi){
        set_numarSala(numarSala);
        set_denumire(denumire);
        set_capacitate(capacitate);

        if(lista_elevi != null && lista_elevi.size() > capacitate){
            System.out.println("Lista de elevi este prea mare, peste capacitatea salii! Capacitatea salii este: " + capacitate);
        } else {
            this.lista_elevi = (lista_elevi != null) ? new ArrayList<>(lista_elevi) : new ArrayList<>();
        }
    }

    public int get_numarSala(){
        return numarSala;
    }

    public void set_numarSala(int numarSala){
        if(numarSala < 0){
            System.out.println("Numarul salii trebuie sa fie pozitiv!");
        } else {
            this.numarSala = numarSala;
        }
    }

    public String get_denumire(){
        return denumire;
    }

    public void set_denumire(String denumire){
        if(denumire == null || denumire.isEmpty()){
            System.out.println("Denumirea nu corespunde(nu trebuie sa fie goala sau null)");
        } else {
            this.denumire = denumire;
        }
    }

    public int get_capacitate(){
        return capacitate;
    }

    public void set_capacitate(int capacitate){
        if(capacitate < 0){
            System.out.println("Capacitatea salii trebuie sa fie mai mare decat 0!");
        } else{
            this.capacitate = capacitate;
        }
    }

    public List<Elev> get_listaElevi() {
        return lista_elevi;
    }


    public void adaugare_elev(Elev elev){
        if(this.lista_elevi.size() >= this.capacitate){
            System.out.println("Sala" + denumire + " a atins capacitatea maxima!");
        } else if (this.lista_elevi.contains(elev)){
            System.out.println("Elevul este deja in aceasta sala!");
        } else {
            this.lista_elevi.add(elev);
        }
    }

    public void sterge_elev(Elev elev){
        if(!this.lista_elevi.contains(elev)){
            System.out.println("Elevul nu a fost gasit in aceasta sala!");
        } else {
            this.lista_elevi.remove(elev);
        }
    }

    public void muta_elev(Sala sala2, Elev elev){
        if(!this.lista_elevi.contains(elev)){
            System.out.println("Elevul pe care doriti sa il mutati nu este in aceasta sala!");
        } else {
            sala2.adaugare_elev(elev);
            this.sterge_elev(elev);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala[Numar: ").append(numarSala)
                .append(", Denumire: '").append(denumire).append("'")
                .append(", Capacitate: ").append(capacitate)
                .append(", Ocupat: ").append(lista_elevi.size()).append(" locuri]\n");

        if (lista_elevi.isEmpty()) {
            sb.append("   -> Sala este goala.");
        } else {
            for (Elev e : lista_elevi) {
                sb.append("   -> ").append(e.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
