#include <bits/stdc++.h>
#define ll long long
using namespace std;
struct Edge{
    ll x, y, dst;
    Edge() {}
    Edge(ll a, ll b, ll c): x(a), y(b), dst(c) {} 
};
bool operator<(Edge x, Edge y){
    return x.dst>y.dst;
}
ll N, M, arr[1005];
priority_queue<Edge> pq;
ll Find(ll x){
    if (x==arr[x])
        return x;
    return arr[x]=Find(arr[x]);
}
void Union(ll x, ll y){
    arr[Find(x)]=Find(y);
}
ll Kruskal(){
    ll ret=0;
    while (!pq.empty()){
        ll x=pq.top().x, y=pq.top().y, curr=pq.top().dst;
        pq.pop();
        if (Find(x)==Find(y))
            continue;
        Union(x,y);
        ret+=curr;
    }
    return ret;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    iota(&arr[0],&arr[1004],0);
    for (int i=0;i<M;i++){
        ll a, b, c;
        cin >> a >> b >> c;
        pq.push({a,b,c});
    }
    cout << Kruskal();
    return 0;
}