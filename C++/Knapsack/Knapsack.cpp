#include <bits/stdc++.h>
#define ll long long
using namespace std;
struct Item{ll weight, value;};
ll N, M;
ll DP[105][1005];
vector<Item> arr;
ll Knapsack(){
    ll ret=0;
    for (int i=0;i<N;i++){
        ll w=arr[i].weight, v=arr[i].value;
        for (int j=0;j<=M;j++){
            if (j<w)
                DP[i+1][j]=DP[i][j];
            else
                DP[i+1][j]=max(DP[i][j],DP[i][j-w]+v);
        }
    }
    for (int i=0;i<=M;i++)
        ret=max(ret,DP[N][i]);
    return ret;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<N;i++){
        ll a, b;
        cin >> a >> b;
        arr.push_back({a,b});
    }
    cout << Knapsack();
    return 0;
}