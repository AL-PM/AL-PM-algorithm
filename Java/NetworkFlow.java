import java.util.*;
@SuppressWarnings("unchecked")

public class Main {
    static final int INF=1000000007;
    static int N, M, S, E;
    static int[][] capacity=new int[1005][1005];
    static int[][] flow=new int[1005][1005];
    static int[] visited=new int[1005];
    static List<Integer>[] arr=new ArrayList[1005];

    static int EdmondsKarp(int st, int ed){
        int ret=0;
        while (true){
            Arrays.fill(visited,-1);
            Queue<Integer> q=new LinkedList<>();
            q.add(st);
            visited[st]=st;
            while (!q.isEmpty()){
                int x=q.poll();
                for (int dx:arr[x]){
                    if (visited[dx]==-1 && capacity[x][dx]>flow[x][dx]){
                        q.add(dx);
                        visited[dx]=x;
                    }
                }
            }
            if (visited[ed]==-1)
                break;
            int mn=INF;
            for (int i=ed, j;i!=st;i=j){
                j=visited[i];
                mn=Math.min(mn,capacity[j][i]-flow[j][i]);
            }
            for (int i=ed, j;i!=st;i=j){
                j=visited[i];
                flow[j][i]+=mn;
                flow[i][j]-=mn;
            }
            ret+=mn;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        S=sc.nextInt();
        E=sc.nextInt();
        for (int i=1;i<=N;i++)
            arr[i]=new ArrayList<>();
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            capacity[a][b]+=c;
            capacity[b][a]+=c;
            arr[a].add(b);
            arr[b].add(a);
        }
        System.out.println(EdmondsKarp(S, E));
        sc.close();
    }
}
