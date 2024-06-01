import java.util.*;

class Dot{
    int x, y;
    Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class ConvexHull{
    static int N;
    static ArrayList<Dot> arr=new ArrayList<>();
    static Deque<Dot> CW=new ArrayDeque<>();
    static Deque<Dot> ACW=new ArrayDeque<>();

    public static boolean cmp(Dot a, Dot b){
        if (a.x!=b.x)
            return a.x<b.x;
        return a.y<b.y;
    }

    public static int CCW(Dot a, Dot b, Dot c){
        return (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
    }

    public static int ConvexHull(){
        Collections.sort(arr, new Comparator<Dot>(){
            @Override
            public int compare(Dot a, Dot b){
                return cmp(a,b) ? -1 : 1;
            }
        });

        for (Dot dot:arr){
            while (CW.size()>=2 && CCW(CW.toArray(new Dot[0])[1], CW.toArray(new Dot[0])[0], dot)>=0)
                CW.pop();
            CW.push(dot);
            while (ACW.size()>=2 && CCW(ACW.toArray(new Dot[0])[1], ACW.toArray(new Dot[0])[0], dot)<=0)
                ACW.pop();
            ACW.push(dot);
        }
        return (CW.size()+ACW.size()-2);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for (int i=0; i<N; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr.add(new Dot(a,b));
        }
        System.out.println(ConvexHull());
        sc.close();
    }
}