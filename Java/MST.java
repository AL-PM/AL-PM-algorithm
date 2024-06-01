import java.util.*;

class Edge implements Comparable<Edge>{
    int x, y, dst;
    Edge(int x, int y, int dst){
        this.x=x;
        this.y=y;
        this.dst=dst;
    }
    @Override
    public int compareTo(Edge other){
        return Long.compare(this.dst,other.dst);
    }
}

public class MST{
    static int N, M;
    static int[] arr=new int[1005];
    static PriorityQueue<Edge> pq=new PriorityQueue<>();

    static int Find(int x){
        if (x==arr[x])
            return x;
        return arr[x]=Find(arr[x]);
    }

    static void Union(int x, int y){
        arr[Find(x)]=Find(y);
    }

    static int Kruskal(){
        int ret=0;
        while (!pq.isEmpty()){
            Edge edge=pq.poll();
            int x=edge.x, y=edge.y, curr=edge.dst;
            if (Find(x)==Find(y))
                continue;
            Union(x,y);
            ret+=curr;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<=N;i++)
            arr[i]=i;
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            pq.add(new Edge(a,b,c));
        }
        System.out.println(Kruskal());
        sc.close();
    }
}
