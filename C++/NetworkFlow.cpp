#include <bits/stdc++.h>
#define ll long long
#define INF (1e9+7)
using namespace std;
ll N, M, S, E;
ll capacity[1005][1005], flow[1005][1005], visited[1005];
vector<ll> arr[1005];
ll EdmondsKarp(ll st, ll ed){
    ll ret=0;
    while (1){
        fill(&visited[0],&visited[1004],-1);
        queue<ll> q;
        q.push(st);
        visited[st]=st;
        while (!q.empty()){
            ll x=q.front();
            q.pop();
            for (int i=0;i<arr[x].size();i++){
                ll dx=arr[x][i];
                if (visited[dx]==-1 && capacity[x][dx]>flow[x][dx]){
                    q.push(dx);
                    visited[dx]=x;
                }
            }
        }
        if (visited[ed]==-1)
            break;
        ll mn=INF;
        for (int i=ed, j;i!=st;i=j){
            j=visited[i];
            mn=min(mn,capacity[j][i]-flow[j][i]);
        }
        for (int i=ed, j;i!=st;i=j){
            j=visited[i];
            flow[j][i]+=mn;
            flow[i][j]-=mn;
        }
        ret+=mn;
    }
    return ret;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> S >> E;
    for (int i=0;i<M;i++){
        ll a, b, c;
        cin >> a >> b >> c;
        capacity[a][b]+=c;
        capacity[b][a]+=c;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }
    cout << EdmondsKarp(M, K);
    return 0;
}