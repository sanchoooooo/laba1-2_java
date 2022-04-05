package firm;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите количество сотрудников =>");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера после ввода числа

        firm.Sotrudnik[] sotr = new firm.Sotrudnik[kol];// получена ссылка на массив сотрудников
        System.out.println("Введите информацию о каждом сотруднике: ");

        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new firm.Sotrudnik();
            // Присвоение значений полям
            System.out.print("Введите фамилию" + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();
            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();
            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();
            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();
            System.out.print("Введите его оклад => ");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine();// очистка буфера
        } // end for

        // Вывод информации о сотрудниках
        System.out.println("\n Сотрудники фирмы: \n фам \t имя \t отч  +\t должность \tОклад");


        for (firm.Sotrudnik s : sotr) {
            System.out.println(s.fam + "\t" + s.im + "\t" + s.otch
                    + "\t " + s.doljnost + "\t\t" + s.oklad);
        }
    }
}
