import java.util.*;

public class Eratosthenes{
    static int N;
    static int[] arr=new int[1005];

    public static void Eratosthenes(){
        arr[1]=1;
        for (int i=2;i*i<=N;i++){
            if (arr[i]==0){
                for (int j=i*i;j<=N;j+=i)
                    arr[j]=1;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        Eratosthenes();
        for (int i=1;i<=N;i++){
            if (arr[i]==0)
                System.out.println(i);
        }
        sc.close();
    }
}