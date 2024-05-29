import java.util.*;

public class Main {
    static final int INF=1000000007;
    static int N;
    static int[] arr=new int[1005];
    static int[] sum=new int[1005];

    public static int TwoPointer(){
        int L=0, R=1, ret=-INF;
        while (L<=N && R<=N){
            ret=Math.max(ret,sum[R]-sum[L]);
            if (sum[R]-sum[L]<0){
                L=R;
                R++;
            }
            else
                R++;
        }
        return ret;
    }

    public static void PrefixSum(){
        for (int i=0;i<N;i++)
            sum[i+1]=arr[i]+sum[i];
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        PrefixSum();
        System.out.println(TwoPointer());
        sc.close();
    }
}