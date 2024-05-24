def BinarySearch(x):
    lo,hi=0,N-1
    while lo<=hi:
        mid=(lo+hi)//2
        if arr[mid]<x:
            lo=mid+1
        elif arr[mid]>x:
            hi=mid-1
        else:
            return 1
    return 0

N,M=map(int,input().split())
arr=list(map(int,input().split()))
arr.sort()
for a in list(map(int,input().split())):
    print(BinarySearch(a))