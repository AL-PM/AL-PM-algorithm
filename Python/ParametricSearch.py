def chk(x):
    cnt=0
    for i in range(N):
        cnt+=arr[i]//x
    return cnt>=M

def ParametricSearch():
    lo,hi=0,max(arr)+1
    while lo+1<hi:
        mid=(lo+hi)//2
        if chk(mid):
            lo=mid
        else:
            hi=mid
    return lo

N,M=map(int,input().split())
arr=list(map(int,input().split()))
print(ParametricSearch())