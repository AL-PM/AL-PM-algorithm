import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge{
    int st, ed, dst;

    Edge(int st, int ed, int dst){
        this.st=st;
        this.ed=ed;
        this.dst=dst;
    }
}

public class BellmanFord{
    static final int INF=1000000007;
    static int N, M;
    static int[] visited=new int[1005];
    static ArrayList<Edge> arr=new ArrayList<>();

    public static void BellmanFord(){
        for (int i=1;i<=N;i++){
            if (visited[i]==INF){
                visited[i]=0;
                for (int j=0;j<N;j++){
                    for (int k=0;k<arr.size();k++){
                        if (visited[arr.get(k).st]==INF)
                            continue;
                        visited[arr.get(k).ed]=Math.min(visited[arr.get(k).ed],visited[arr.get(k).st]+arr.get(k).dst);
                    }
                }
                for (int j=0;j<arr.size();j++){
                    if (visited[arr.get(j).st]==INF)
                        continue;
                    if (visited[arr.get(j).ed]>visited[arr.get(j).st]+arr.get(j).dst){
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        Arrays.fill(visited,0,N+1, INF);
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr.add(new Edge(a,b,c));
        }
        BellmanFord();
        sc.close();
    }
}