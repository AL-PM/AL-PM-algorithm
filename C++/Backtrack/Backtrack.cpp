#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N;
ll visited[1005];
vector<ll> arr;
void Backtrack(ll depth){
    if (depth==N){
        for (auto x:arr)
            cout << x << " ";
        cout << "\n";
        return;
    }
    for (int i=1;i<=N;i++){
        if (visited[i]==0){
            visited[i]=1;
            arr.push_back(i);
            Backtrack(depth+1);
            visited[i]=0;
            arr.pop_back();
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    Backtrack(0);
    return 0;
}