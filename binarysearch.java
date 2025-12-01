// package sortingalgo;

public class binarysearch {

    public static int binary(int[] arr,int target){

        int start=0;
        int end=arr.length-1;

        while(start<=end){

            int mid=start+(end-start)/2;
            if(arr[mid]<target){
                start=mid+1;
            }

            if(arr[mid]>target){
                end=mid-1;
            }

            if(arr[mid]==target){
                return mid;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
        int[] arr={-45,-12,0,2,4,6,7,8,20};
        int target=7;
        int result=binary(arr,target);
        System.out.println(result);
    }
}
