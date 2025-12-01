// package sortingalgo;

public class linearsearch {
    
    static int linear(int[] arr, int target){

        for(int i=0 ; i < arr.length ; i++ ){

            if(arr[i]==target){
                return i;
            }
        }
        return-1;
    }
    public static void main(String[] args) {
        int[] arr={2,4,5,7,3,8};
        int target=4;
        int result=linear(arr, target);
        System.out.println(result);
    }
}
