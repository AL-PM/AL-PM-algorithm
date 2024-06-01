import java.util.*;
@SuppressWarnings("unchecked")

public class Main {
    static int N, M;
    static int[] match=new int[1005];
    static int[] visited=new int[1005];
    static ArrayList<Integer>[] v=new ArrayList[1005];

    public static int DFS(int x){
        visited[x]=1;
        for (int y:v[x]){
            if (match[y]==-1 || (visited[match[y]]==0 && DFS(match[y])==1)){
                match[y]=x;
                return 1;
            }
        }
        return 0;
    }

    public static int BipartiteMatching(){
        int ret=0;
        Arrays.fill(match,-1);
        for (int i=0;i<N;i++){
            Arrays.fill(visited,0);
            if (DFS(i)==1)
                ret++;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=0;i<N;i++)
            v[i]=new ArrayList<>();
        for (int i=0;i<N;i++){
            int a=sc.nextInt();
            for (int j=0;j<a;j++){
                int b=sc.nextInt();
                v[i].add(b);
            }
        }
        System.out.println(BipartiteMatching());
        sc.close();
    }
}