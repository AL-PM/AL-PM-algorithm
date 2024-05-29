import java.util.*;
@SuppressWarnings("unchecked")

public class BFS{
    static int N, M, R;
    static int[] visited=new int[1005];
    static ArrayList<Integer>[] arr=new ArrayList[1005];

    public static void BFS(int st){
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        visited[st]=0;
        while (!q.isEmpty()){
            int x=q.poll();
            for (int dx:arr[x]){
                if (visited[dx]==-1){
                    visited[dx]=visited[x]+1;
                    q.add(dx);
                }
            }
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
        Arrays.fill(visited,0,N+1,-1);
        BFS(R);
        for (int i=1;i<=N;i++)
            System.out.println(visited[i]);
        sc.close();
    }
}