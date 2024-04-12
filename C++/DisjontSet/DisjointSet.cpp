#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M, arr[1005];
ll Find(ll x){
    if (x==arr[x])
        return x;
    return arr[x]=Find(arr[x]);
}
void Union(ll x, ll y){
    arr[Find(x)]=Find(y);
}
void DisjointSet(ll x, ll y){
    if (Find(x)==Find(y))
        cout << "Yes\n";
    else
        cout << "No\n";
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    iota(&arr[0],&arr[1004],0);
    for (int i=0;i<M;i++){
        ll x, a, b;
        cin >> x >> a >> b;
        if (x)
            DisjointSet(a,b);
        else
            Union(a,b);
    }
    return 0;
}