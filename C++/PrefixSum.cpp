#include <bits/stdc++.h>
#define ll long long
#define INF (1e9+7)
using namespace std;
ll N, M, ans=-INF;
ll arr[1005], sum[1005];
void PrefixSum(){
    for (int i=1;i<=N;i++)
        sum[i]=arr[i-1]+sum[i-1];
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    PrefixSum();
    for (int i=0;i<=N-M;i++)
        ans=max(ans,sum[i+M]-sum[i]);
    cout << ans;
    return 0;
}