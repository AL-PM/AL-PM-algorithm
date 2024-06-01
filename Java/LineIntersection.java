import java.util.*;

class Dot implements Comparable<Dot> {
    int x, y;
    Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Dot other){
        if (this.x!=other.x)
            return Long.compare(this.x,other.x);
        return Long.compare(this.y,other.y);
    }
}

public class LineIntersection{
    static Dot[] arr=new Dot[4];

    static int CCW(Dot a, Dot b, Dot c){
        int ret=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        return Long.compare(ret,0);
    }

    static boolean LineIntersection(Dot a, Dot b, Dot c, Dot d){
        int ab=CCW(a,b,c)*CCW(a,b,d), cd=CCW(c,d,a)*CCW(c,d,b);
        if (ab==0 && cd==0){
            if (a.compareTo(b)>0){
                Dot tmp=a;
                a=b;
                b=tmp;
            }
            if (c.compareTo(d)>0){
                Dot tmp=c;
                c=d;
                d=tmp;
            }
            return !(c.compareTo(b)>0 || a.compareTo(d)>0);
        }
        return (ab<=0 && cd<=0);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<4;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr[i]=new Dot(x,y);
        }
        if (LineIntersection(arr[0],arr[1],arr[2],arr[3]))
            System.out.println("1");
        else
            System.out.println("0");
        sc.close();
    }
}
