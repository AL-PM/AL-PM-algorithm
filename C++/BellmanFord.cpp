#include <bits/stdc++.h>
#define ll long long
#define INF (1e9+7)
using namespace std;
struct Edge{ll st, ed, dst;};
ll N, M, K;
ll visited[1005];
vector<Edge> arr;
void BellmanFord(){
    for (int i=1;i<=N;i++){
        if (visited[i]==INF){
            visited[i]=0;
            for (int j=0;j<N;j++){
                for (int k=0;k<arr.size();k++){
                    if (visited[arr[k].st]==INF)
                        continue;
                    visited[arr[k].ed]=min(visited[arr[k].ed],visited[arr[k].st]+arr[k].dst);
                }
            }
            for (int j=0;j<arr.size();j++){
                if (visited[arr[j].st]==INF)
                    continue;
                if (visited[arr[j].ed]>visited[arr[j].st]+arr[j].dst){
                    cout << "Yes\n";
                    return ;
                }
            }
        }
    }
    cout << "No\n";
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    fill(&visited[0],&visited[N+1],INF);
    for (int i=0;i<M;i++){
        ll a, b, c;
        cin >> a >> b >> c;
        arr.push_back({a,b,c});
    }
    BellmanFord();
    return 0;
}