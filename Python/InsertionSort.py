def InsertionSort(arr):
    for i in range(1,len(arr)):
        tmp=arr[i]
        now=i-1
        while now>=0 and arr[now]>tmp:
            arr[now+1]=arr[now]
            now-=1
        arr[now+1]=tmp

N=int(input())
arr=list(map(int,input().split()))
InsertionSort(arr)
print(*arr)