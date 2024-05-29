import java.util.*;

public class BubbleSort{
    static int N;
    static int[] arr=new int[1005];

    public static void BubbleSort(){
        for (int i=N-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        BubbleSort();
        for (int i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        sc.close();
    }
}