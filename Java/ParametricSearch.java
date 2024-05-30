import java.util.*;

public class ParametricSearch{
    static int N, M;
    static int[] arr=new int[1005];

    public static boolean chk(int x){
        int cnt=0;
        for (int i=0;i<N;i++)
            cnt+=arr[i]/x;
        return cnt>=M;
    }

    public static int ParametricSearch(){
        int lo=0, hi=-1;
        for (int i=0;i<N;i++)
            hi=Math.max(hi,arr[i]+1);
        while (lo+1<hi){
            int mid=(lo+hi)/2;
            if (chk(mid))
                lo=mid;
            else
                hi=mid;
        }
        return lo;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        System.out.println(ParametricSearch());
        sc.close();
    }
}