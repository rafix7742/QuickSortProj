/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccc.quicksortproj;

import java.util.Random;

/**
 *
 * @author Rafik
 */
public class QuickAlg {
    public static int comparisons;
    public static int switches;
    /**
     * QuickSort algorithm takes an array, a start position and an end position. The array will be sorted in ascending order. 
     * @param arr The array that is going to be sorted.
     * @param begin The first position in the array that will be sorted.
     * @param end  The last position in the array that will be sorted.
     */
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
    /**
     * A helper method for the QuickSort algorithm that finds a point to partition.
     * @param arr The array that needs to have a partition position found.
     * @param begin The first start boundary for the array.
     * @param end The end boundary for the array.
     * @return The position of the partition for QuickSort.
     */
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
    /**
     * Reverse QuickSort algorithm takes an array, a start position and an end position. The array will be sorted in descending order.
     * @param arr The array that is going to be sorted.
     * @param begin The first position in the array that will be sorted.
     * @param end The last position in the array that will be sorted.
     */
    public static void revQuickSort(int arr[], int begin, int end) {
    if (begin < end) {
        //Same stopping clause for recursion
        int partitionIndex = revPartition(arr, begin, end);
        //same partition method
        revQuickSort(arr, begin, partitionIndex-1);
    //                          not minus 1^ (double check if this needs to be minus 1)
    //the only key difference here is the partition index is not minus one 
    //this makes sure we do not get a stack overflow error
        revQuickSort(arr, partitionIndex+1, end);
    }
}
    /**
     * A helper method for the Reverse QuickSort algorithm that finds a point to partition.
     * @param arr The array that needs to have a partition position found.
     * @param begin The start boundary for the array.
     * @param end The end boundary for the array.
     * @return The position of the partition for the Reverse QuickSort.
     */
    public static int revPartition(int arr[], int begin, int end){
    int pivot = arr[begin];
    //piviot starts at the left most position 
    int i = begin;
    for(int j = begin + 1; j <= end; j++){
        comparisons++;
        if (arr[j] > pivot){
            i = i + 1;
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            switches++;
        }
    }

    int temp = arr[i];
    arr[i] = arr[begin];
    arr[begin] = temp;
    switches++;
    return i;

}
    /**
     * Random QuickSort algorithm takes an array, a start position and an end position. The array will be sorted in descending order. The pivot element will be randomly chosen
     * @param arr The array that is going to be sorted.
     * @param begin The first position in the array that will be sorted.
     * @param end The last position in the array that will be sorted.
     */
    public static void rndQs(int arr[], int begin, int end){
        if (begin < end) {
        int partitionIndex = rndPartition(arr, begin, end);
        rndQs(arr, begin, partitionIndex-1);
        rndQs(arr, partitionIndex+1, end);
    }
    }
    /**
     * Helper method for the random partition method, it will find a random pivot between the high and low values.
     * @param arr The array that will have its values taken from.
     * @param low The lower bound of the array and the lower bound of the random pivot.
     * @param high The upper bound of the array and the upper bound of the random pivot.
     */
    public static void random(int arr[],int low,int high)
    {
     //Does not count as a switch as this is solely for a random value
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1=arr[pivot]; 
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
    /**
     * A helper method for the Random QuickSort algorithm that finds a point to partition.
     * @param arr The array that needs to have a partition position found.
     * @param low The lower boundary for the array.
     * @param high The upper boundary for the array.
     * @return The position of the partition for the Reverse QuickSort.
     */
    public static int rndPartition(int arr[], int low, int high) {
        // pivot is chosen randomly
        random(arr, low, high);
        int pivot = arr[high];
            
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            comparisons++;
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                switches++;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        switches++;
        return i+1;
}
    /**
     * Getter for the number of QuickSort comparisons
     * @return The number of comparisons of QuickSort
     */
    public static int getComp(){
        return comparisons;
    }
    /**
     * Getter for the number of QuickSort switches.
     * @return The number of switches of QuickSort
     */
    public static int getSwitch(){
        return switches;
    }
    /**
     * Reset for the count of comparisons and switches
     */
    public static void reset(){
        switches = 0;
        comparisons = 0;
    }
}