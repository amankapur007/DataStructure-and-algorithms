/**
 * Linear Search / Sequential Search
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] a = {5,9,12,20,25};
        System.out.println("Search 25 : "+search(a, 25));

    }

    public static boolean search(int[] a, int number){
        for (int j : a) {
            if(j == number)return  true;
        }
        return false;
    }
}
