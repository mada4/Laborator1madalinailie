package Laborator4.ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import static java.lang.System.exit;

/**
 * @author Ilie Maria-Madalina
 * @version 1
 * @since 2024
 */
public class exercitiu1 {
    /**
     * Metoda statica pentru serializare
     * @param o - Obiectul de serializat
     * @param fis - fisierul cu extensia ".bin" in care se scrie obiectul
     */
    public static void scrie(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda statica pentru deserializare
     * @param fis - fisierul cu extensia ".bin" din care se citeste obiectul
     * @return obiectele deserializare
     */
    static Object citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<EchipamenteElectronice> echipamenteElectronice = new ArrayList<EchipamenteElectronice>();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(new File("src/Laborator4/ex1/echipamente"));
        String[] data;

        while (scanner1.hasNext()) {
            data = scanner1.nextLine().split(";");

            String denumire = data[0];
            int nr_inv = Integer.parseInt(data[1]);
            double pret = Double.parseDouble(data[2]);
            String zona_mag = data[3];
            Situatie situatie = Situatie.valueOf(data[4]);
            String tip = data[5];
            if (tip.equals("imprimanta")) {
                int ppm = Integer.parseInt(data[6]);
                String dpi = data[7];
                int p_Car = Integer.parseInt(data[8]);
                ModTiparire modTiparire = ModTiparire.valueOf(data[9]);
                Imprimanta imprimanta = new Imprimanta(denumire, nr_inv, pret, zona_mag, situatie, tip, ppm, dpi, p_Car, modTiparire);
                echipamenteElectronice.add((EchipamenteElectronice) imprimanta);
            }
            if (tip.equals("copiator")) {
                int pTon = Integer.parseInt(data[6]);
                FormatCopiere formatCopiere = FormatCopiere.valueOf(data[7]);
                Copiatoare cop = new Copiatoare(denumire, nr_inv, pret, zona_mag, situatie, tip, pTon, formatCopiere);
                echipamenteElectronice.add((EchipamenteElectronice) cop);
            }
            if (tip.equals("sistem de calcul")) {
                String tip_mon = data[6];
                double vit_proc = Double.parseDouble(data[7]);
                int c_hdd = Integer.parseInt(data[8]);
                SistemOperare sistemOperare = SistemOperare.valueOf(data[9]);
                SistemeCalcul sc = new SistemeCalcul(denumire, nr_inv, pret, zona_mag, situatie, tip, tip_mon, vit_proc, c_hdd, sistemOperare);
                echipamenteElectronice.add((EchipamenteElectronice) sc);
            }
        }
        String denum;
        Scanner scanner2 = new Scanner(System.in);
        String fis = "src/Laborator4/ex1/echipamente_serializate.bin";
        int opt;
        System.out.println("\nMeniu:");
        System.out.println("1. Afișarea tuturor echipamentelor");
        System.out.println("2. Afișarea imprimantelor");
        System.out.println("3. Afișarea copiatoarelor");
        System.out.println("4. Afișarea sistemelor de calcul");
        System.out.println("5. Modificarea stării în care se află un echipament ");
        System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimantă");
        System.out.println("7. Setarea unui format de copiere pentru copiatoare ");
        System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul");
        System.out.println("9. Afișarea echipamentelor vândute");
        System.out.println("10. Serializare");
        System.out.println("11. Deserializare");
        System.out.println("0. Ieșire");
        do {
            System.out.print("Introduceti optiunea dorita: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 0:
                    exit(0);
                    break;
                case 1:
                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                case 2:
                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == Imprimanta.class)
                            System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                case 3:
                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == Copiatoare.class)
                            System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                case 4:
                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == SistemeCalcul.class)
                            System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                case 5:
                    String stare_aux;
                    System.out.print("Introduceti denumirea echipamentului: ");
                    denum = scanner2.nextLine();
                    System.out.print("Introduceti starea: ");
                    stare_aux = scanner2.nextLine();

                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getDenumire().equals(denum)) {
                            e.setSit(Situatie.valueOf(stare_aux));
                            System.out.println(e.toString());
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    String mod_aux;
                    System.out.print("Introduceti denumirea: ");
                    denum = scanner2.nextLine();
                    System.out.print("Introduceti modul: ");
                    mod_aux = scanner2.nextLine();

                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == Imprimanta.class)
                            if (e.getDenumire().equals(denum)) {
                                ((Imprimanta) e).setModTiparire(ModTiparire.valueOf(mod_aux));
                                System.out.println(e.toString());
                            }
                    }
                    System.out.println();
                    break;
                case 7:
                    String form;
                    System.out.print("Introduceti denumirea: ");
                    denum = scanner2.nextLine();
                    System.out.print("Introduceti formatul: ");
                    form = scanner2.nextLine();

                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == Copiatoare.class)
                            if (e.getDenumire().equals(denum)) {
                                ((Copiatoare) e).setFormatCopiere(FormatCopiere.valueOf(form));
                                System.out.println(e.toString());
                            }
                    }
                    System.out.println();
                    break;
                case 8:
                    String sist;
                    System.out.print("Introduceti denumirea: ");
                    denum = scanner2.nextLine();
                    System.out.print("Introduceti sistemul de operare: ");
                    sist = scanner2.nextLine();

                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getClass() == SistemeCalcul.class)
                            if (e.getDenumire().equals(denum)) {
                                ((SistemeCalcul) e).setSistemOperare(SistemOperare.valueOf(sist));
                                System.out.println(e.toString());
                            }
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Produse vandute:");
                    for (EchipamenteElectronice e : echipamenteElectronice) {
                        if (e.getSit().toString().equals("vandut"))
                            System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                case 10:
                    scrie(echipamenteElectronice, fis);
                    System.out.println("Obiectele au fost serializate!\n");
                    break;
                case 11:
                    List<EchipamenteElectronice> echipamente_deserializate = new ArrayList<>();
                    echipamente_deserializate = (List<EchipamenteElectronice>) citeste(fis);
                    System.out.println("Echipamentele deserializate:");
                    for (EchipamenteElectronice e : echipamente_deserializate) {
                        System.out.println(e.toString());
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
        } while (opt != 0);
    }
}