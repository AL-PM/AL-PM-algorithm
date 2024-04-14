#include <bits/stdc++.h>
#define ll long long
using namespace std;
struct Dot{ll x, y;};
bool operator>(Dot x, Dot y){
    if (x.x!=y.x)
        return x.x>y.x;
    return x.y>y.y;
}
Dot arr[4];
ll CCW(Dot a, Dot b, Dot c){
    ll ret=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
    return (0<ret)-(ret<0);
}
ll LineIntersection(Dot a, Dot b, Dot c, Dot d){
    ll ab=CCW(a,b,c)*CCW(a,b,d), cd=CCW(c,d,a)*CCW(c,d,b);
    if (ab==0 && cd==0){
        if (a>b)
            swap(a,b);
        if (c>d)
            swap(c,d);
        return !(c>b || a>d);
    }
    return (ab<=0 && cd<=0);
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i=0;i<4;i++)
        cin >> arr[i].x >> arr[i].y;
    cout << LineIntersection(arr[0],arr[1],arr[2],arr[3]);
    return 0;
}