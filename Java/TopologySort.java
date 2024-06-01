import java.util.*;
@SuppressWarnings("unchecked")

public class TopologySort{
    static int N, M;
    static int[] indegree=new int[1005];
    static List<Integer>[] arr=new ArrayList[1005];
    static List<Integer> ans=new ArrayList<>();

    static void TopologySort(){
        Queue<Integer> q=new LinkedList<>();
        for (int i=1;i<=N;i++){
            if (indegree[i]==0)
                q.add(i);
        }
        for (int i=0;i<N;i++){
            if (q.isEmpty()){
                System.out.println("-1");
                return;
            }
            int x=q.poll();
            ans.add(x);
            for (int dx:arr[x]){
                if (--indegree[dx]==0)
                    q.add(dx);
            }
        }
        for (int x:ans)
            System.out.print(x+" ");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=1;i<=N;i++)
            arr[i]=new ArrayList<>();
        for (int i=0;i<M;i++){
            int a=sc.nextInt();
            int c=-1;
            for (int j=0;j<a;j++){
                int b=sc.nextInt();
                if (j>0){
                    arr[c].add(b);
                    indegree[b]++;
                }
                c=b;
            }
        }
        TopologySort();
        sc.close();
    }
}