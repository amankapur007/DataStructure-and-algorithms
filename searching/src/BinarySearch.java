public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {5,9,12,20,25};
        int number = 25;
        int low = 0;
        int high = a.length-1;
        int flag=0;
        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid] == number){
                flag=1;
                break;
            }else if(a[mid]<number){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(flag==1){
            System.out.println("Searched");
        }else{
            System.out.println("Not Searched");
        }
    }
}
