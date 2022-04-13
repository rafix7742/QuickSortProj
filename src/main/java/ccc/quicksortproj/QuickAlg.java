/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccc.quicksortproj;

import java.util.Random;

/**
 *
 * @author Hamzi
 */
public class QuickAlg {
    public static int comparisons;
    public static int switches;
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            //Stopping point for recursion
            int partitionIndex = partition(arr, begin, end);
            //Picks a partition position 
            quickSort(arr, begin, partitionIndex - 1);
            //recursively sorts the array into two bounds upper and lower from the partition index
            quickSort(arr, partitionIndex + 1, end);
            
        }
    }

    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        //chooses the right-most position as the pivot point
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                //moves the pivot futher left untill all numbers on the left are less than the pivot 
                //and the numbers on the right are greater than
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                switches++;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        switches++;
        //Once we get down to the final values it does one more swap to finalize the sorting
        return i + 1;
    }
    public static void revQuickSort(int arr[], int begin, int end) {
    if (begin < end) {
        //Same stopping clause for recursion
        int partitionIndex = revPartition(arr, begin, end);
        //same partition method
        revQuickSort(arr, begin, partitionIndex);
    //                          not minus 1^(it might be minus 1?)
    //the only key difference here is the partition index is not minus one 
    //this makes sure we do not get a stack overflow error
        revQuickSort(arr, partitionIndex+1, end);
    }
}
    public static int revPartition(int arr[], int begin, int end){
    int pivot = arr[begin];
    //piviot starts at the left most position 
    int i = begin;
    for(int j = begin + 1; j <= end; j++){
        if (arr[j] > pivot){
            i = i + 1;
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
        }
    }

    int temp = arr[i];
    arr[i] = arr[begin];
    arr[begin] = temp;

    return i;

}
    public static void rndQs(int arr[], int begin, int end){
        if (begin < end) {
        int partitionIndex = rndPartition(arr, begin, end);
        rndQs(arr, begin, partitionIndex-1);
        rndQs(arr, partitionIndex+1, end);
    }
    }
    public static void random(int arr[],int low,int high)
    {
     
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
         
        int temp1=arr[pivot]; 
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
    public static int rndPartition(int arr[], int low, int high) {
        // pivot is chosen randomly
        random(arr, low, high);
        int pivot = arr[high];

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
}
    public static int getComp(){
        return comparisons;
    }
    public static int getSwitch(){
        return switches;
    }
}