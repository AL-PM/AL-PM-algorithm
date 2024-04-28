#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M, match[1005], visited[1005];
vector<ll> v[1005];
ll DFS(ll x){
    visited[x]=1;
    for (auto y:v[x]){
        if (match[y]==-1 || (!visited[match[y]] && DFS(match[y]))){
            match[y]=x;
            return 1;
        }
    }
    return 0;
}
ll BipartiteMatching(){
    ll ret=0;
    fill(&match[0],&match[1004],-1);
    for (int i=0;i<N;i++){
        fill(&visited[0],&visited[1004],0);
        if (DFS(i))
            ret++;
    }
    return ret;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<N;i++){
        ll a, b;
        cin >> a;
        for (int j=0;j<a;j++){
            cin >> b;
            v[i].push_back(b);
        }
    }
    cout << BipartiteMatching();
    return 0;
}