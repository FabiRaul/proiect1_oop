    package Proiecte_lab;

    import java.util.Scanner;
    import java.util.ArrayList;
    import java.util.List;

    public class Main {

        static List<Elev> lista_Elevi = new ArrayList<>();
        static List<Sala> lista_sali = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Elev elev = new Elev();
            Sala sala = new Sala();

            int optiune;
            optiune = 1;

            while (optiune != 0) {
                System.out.println("---------- APLICATIE STUDENTI & SALI ----------");
                System.out.println("--- (1) --- Adauga elev --- (1) ---");
                System.out.println("--- (2) --- Creeaza sala --- (2) ---");
                System.out.println("--- (3) --- Adauga elev intr-o sala --- (3) ---");
                System.out.println("--- (4) --- Afiseaza toti elevii --- (4) ---");
                System.out.println("--- (5) --- Afiseaza toate salile --- (5) ---");
                System.out.println("--- (6) --- Afiseaza elevii unei sali --- (6) ---");
                System.out.println("--- (7) --- Cauta elev dupa ID --- (7) ---");
                System.out.println("--- (8) --- Muta elev dintr-o sala in alta --- (8) ---");
                System.out.println("--- (9) --- Sterge elev --- (9) ---");
                System.out.println("--- (10) --- Sterge sala --- (10) ---");
                System.out.println("--- (11) --- Filtreaza elevii promovati --- (11) ---");
                System.out.println("--- (12) --- Filtreaza elevii nepromovati --- (12) ---");
                System.out.println("--- (13) --- Filtreaza elevii dupa interval de medie --- (13) ---");
                System.out.println("--- (14) --- Filtreaza elevii dupa varsta --- (14) ---");
                System.out.println("--- (15) --- Cauta elevi dupa nume --- (15) ---");
                System.out.println("--- (16) --- Afiseaza statistici(la alegerea studentului) --- (16) ---");
                System.out.println("--- (17) --- Sorteaza elevii --- (17) ---");
                System.out.println("--- (0) ---EXIT --- (0) ---");

                System.out.println("---------- INTRODUCETI O OPTIUNE ----------");
                optiune = sc.nextInt();

                switch (optiune) {
                    case 1:
                        System.out.print("Nume elev: ");
                        sc.nextLine();
                        String nume = sc.nextLine();
                        System.out.print("Varsta: ");
                        int varsta = sc.nextInt();
                        System.out.print("Medie: ");
                        float medie = sc.nextFloat();

                        Elev elevNou = new Elev(Elev.sequence++, nume, varsta, medie);
                        lista_Elevi.add(elevNou);
                        System.out.println("Elevul a fost adaugat cu succes!");
                        break;
                    case 2:
                        System.out.print("Numar sala: ");
                        int nrSala = sc.nextInt();
                        System.out.print("Denumire sala: ");
                        sc.nextLine();
                        String denumire = sc.nextLine();
                        System.out.print("Capacitate sala: ");
                        int capacitate = sc.nextInt();

                        Sala salaNoua = new Sala(nrSala, denumire, capacitate);
                        lista_sali.add(salaNoua);
                        System.out.println("Sala a fost creata cu succes!");
                        break;
                    case 3:
                        System.out.print("ID-ul elevului: ");
                        int idElev = sc.nextInt();
                        System.out.print("Numarul salii: ");
                        int nrSalaAdaugare = sc.nextInt();

                        Elev elevGasit = Elev.cauta_dupa_id(lista_Elevi, idElev);
                        Sala salaGasita = null;
                        for (Sala s : lista_sali) {
                            if (s.get_numarSala() == nrSalaAdaugare) salaGasita = s;
                        }

                        if (elevGasit != null && salaGasita != null) {
                            salaGasita.adaugare_elev(elevGasit);
                            System.out.println("Elev adaugat in sala!");
                        } else {
                            System.out.println("Elevul sau sala nu a fost gasita!");
                        }
                        break;
                    case 4:
                        System.out.println("--- Toti Elevii ---");
                        for (Elev e : lista_Elevi) {
                            System.out.println(e.toString());
                        }
                        break;
                    case 5:
                        System.out.println("--- Toate Salile ---");
                        for (Sala s : lista_sali) {
                            System.out.println(s.toString());
                        }
                        break;
                    case 6:
                        System.out.print("Numarul salii: ");
                        int nrSalaCautata = sc.nextInt();
                        boolean salaExista = false;

                        for (Sala s : lista_sali) {
                            if (s.get_numarSala() == nrSalaCautata) {
                                System.out.println("Elevii din sala " + s.get_denumire() + ":");
                                for (Elev e : s.get_listaElevi()) {
                                    System.out.println(e.toString());
                                }
                                salaExista = true;
                                break;
                            }
                        }
                        if (!salaExista) System.out.println("Sala nu a fost gasita!");
                        break;
                    case 7:
                        System.out.print("Introduceti ID-ul: ");
                        int idCautat = sc.nextInt();
                        Elev e = Elev.cauta_dupa_id(lista_Elevi, idCautat);
                        if (e != null) {
                            System.out.println("Elev gasit: " + e.toString());
                        } else {
                            System.out.println("Elevul cu ID-ul " + idCautat + " nu exista!");
                        }
                        break;
                    case 8:
                        System.out.print("Numar sala curenta: ");
                        int nrSalaSursa = sc.nextInt();
                        System.out.print("Numar sala destinatie: ");
                        int nrSalaDest = sc.nextInt();
                        System.out.print("ID elev de mutat: ");
                        int idElevMutat = sc.nextInt();

                        Sala salaSursa = null;
                        Sala salaDest = null;
                        Elev elevDeMutat = Elev.cauta_dupa_id(lista_Elevi, idElevMutat);

                        for (Sala s : lista_sali) {
                            if (s.get_numarSala() == nrSalaSursa) salaSursa = s;
                            if (s.get_numarSala() == nrSalaDest) salaDest = s;
                        }

                        if (salaSursa != null && salaDest != null && elevDeMutat != null) {
                            salaSursa.muta_elev(salaDest, elevDeMutat);
                            System.out.println("Mutare procesata.");
                        } else {
                            System.out.println("Date invalide pentru mutare!");
                        }
                        break;
                    case 9:
                        System.out.print("ID elev de sters: ");
                        int idStergere = sc.nextInt();
                        Elev elevDeSters = Elev.cauta_dupa_id(lista_Elevi, idStergere);

                        if (elevDeSters != null) {
                            for (Sala s : lista_sali) {
                                if (s.get_listaElevi().contains(elevDeSters)) {
                                    s.sterge_elev(elevDeSters);
                                }
                            }
                            lista_Elevi.remove(elevDeSters);
                            System.out.println("Elev sters cu succes!");
                        } else {
                            System.out.println("Elevul nu a fost gasit!");
                        }
                        break;
                    case 10:
                        System.out.print("Numar sala de sters: ");
                        int nrSalaStergere = sc.nextInt();
                        Sala salaDeSters = null;

                        for (Sala s : lista_sali) {
                            if (s.get_numarSala() == nrSalaStergere) {
                                salaDeSters = s;
                                break;
                            }
                        }

                        if (salaDeSters != null) {
                            lista_sali.remove(salaDeSters);
                            System.out.println("Sala a fost stearsa!");
                        } else {
                            System.out.println("Sala nu a fost gasita!");
                        }
                        break;
                    case 11:
                        Elev.afiseaza_promovati(lista_Elevi);
                        break;
                    case 12:
                        Elev.afiseaza_nepromovati(lista_Elevi);
                        break;
                    case 13:
                        System.out.print("Medie minima: ");
                        float min = sc.nextFloat();
                        System.out.print("Medie maxima: ");
                        float max = sc.nextFloat();
                        Elev.filtreaza_interval_medie(lista_Elevi, min, max);
                        break;
                    case 14:
                        System.out.print("Varsta cautata: ");
                        int v = sc.nextInt();
                        Elev.filtreaza_dupa_varsta(lista_Elevi, v);
                        break;
                    case 15:
                        System.out.print("Numele (sau o parte din el): ");
                        String numee= sc.nextLine();
                        Elev.cauta_dupa_nume(lista_Elevi, numee);
                        break;
                    case 16:
                        Elev.afiseaza_statistici(lista_Elevi);
                        break;
                    case 17:
                        Elev.sorteaza_elevi(lista_Elevi);
                        break;
                    case 0:
                        System.out.println("Aplicatia s-a inchis!");
                        break;
                    default:
                        System.out.println("Optiune invalida! Introduceti un numar intre 0 si 17.");
                        break;
                }

            }
        }
    }




