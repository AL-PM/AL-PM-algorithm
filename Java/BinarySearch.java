import java.util.*;

public class BinarySearch{
    static int N, M;
    static int[] arr=new int[1005];

    public static boolean BinarySearch(int x){
        int lo=0, hi=N;
        while (lo+1<hi){
            int mid=(lo+hi)/2;
            if (arr[mid]<=x)
                lo=mid;
            else
                hi=mid;
        }
        return arr[lo]==x;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr,0,N);
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            if (BinarySearch(a))
                System.out.println("1");
            else
                System.out.println("0");
        }
        sc.close();
    }
}