#include <bits/stdc++.h>
#define ll long long
#define INF (1e9+7)
using namespace std;
ll N;
ll arr[1005], sum[1005];
ll TwoPointer(){
    ll L=0, R=1, ret=-INF;
    while (L<=N && R<=N){
        ret=max(ret,sum[R]-sum[L]);
        if (sum[R]-sum[L]<0){
            L=R;
            R++;
        }
        else
            R++;
    }
    return ret;
}
void PrefixSum(){
    for (int i=0;i<N;i++)
        sum[i+1]=arr[i]+sum[i];
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    PrefixSum();
    cout << TwoPointer();
    return 0;
}