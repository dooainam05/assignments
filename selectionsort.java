// package sortingalgo;

import java.util.Arrays;

public class selectionsort {
    
public static void selsort(int[] arr){

    for(int i = 0 ; i < arr.length; i++){
        int last= arr.length-1-i;//har iteration mein last index kam hota jayga
        int maxindex=getMaxIndex(arr, 0 , last);
        swap(arr,maxindex,last);
    }
}


public static void swap(int[] arr , int first , int second){
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second]=temp;
}


    public static int getMaxIndex(int[] arr, int start , int end){
        int max=start;

        for(int i=start; i<= end ; i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={4,1,5,3,2};
        selsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


