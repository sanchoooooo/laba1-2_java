package RecordMountain;

import java.util.Scanner;


public class RecordMountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        //ENTER COUNTRY INFORMATION
        System.out.println("Enter the number of mountains => ");
        int n = sc.nextInt();
        Mountain mount[] = new Mountain[n];
        System.out.println("Enter mountain information:");
        for (int i = 0; i < mount.length; i++) {
            sc.nextLine(); // очистка буфера
            mount[i] = new Mountain();
            System.out.print("Name of " + (i + 1) + "  mountain =>");
            mount[i].name = sc.nextLine();
            System.out.print("Height " + (i + 1) + " mountain =>");
            mount[i].height = sc.nextDouble();
        }

        // OUTPUT OF THE INFORMATION RECEIVED
        System.out.println("\nMountain characteristics:");
        for (int i = 0; i < mount.length; i++) {

            System.out.println("" + mount[i].name + "\t" + mount[i].height + " м");
        }

        // Mountain with maximum height
        int nommax = 0;
        double max = mount[nommax].height;
        for (int i = 0; i < mount.length; i++)
            if (mount[i].height > max) {
                max = mount[i].height;
                nommax = i;
            }

        System.out.println("\nMountain with maximum  height:");
        System.out.println("" + mount[nommax].name + "\t" + mount[nommax].height + " м");


        //Mountains larger than 1000
        double s=1000;
        for (int i = 0; i < mount.length; i++) {
            if (mount[i].height > s)
                System.out.println("\nMountain with  height more than 1000:");
            System.out.println(mount[i].name + "\t" + mount[i].height + " м");
        }


        // SORT COUNTRIES BY AREA
        for (int i = 0; i < mount.length - 1; i++)
            for (int j = 0; j < mount.length - i - 1; j++)
                if (mount[j].name.compareTo(mount[i + 1].name) > 0) {
                    Mountain rab = mount[j];
                    mount[j] = mount[j + 1];
                    mount[j + 1] = rab;
                }
        System.out.println("\nSorted list by title: ");

        // SEARCH BY NAME
        sc.nextLine();
        System.out.println("Enter the name of the mountain you are looking for => ");
        String name = sc.nextLine();
        int nom = -1;
        for (
                int i = 0;
                i < mount.length; i++)
            if (name.equalsIgnoreCase(mount[i].name)) nom = i;
        if (nom != -1) {
            System.out.println("Such a mountain is on the list. This : " + mount[nom].name + ""
                    + mount[nom].height + " m ");
        } else System.out.println("This mountain is not listed");
    }
}
