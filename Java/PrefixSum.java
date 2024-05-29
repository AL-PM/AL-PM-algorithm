import java.util.*;

public class PrefixSum{
    static final int INF=1000000007;
    static int N, M, ans=-INF;
    static int[] arr=new int[1005];
    static int[] sum=new int[1005];

    public static void PrefixSum(){
        for (int i=0;i<N;i++)
            sum[i+1]=arr[i]+sum[i];
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        PrefixSum();
        for (int i=0;i<=N-M;i++)
            ans=Math.max(ans,sum[i+M]-sum[i]);
        System.out.println(ans);
        sc.close();
    }
}