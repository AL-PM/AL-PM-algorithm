#include <bits/stdc++.h>
#define ll long long
#define INF (1e9+7)
using namespace std;
struct Edge{ll idx, dst;};
bool operator<(Edge x, Edge y){
    return x.dst>y.dst;
}
ll N, M, R;
ll visited[1005];
vector<Edge> arr[1005];
void Dijkstra(ll st){
    priority_queue<Edge> pq;
    pq.push({st,0});
    visited[st]=0;
    while (!pq.empty()){
        ll x=pq.top().idx, curr=pq.top().dst;
        pq.pop();
        if (curr>visited[x])
            continue;
        for (int i=0;i<arr[x].size();i++){
            ll dx=arr[x][i].idx, next=arr[x][i].dst;
            if (visited[dx]>curr+next){
                visited[dx]=curr+next;
                pq.push({dx,curr+next});
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> R;
    for (int i=0;i<M;i++){
        ll a, b, c;
        cin >> a >> b >> c;
        arr[a].push_back({b,c});
        arr[b].push_back({a,c});
    }
    fill(&visited[0],&visited[N+1],INF);
    Dijkstra(R);
    for (int i=1;i<=N;i++){
        if (visited[i]!=INF)
            cout << visited[i] << "\n";
        else
            cout << "-1\n";
    }
    return 0;
}