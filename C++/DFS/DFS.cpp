#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M, R;
ll visited[1005];
vector<ll> arr[1005];
void DFS(ll x, ll depth){
    visited[x]=depth;
    for (int i=0;i<arr[x].size();i++){
        ll dx=arr[x][i];
        if (visited[dx]==-1)
            DFS(dx, depth+1);
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> R;
    for (int i=0;i<M;i++){
        ll a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }
    fill(&visited[0],&visited[N+1],-1);
    DFS(R, 0);
    for (int i=1;i<=N;i++)
        cout << visited[i] << "\n";
    return 0;
}