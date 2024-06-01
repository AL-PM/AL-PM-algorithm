import java.util.*;
@SuppressWarnings("unchecked")

public class DFS{
    static int N, M, R;
    static int[] visited=new int[1005];
    static ArrayList<Integer>[] arr=new ArrayList[1005];

    public static void DFS(int x, int depth){
        visited[x]=depth;
        for (int dx:arr[x]){
            if (visited[dx]==-1)
                DFS(dx,depth+1);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        R=sc.nextInt();
        for (int i=0;i<=N;i++)
            arr[i]=new ArrayList<>();
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        Arrays.fill(visited,-1);
        DFS(R,0);
        for (int i=1;i<=N;i++)
            System.out.println(visited[i]);
        sc.close();
    }
}