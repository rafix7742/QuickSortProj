/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccc.quicksortproj;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hamzi
 */
public class QuickSort {
    //                                     throws Exception (add if code breaks)
    public static void main(String[] args){
        System.out.println("Please select an option:");
        System.out.println("1. Demo");
        System.out.println("2. Ascending QuickSort");
        System.out.println("3. Descending QuickSort");
        System.out.println("4. Random Pivot QuickSort(Ascending)");
        System.out.println("5. Conclusion");
        System.out.println("6. Quit");
        Scanner scan = new Scanner(System.in);
        int UserChoice = scan.nextInt();
        if(UserChoice ==1){
            int arr[]= {7,9,1,0,12,4,10,2,9,1};
                //10 nums
            System.out.println("Unsorted Array:");
            for(int print: arr){
                System.out.print(print+" ");
            }
            long nanoStart = System.nanoTime();
            QuickAlg.quickSort(arr, 0, arr.length-1);
            long nanoEnd = System.nanoTime();
            System.out.println("\n"+"Sorted Array:");
            for(int print: arr){
                System.out.print(print+" ");
            }
            long ElapsedTime = nanoEnd-nanoStart;
            System.out.println("\n"+"Time Elapsed (Nano Seconds): "+ ElapsedTime);
            System.out.println("The number of comparisons is: "+QuickAlg.getComp());
            System.out.println("The number of switches is: "+QuickAlg.getSwitch());
            System.out.println("\n"+"What if we want to only sort all but the first and last numbers?");
            int arr2[]= {7,9,1,0,12,4,10,2,9,1};
            System.out.println("Unsorted Array:");
            for(int print: arr2){
                System.out.print(print+" ");
            }
            nanoStart = System.nanoTime();
            QuickAlg.reset();
            QuickAlg.quickSort(arr2, 1, 8);
            nanoEnd = System.nanoTime();
            System.out.println("\n"+"Sorted Array:");
            for(int print: arr2){
                System.out.print(print+" ");
            }
            ElapsedTime = nanoEnd-nanoStart;
            System.out.println("\n"+"Time Elapsed (Nano Seconds): "+ ElapsedTime);
            System.out.println("The number of comparisons is: "+QuickAlg.getComp());
            System.out.println("The number of switches is: "+QuickAlg.getSwitch());
        }else if(UserChoice ==2){
            System.out.println("Enter an Array Size");
            int arrSize = scan.nextInt();
            int arr[] = new int[arrSize];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) ((Math.random()*100) +1);
            }
            int begin = 0;
            int end = arr.length - 1;
            long startTime = System.currentTimeMillis();
            long nanoStart = System.nanoTime();
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("");
            QuickAlg.quickSort(arr, begin, end);
            long stopTime = System.currentTimeMillis();
            long nanoEnd = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            long elapsedNano = nanoEnd - nanoStart;
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("");
            System.out.println("Time elapsed in miliseconds: " + elapsedTime);
            System.out.println("Time elapsed in nanoseconds: " + elapsedNano);
            System.out.println("The number of comparisons is: "+QuickAlg.getComp());
            System.out.println("The number of switches is: "+QuickAlg.getSwitch());
        }else if(UserChoice ==3){
            System.out.println("Enter an Array Size");
            int arrSize = scan.nextInt();
            int arr[] = new int[arrSize];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) ((Math.random()*100) +1);
            }
            //^ remove for larger numbers
            int begin = 0;
            int end = arr.length - 1;
            long startTime = System.currentTimeMillis();
            long nanoStart = System.nanoTime();
            
            QuickAlg.revQuickSort(arr, begin, end);
            long stopTime = System.currentTimeMillis();
            long nanoEnd = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            long elapsedNano = nanoEnd - nanoStart;
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            //switch to println for larger sets
            System.out.println("");
            System.out.println("Time elapsed in miliseconds: " + elapsedTime);
            System.out.println("Time elapsed in nanoseconds: " + elapsedNano);
            System.out.println("The number of comparisons is: "+QuickAlg.getComp());
            System.out.println("The number of switches is: "+QuickAlg.getSwitch());
        }else if(UserChoice ==4){
            System.out.println("Enter an Array Size");
            int arrSize = scan.nextInt();
            int arr[] = new int[arrSize];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) ((Math.random()*100) +1);
            }
            int begin = 0;
            int end = arr.length - 1;
            long startTime = System.currentTimeMillis();
            long nanoStart = System.nanoTime();
            QuickAlg.rndQs(arr, begin, end);
            long stopTime = System.currentTimeMillis();
            long nanoEnd = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            long elapsedNano = nanoEnd - nanoStart;
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[j]);
            }
            //switch to print + " " to have numbers side by side
            System.out.println("");
            System.out.println("Time elapsed in miliseconds: " + elapsedTime);
            System.out.println("Time elapsed in nanoseconds: " + elapsedNano);
            System.out.println("The number of comparisons is: "+QuickAlg.getComp());
            System.out.println("The number of switches is: "+QuickAlg.getSwitch());
        }else if(UserChoice ==5){
            System.out.println("Enter an array size");
            int arrSize = scan.nextInt();
            String[] arr = new String[arrSize];
            for (int i = 0; i < arr.length; i++) {
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnop";
                StringBuilder salt = new StringBuilder();
                //For the ability to make strings of changing values
                Random rnd = new Random();
                while (salt.length() < (int) (Math.random() * 26) + 1) { // length of the random string.
                    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                    //random position within the string to convert into characters
                    salt.append(SALTCHARS.charAt(index));
                    //adding characters tod teh salt builder
                }
                arr[i] = salt.toString();
                //converting from string builder into the array
            }
            System.out.println("Would you like to print the original array?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int c = scan.nextInt();
            if(c == 1){
                for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i]+ " ");
            } 
            }
              //Quick3WayStringSort ob = new Quick3WayStringSort();
            System.out.println("");
            long startTime = System.currentTimeMillis();
            long nanoStart = System.nanoTime();
            RadixQs.sort(arr, 0, arr.length - 1, 0);
            long nanoEnd = System.nanoTime();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            long elapsedNano = nanoEnd - nanoStart;
            for (int i = 0; i < arr.length; ++i) {
                System.out.println(arr[i]);
            }
            System.out.println("Time elapsed in miliseconds: " + elapsedTime);
            System.out.println("Time elapsed in nanoseconds: " + elapsedNano);
            
        }else{
            System.exit(0);
        }
    }
}
