#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M, R;
ll visited[1005];
vector<ll> arr[1005];
void BFS(ll st){
    queue<ll> q;
    q.push(st);
    visited[st]=0;
    while (!q.empty()){
        ll x=q.front();
        q.pop();
        for (int i=0;i<arr[x].size();i++){
            ll dx=arr[x][i];
            if (visited[dx]==-1){
                visited[dx]=visited[x]+1;
                q.push(dx);
            }
        }
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
    BFS(R);
    for (int i=1;i<=N;i++)
        cout << visited[i] << "\n";
    return 0;
}