def BubbleSort(arr):
    for i in range(len(arr)-1,0,-1):
        for j in range(i):
            if arr[j]>arr[j+1]:
                arr[j],arr[j+1]=arr[j+1],arr[j]

N = int(input())
arr = list(map(int, input().split()))
BubbleSort(arr)
print(*arr)