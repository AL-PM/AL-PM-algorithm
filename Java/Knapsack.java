import java.util.*;

class Item {
    int weight, value;
    Item(int weight, int value){
        this.weight=weight;
        this.value=value;
    }
}

public class Knapsack{
    static int N, M;
    static int[][] DP=new int[105][1005];
    static List<Item> arr=new ArrayList<>();

    static int Knapsack(){
        int ret=0;
        for (int i=0;i<N;i++){
            int w=arr.get(i).weight, v=arr.get(i).value;
            for (int j=0;j<=M;j++){
                if (j<w)
                    DP[i+1][j]=DP[i][j];
                else
                    DP[i+1][j]=Math.max(DP[i][j],DP[i][j-w]+v);
            }
        }
        for (int i=0;i<=M;i++)
            ret=Math.max(ret,DP[N][i]);
        return ret;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<N;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr.add(new Item(a,b));
        }
        System.out.println(Knapsack());
        sc.close();
    }
}
