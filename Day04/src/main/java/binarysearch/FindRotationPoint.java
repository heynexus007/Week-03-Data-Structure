package binarysearch;
import static java.lang.System.*;
public class FindRotationPoint {
    public static int rotate(int []a){
        int len=a.length;
        int left=0;
        int right=len-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]>a[right])
                left=mid+1;

            else if (a[mid]<a[right])
                right=mid;
        }
        return a[left];
    }
    public static void main(String[] args) {
        int []arr={3,5,7,9,12,14,1,2};
        out.println(rotate(arr));
    }
}
