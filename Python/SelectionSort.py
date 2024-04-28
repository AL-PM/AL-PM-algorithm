def BubbleSort(arr):
    for i in range(len(arr)-1,0,-1):
        for j in range(i):
            if arr[j]>arr[j+1]:
                arr[j],arr[j+1] = arr[j+1],arr[j]

def SelectionSort(arr):
    for i in range(len(arr)):
        mn=i
        for j in range(i+1,len(arr)):
            if arr[mn] > arr[j]:
                mn=j
        if i!=mn:
            arr[i],arr[mn]=arr[mn],arr[i]
N = int(input())
arr = list(map(int, input().split()))
SelectionSort(arr)
print(*arr)