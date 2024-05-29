import java.util.*;

public class InsertionSort{
    static int N;
    static int[] arr=new int[1005];

    public static void InsertionSort(){
        for (int i=1;i<N;i++){
            int tmp=arr[i], now;
            for (now=i-1;now>=0;now--){
                if (arr[now]<tmp)
                    break;
                arr[now+1]=arr[now];
            }
            arr[now+1]=tmp;
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        InsertionSort();
        for (int i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        sc.close();
    }
}