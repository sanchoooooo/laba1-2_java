package RecordMountain2;

import java.util.Scanner;

public class RecordMountain2 {

    // METHODS FOR ALL SUBTASKS for working with objects of class Mountain
    public static Mountain[] setMountainArr(int k){
        Scanner sc=new Scanner(System.in,"cp1251");
        Mountain mount[]=new Mountain[k];
        System.out.println("Enter country information:" );
        for (int i = 0; i < mount.length; i++){

            mount[i]=new Mountain();
            System.out.print("Name of "+(i+1)+" mountain => ");

            mount[i].name=sc.nextLine();
            System.out.print("Height of "+(i+1)+" mountain => ");

            mount[i].height=sc.nextDouble();
            sc.nextLine();
        }
        return mount;
    }

    public static void showArray(Mountain[] mont) {
        for (int i = 0; i < mont.length; i++){
            System.out.println("" + mont[i].name +  "\t" + mont[i].height + " \n" + "m");
        }
    }

    // INFORMATION ABOUT ONE MOUNTINE
    public static void showMountain(Mountain mont){
        System.out.println(""+mont.name+"\t"+mont.height+" m");
    }

    // SORTING MOUNTAINS BY HEIGHT
    public static void sortHeight(Mountain[] mont) {
        for (int i = 0; i < mont.length - 1; i++)
            for (int j = 0; j < mont.length - 1 - i; j++)
                if (mont[j].height > mont[j + 1].height) {
                    Mountain rab = mont[j];
                    mont[j] = mont[j + 1];
                    mont[j + 1] = rab;
                }
    }


    // SORTING MOUNTAINS BY NAME
    public static void sortName(Mountain[] mont){
        for (int i = 0; i < mont.length-1; i++)
            for (int j = 0; j < mont.length-i-1; j++)
                if(mont[j].name.compareTo(mont[i+1].name)>0) {
                    Mountain rab = mont[j];
                    mont[j] = mont[j + 1];
                    mont[j + 1] = rab;
                }
    }

    //MOUNTAINS OVER 1000
    public static Mountain[] Bigger(Mountain mont[]){
        double moreththou=1000;
        int kol=0;
        for (int i = 0; i < mont.length; i++){
            if (mont[i].height > moreththou)
                ++kol;
        }
        if (kol != 0) {
            Mountain[] morethanth= new Mountain[kol];
            int n = -1;
            for (int i = 0; i < mont.length; i++)
                if (mont[i].height > moreththou) {
                    morethanth[++n] = mont[i];
                }
            return morethanth;
        }
        else return null;
    }


    public static Mountain findForName(Mountain mont[], String name){
        int n=-1;
        for (int i = 0; i < mont.length; i++)
            if (name.equals(mont[i].name))
                n=i;
        if (n!= -1) {
            return mont[n];
        }
        else return null;
    }


    // MAIN CLASS WITH METHODS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Enter the number of mountains => ");
        int n = sc.nextInt();
        Mountain mount[] = setMountainArr(n);
        System.out.println("\nMountain characteristics: ");
        showArray(mount);


        // sort countries by height
        sortHeight(mount);
        System.out.println("\nSorted list by height:");
        showArray(mount);

        // sort mountains by name
        sortName(mount);
        System.out.println("\nSorted list by title:");
        showArray(mount);

        // more than 1000
        System.out.println("\nMountains, with height more than 1000 ");
        Mountain[] larger = Bigger(mount);
        showArray(larger);

        // search for a mountain
        System.out.println("\nSEARCH MOUNTAIN \n Enter country name => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Mountain sfind = findForName(mount, sname);


        if (sfind != null) {
            showMountain(sfind);
        } else {
            System.out.println("This mountain is not on the list.");
        }



    }
}
