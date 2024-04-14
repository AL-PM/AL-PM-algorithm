#include <bits/stdc++.h>
#define ll long long
using namespace std;
struct Dot{ll x, y;};
bool cmp(Dot x, Dot y){
    if (x.x!=y.x)
        return x.x<y.x;
    return x.y<y.y;
}
ll N;
vector<Dot> arr;
deque<Dot> CW, ACW;
ll CCW(Dot a, Dot b, Dot c){
    return (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
}
ll ConvexHull(){
    for (int i=0;i<arr.size();i++){
        while (CW.size()>=2 && CCW(CW[1],CW[0],arr[i])>=0)
            CW.pop_front();
        CW.push_front(arr[i]);
        while (ACW.size()>=2 && CCW(ACW[1],ACW[0],arr[i])<=0)
            ACW.pop_front();
        ACW.push_front(arr[i]);
    }
    return (CW.size()+ACW.size()-2);
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i=0;i<N;i++){
        ll a, b;
        cin >> a >> b;
        arr.push_back({a,b});
    }
    sort(arr.begin(),arr.end(),cmp);
    cout << ConvexHull();
    return 0;
}