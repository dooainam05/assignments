// package sortingalgo;
import java.util.Arrays;


public class bubblesort {

static void bbs(int[] arr){
    
    for(int i=0 ; i < arr.length ; i++){
boolean swapp=false;
        for(int j = 1 ; j < arr.length-i ; j++){

            if(arr[j-1] > arr[j]){
             int temp = arr[j];
             arr[j] = arr[j-1];
             arr[j-1] = temp;
             swapp=true; //bcz arr[i] tau change nhi hoga tau compare hokar swap kese hoga
            }
        }
        if(!swapp){
            // agar kisi i keliye if nhi chala means swap nhi hoa pura array mein se tau sorted hai isliye program break kardo
            break;
        }
    }
    }
    public static void main(String[] args) {
       int[] arr={3,1,5,7,2};
       bbs(arr);
       System.out.println(Arrays.toString(arr));
    }
}
