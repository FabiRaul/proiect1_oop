package Proiecte_lab;

import java.util.List;
import java.util.ArrayList;

public class Elev {

    public static int sequence = 0;

    private int id;
    private String nume;
    private int age;
    private float medie;

    public Elev(int id, String nume) {
        this.id = id;
        set_nume(nume);
    }

    public Elev(int id, String nume, int age, float medie){
        this.id = id;
        set_nume(nume);
        set_age(age);
        set_medie(medie);
    }

    public Elev(){
        this.id=sequence;
        sequence++;
    }

    public int get_id(){
        return id;
    }

    public String get_nume(){
        return nume;
    }

    public void set_nume(String nume){
        if(nume == null || nume.isEmpty()){
            System.out.println("Numele introdus nu indeplineste cerintele(nu poate fi nul sii nu poate fi gol)!");
        } else {
            this.nume = nume;
        }
    }

    public int get_age(){
        return age;
    }

    public void set_age(int age){
        if(age < 0){
            System.out.println("Varsta introdusa nu indeplineste cerintele(trebuie sa fie pozitiva)!");
        } else if(age < 18 || age >50){
            System.out.println("Varsta introdusa nu indeplineste cerintele(trebuie sa fie in intervalul [19 , 49])!");
        } else {
            this.age = age;
        }
    }

    public float get_medie(){
        return medie;
    }

    public void set_medie(float medie){
        if(medie < 1 || medie > 10){
            System.out.println("Media este invalida! (trebuie sa fie in intervalul [1 , 10])");
        } else {
            this.medie = medie;
        }
    }

    public boolean promovat(){
        return this.medie>=5;
    }

    public void promovare() {
        if (promovat()) {
            System.out.println("Studentul " + nume + " este promovat, cu media " + medie);
        } else {
            System.out.println("Studentul " + nume + " nu este promovat!");
        }
    }

    @Override
    public String toString() {
        return "Elev[ID: " + id + ", Nume: " + nume + ", Varsta: " + age + ", Medie: " + medie + "]";
    }

    public static Elev cauta_dupa_id(List<Elev> lista, int idCautat) {
        for (Elev e : lista) {
            if (e.get_id() == idCautat){
                return e;
            }
        }
        return null;
    }

    public static void afiseaza_promovati(List<Elev> lista) {
        System.out.println("--- Elevi Promovati ---");
        for (Elev e : lista) {
            if (e.get_medie() >= 5.0f) System.out.println(e.toString());
        }
    }

    public static void afiseaza_nepromovati(List<Elev> lista) {
        System.out.println("--- Elevi Nepromovati ---");
        for (Elev e : lista) {
            if (e.get_medie() < 5.0f) System.out.println(e.toString());
        }
    }

    public static void filtreaza_interval_medie(List<Elev> lista, float min, float max) {
        System.out.println("--- Elevi cu media intre " + min + " si " + max + " ---");
        for (Elev e : lista) {
            if (e.get_medie() >= min && e.get_medie() <= max) {
                System.out.println(e.toString());
            }
        }
    }

    public static void filtreaza_dupa_varsta(List<Elev> lista, int varsta) {
        System.out.println("--- Elevi cu varsta de " + varsta + " ani ---");
        for (Elev e : lista) {
            if (e.get_age() == varsta) System.out.println(e.toString());
        }
    }

    public static void cauta_dupa_nume(List<Elev> lista, String fragment) {
        System.out.println("--- Rezultate cautare dupa: " + fragment + " ---");
        for (Elev e : lista) {
            if (e.get_nume().toLowerCase().contains(fragment.toLowerCase())) {
                System.out.println(e.toString());
            }
        }
    }

    public static void afiseaza_statistici(List<Elev> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nu exista elevi pentru statistici.");
            return;
        }
        float suma = 0, max = 0, min = 10;
        for (Elev e : lista) {
            suma += e.get_medie();
            if (e.get_medie() > max) max = e.get_medie();
            if (e.get_medie() < min) min = e.get_medie();
        }
        System.out.println("--- Statistici Sistem ---");
        System.out.println("Total elevi: " + lista.size());
        System.out.println("Media generala: " + (suma / lista.size()));
        System.out.println("Cea mai mare medie: " + max);
        System.out.println("Cea mai mica medie: " + min);
    }

    public static void sorteaza_elevi(List<Elev> lista) {
        lista.sort((e1, e2) -> Float.compare(e2.get_medie(), e1.get_medie()));
        System.out.println("Elevii au fost sortati descrescator dupa medie!");
    }

}
