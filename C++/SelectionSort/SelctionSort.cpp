#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll N;
ll arr[1005];
void SelectionSort(){
    for (int i=0;i<N;i++){
        ll mn=i;
        for (int j=i+1;j<N;j++){
            if (arr[mn]>arr[j])
                mn=j;
        }
        if (i!=mn){
            ll tmp=arr[i];
            arr[i]=arr[mn];
            arr[mn]=tmp;
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i=0;i<N;i++)
        cin >> arr[i];
    SelectionSort();
    for (int i=0;i<N;i++)
        cout << arr[i] << " ";
    return 0;
}