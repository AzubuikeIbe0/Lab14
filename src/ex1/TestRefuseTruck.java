package ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestRefuseTruck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noBins=0;
        double cost=0;
        double binWeight;
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;

        while(!valid1){
            try {
                System.out.println("Enter the number of bins the truck can collect");
                noBins = in.nextInt();
                in.nextLine();
                valid1=true;
            }catch (InputMismatchException wronginput){
                System.out.println("Error with Input");
                in.nextLine();
            }
        }

        while (!valid2){
            try {
                System.out.println("Enter the cost per kilo");
                cost = in.nextDouble();
                in.nextLine();
                valid2=true;
            }catch (InputMismatchException wronginput){
                System.out.println("Error with input");
                in.nextLine();
            }
        }

        RefuseTruck T1 = new RefuseTruck(noBins, cost);

        while (!valid3){
            try {
                while (T1.getMaxBins()>T1.getNoOfBinsCollected()){
                    System.out.println("Enter the weight for bin" + (T1.getNoOfBinsCollected()+1) + " :");
                    binWeight = in.nextDouble();
                    in.nextLine();
                    if(T1.collectBin(binWeight))
                        valid3=true;
                }

                T1.printStats();
                break;
            }catch(InputMismatchException wronginput){
                System.out.println("Error in input");
                in.nextLine();
            }
        }

    }
}
