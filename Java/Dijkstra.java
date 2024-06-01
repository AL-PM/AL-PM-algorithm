import java.util.*;
@SuppressWarnings("unchecked")

class Edge implements Comparable<Edge> {
    int idx, dst;
    Edge(int idx, int dst){
        this.idx=idx;
        this.dst=dst;
    }
    @Override
    public int compareTo(Edge other){
        return Long.compare(this.dst, other.dst);
    }
}

public class Dijkstra{
    static final int INF=1000000007;
    static int N, M, R;
    static int[] visited=new int[1005];
    static List<Edge>[] arr=new ArrayList[1005];

    public static void Dijkstra(int st){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(st,0));
        visited[st]=0;
        while (!pq.isEmpty()){
            Edge edge=pq.poll();
            int x=edge.idx, curr=edge.dst;
            if (curr>visited[x])
                continue;
            for (Edge e:arr[x]){
                int dx=e.idx, next=e.dst;
                if (visited[dx]>curr+next){
                    visited[dx]=curr+next;
                    pq.add(new Edge(dx,curr+next));
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
        Arrays.fill(visited,INF);
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr[a].add(new Edge(b,c));
            arr[b].add(new Edge(a,c));
        }
        Dijkstra(R);
        for (int i=1;i<=N;i++){
            if (visited[i]!=INF)
                System.out.println(visited[i]);
            else
                System.out.println("-1");
        }
        sc.close();
    }
}
