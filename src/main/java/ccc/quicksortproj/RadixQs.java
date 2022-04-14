/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccc.quicksortproj;

/**
 *
 * @author Hamzi
 */
public class RadixQs {
    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    /**
     * 3-way partitioning using dth character
     *
     * @param a The array to be sorted.
     * @param lo The lower boundary in the array that will be sorted.
     * @param hi The upper boundary in the array that will be sorted.
     * @param d using dth character (in the client code d should be 0).
     */
    // Code was taken from https://github.com/JaneLdq/coursera-algorithms/blob/master/src/main/java/me/janeldq/algorithms/sort/Quick3WayStringSort.java
    public static void sort(String[] a, int lo, int hi, int d) {
        if (lo >= hi){
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v){
                exch(a, lt++, i++);
            }else if (t > v){
                exch(a, i, gt--);
            }else{
                i++;
            }
        }
        // a[lo .. lt - 1] < v = a[lt .. gt] < a[gt + 1 .. hi]
        sort(a, lo, lt - 1, d);
        if (v >= 0){
        sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
        }
    }

    public static int charAt(String s, int d) {
        if (d < s.length()){ 
            return s.charAt(d);
        }
        return -1;
    }

    public static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
