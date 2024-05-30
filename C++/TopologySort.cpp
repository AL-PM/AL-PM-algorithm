#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N, M, indegree[1005];
vector<ll> arr[1005], ans;
void TopologySort(){
    queue<ll> q;
    for (int i=1;i<=N;i++){
        if (indegree[i]==0)
            q.push(i);
    }
    for (int i=0;i<N;i++){
        if (q.empty()){
            cout << "-1";
            return;
        }
        ll x=q.front();
        q.pop();
        ans.push_back(x);
        for (auto dx:arr[x]){
            if (--indegree[dx]==0)
                q.push(dx);
        }
    }
    for (auto x:ans)
        cout << x << " ";
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i=0;i<M;i++){
        ll a, b, c;
        cin >> a;
        for (int j=0;j<a;j++){
            c=b;
            cin >> b;
            if (!j)
                continue;
            arr[c].push_back(b);
            indegree[b]++;
        }
    }
    TopologySort();
    return 0;
}