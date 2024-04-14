#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N;
ll arr[1005];
void Eratosthenes(){
    arr[1]=1;
    for (int i=2;i*i<=N;i++){
        if (arr[i]==0){
            for (int j=i*i;j<=N;j+=i)
                arr[j]=1;
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    Eratosthenes();
    for (int i=1;i<=N;i++){
        if (arr[i]==0)
            cout << i << "\n";
    }
    return 0;
}