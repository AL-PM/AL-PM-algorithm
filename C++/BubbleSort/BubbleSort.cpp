#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N; // 원소의 개수
ll arr[1005];
void BubbleSort(){
    for (int i=N-1;i>0;i--){
        for (int j=0;j<i;j++){
            if (arr[j]>arr[j+1]){
                ll tmp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=tmp;
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    BubbleSort();
    for (int i=0;i<N;i++)
        cout << arr[i] << " ";
    return 0;
}