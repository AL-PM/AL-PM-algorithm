#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M;
ll arr[1005];
bool chk(int x){
    ll cnt=0;
    for (int i=0;i<N;i++)
        cnt+=arr[i]/x;
    return cnt>=M;
}
ll ParametricSearch(){
    ll lo=0, hi=-1;
    for (int i=0;i<N;i++)
        hi=max(hi,arr[i]+1);
    while (lo+1<hi){
        ll mid=(lo+hi)/2;
        if (chk(mid))
            lo=mid;
        else
            hi=mid;
    }
    return lo;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    cout << ParametricSearch();
    return 0;
}