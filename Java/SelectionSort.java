import java.util.Scanner;

public class SelectionSort{
    static int N;
    static int[] arr=new int[1005];

    public static void SelectionSort(){
        for (int i=0;i<N;i++){
            int mn=i;
            for (int j=i+1;j<N;j++){
                if (arr[mn]>arr[j])
                    mn=j;
            }
            if (i!=mn){
                int tmp=arr[i];
                arr[i]=arr[mn];
                arr[mn]=tmp;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        SelectionSort();
        for (int i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        sc.close();
    }
}