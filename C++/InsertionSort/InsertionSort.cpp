#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N;
ll arr[1005];
void InsertionSort(){
    for (int i=1;i<N;i++){
        ll tmp=arr[i], now;
        for(now=i-1;now>=0;now--){
            if (arr[now]<tmp)
                break;
            arr[now+1]=arr[now];
        }
        arr[now+1]=tmp;
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    InsertionSort();
    for (int i=0;i<N;i++)
        cout << arr[i] << " ";
    return 0;
}