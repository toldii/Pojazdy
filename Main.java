import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    // Lista przechowująca taksony
    static List<Vechicle> listVechicle = new ArrayList();
    public static Scanner scan = new Scanner(System.in);
    private static final String path="db.txt";

    public static void main(String[] args) throws IOException {
        while (true) {

            int ex = menu();
            switch (ex) {
                case 1:
                    exercise1();
                    break;
                case 2:
                    exercise2();
                    break;
                case 3:
                    exercise3();
                    break;
                default:
                    return;
            }
        }
    }

    public static int menu() {
        System.out.println("Wciśnij:");
        System.out.println("1 - aby dodać pojazd");
        System.out.println("2 - aby wypisać wszystkie pojazdy");
        System.out.println("3 - aby wyszukać pojazd po typie");
        System.out.println("0 - aby wyjść z programu");
        int wybor = scan.nextInt();

        if ((wybor < 0) || (wybor > 3)) {
            System.out.print("Wprowadz poprawne działanie\n");
            wybor=menu();
        }
        return wybor;
    }

    public static void exercise1() throws IOException {
        System.out.println("Wybierz typ pojazdu 1 - samochud 2 -motocykl: ");
        int typeTemp = scan.nextInt();
        String type = "";
        if (Integer.parseInt(String.valueOf(typeTemp)) == 1) {
            type = "samochod";
        } else if (Integer.parseInt(String.valueOf(typeTemp)) == 2) {
            type = "motocykl";
        } else {
            System.out.println("błędan liczba");
        }
        System.out.println("--");
        System.out.println("Podaj markę pojazdu:");
        String brand = scan.next();
        System.out.println("Podaj model pojazdu:");
        String model = scan.next();
        System.out.println("Podaj przebieg pojazdu:");
        int mileage = scan.nextInt();
        System.out.println("Podaj rok produkcji pojazdu:");
        int manufactureYear = scan.nextInt();
        System.out.println("Podaj kolor pojazdu:");
        String color = scan.next();

        if (!type.equals("") && !brand.equals("") && mileage >= 0 && manufactureYear >= 1900 && !color.equals("")) {
            addVechicle(new Vechicle(type,brand,model,mileage,manufactureYear,color));
            System.out.println("Zapisano!");
        }else{
            System.out.println("Błędne dane spróbuj ponownie \n");
            exercise1();
        }
    }
    public static void exercise2() throws IOException {
       listVechicle=getVechicle();
        System.out.println("typ,marka,model,przebiek,rok produkcji,kolor");
        for(Vechicle current : listVechicle) {
            System.out.println(current.toString());
        }
    }
    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj typ (samochod,motocykl): ");
        var name = scan.nextLine();
        if(!name.equals("")){
        List<Vechicle> findingType= findVehicleByType(name);
           if(!findingType.isEmpty()) {
               System.out.println("typ,marka,model,przebiek,rok produkcji,kolor");
               for(Vechicle current : findingType) {
                   System.out.println(current.toString());
               }
            }else {
               System.out.println("Nie znaleziono...");
           }
        }else {
            System.out.println("nie wpisałeś typu");
            exercise3();
        }
    }
    public static List<Vechicle> findVehicleByType(String type) throws IOException {
        if(listVechicle.isEmpty()){
            listVechicle=getVechicle();
        }
        List<Vechicle> vechiclesFind=new ArrayList<>();
        for(Vechicle current : listVechicle) {
            if(current.getType().equals(type)){
                vechiclesFind.add(current);
            }
        }
        if(!vechiclesFind.isEmpty()){
            return vechiclesFind;
        }else {
            return null;
        }

    }


    public static void addVechicle(Vechicle vechicle) throws IOException {
        var f = new FileWriter(path, true);
        var b = new BufferedWriter(f);
        b.append(vechicle.toString());
        b.newLine();
        b.close();
    }

    public static List<Vechicle> getVechicle() throws IOException {
        var ret = new ArrayList<Vechicle>();
        var f = new FileReader(path);
        var reader = new BufferedReader(f);
        String line = "";
        while (true) {
            line = reader.readLine();
            if (line == null)
                break;
            ret.add(Vechicle.Parse(line));
        }
        reader.close();
        return ret;
    }
}