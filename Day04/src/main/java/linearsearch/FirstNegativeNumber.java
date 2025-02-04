package linearsearch;

public class FirstNegativeNumber {
    public static int findNegative(int []arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={5,2,9,-3,1,4,-1};
        int result=findNegative(arr);
        if(result==-1)
            System.out.println("There is no negative number in an array");

        else
            System.out.println("First negative number found in array at the index of : "+result);
    }
}
