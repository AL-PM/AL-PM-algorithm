import java.util.*;

public class DisjointSet{
    static int N, M;
    static int[] arr=new int[1005];;

    static int Find(int x){
        if (x==arr[x])
            return x;
        return arr[x]=Find(arr[x]);
    }

    static void Union(int x, int y){
        arr[Find(x)]=Find(y);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<=N;i++)
            arr[i]=i;
        for (int i=0;i<M;i++){
            int x=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            if (x==1){
                if (Find(a)==Find(b))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
            else
                Union(a, b);
        }
        sc.close();
    }
}
