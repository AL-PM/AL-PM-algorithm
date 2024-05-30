def BinarySearch(x):
    lo,hi=0,N
    while lo+1<hi:
        mid=(lo+hi)//2
        if arr[mid]<=x:
            lo=mid
        else:
            hi=mid
    return arr[lo]==x

N,M=map(int,input().split())
arr=list(map(int,input().split()))
arr.sort()
for a in list(map(int,input().split())):
    if BinarySearch(a):
        print("1")
    else:
        print("0")