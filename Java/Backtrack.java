import java.util.ArrayList;
import java.util.Scanner;

public class Backtrack{
    static int N, M;
    static int[] visited=new int[10];
    static ArrayList<Integer> arr=new ArrayList<>();

    public static void Backtrack(int depth){
        if (depth==M){
            for (int x:arr)
                System.out.print(x+" ");
            System.out.println();
            return;
        }
        for (int i=1;i<=N;i++){
            if (visited[i]==0){
                visited[i]=1;
                arr.add(i);
                Backtrack(depth+1);
                visited[i]=0;
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        Backtrack(0);
        sc.close();
    }
}