#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M;
ll arr[1005];
bool BinarySearch(ll x){
    ll lo=0, hi=N;
    while (lo+1<hi){
        ll mid=(lo+hi)/2;
        if (arr[mid]<=x)
            lo=mid;
        else
            hi=mid;
    }
    return arr[lo]==x;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    sort(&arr[0],&arr[N]);
    for (int i=0;i<M;i++){
        ll a;
        cin >> a;
        cout << BinarySearch(a) << "\n";
    }
    return 0;
}