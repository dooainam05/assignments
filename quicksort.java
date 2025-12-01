// package sortingalgo;
import java.util.Arrays;
public class quicksort {

    public static void qs(int[] arr,int low, int hi){

        int s= low;
        int e= hi;
        int n= s+(e-s)/2;
        int pivot = arr[n];

        while(s<=e){

            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp = arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
            qs(arr, low, e);
            qs(arr, s, hi);
        

    }
    public static void main(String[] args) {
        int[] arr={3,1,5,7,2};
        qs(arr, 0, arr.length-1); //0 se last index tak
        System.out.println(Arrays.toString(arr));
    }
}
