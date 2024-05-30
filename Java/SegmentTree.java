import java.util.*;

public class SegmentTree{
    static int N, M;
    static int[] arr=new int[100005];
    static ArrayList<Integer> SegTree=new ArrayList<>();

    public static int Query(int n, int l, int r, int st, int ed){
        if (l>ed || r<st)
            return 0;
        if (l>=st && r<=ed)
            return SegTree.get(n);
        int mid=(l+r)/2;
        return Query(n*2,l,mid,st,ed)+Query(n*2+1,mid+1,r,st,ed);
    }

    public static int Update(int n, int l, int r, int pos, int x){
        if (l>pos || r<pos)
            return SegTree.get(n);
        if (l==r){
            SegTree.set(n,x);
            return SegTree.get(n);
        }
        int mid=(l+r)/2;
        SegTree.set(n,Update(n*2,l,mid,pos,x)+Update(n*2+1,mid+1,r,pos,x));
        return SegTree.get(n);
    }

    public static int Init(int n, int l, int r){
        if (l==r){
            SegTree.set(n,arr[l]);
            return SegTree.get(n);
        }
        int mid=(l+r)/2;
        SegTree.set(n,Init(n*2,l,mid)+Init(n*2+1,mid+1,r));
        return SegTree.get(n);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        for (int i=1;i<=N;i++)
            arr[i]=sc.nextInt();
        for (int i=0;i<4*N;i++)
            SegTree.add(0);
        Init(1,1,N);
        for (int i=0;i<M;i++){
            int x=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            if (x!=0)
                System.out.println(Query(1,1,N,a,b));
            else
                Update(1,1,N,a,b);
        }
        sc.close();
    }
}