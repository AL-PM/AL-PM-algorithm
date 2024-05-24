INF=10**9+7

def TwoPointer():
    L,R=0,1
    ret=-INF
    while L<=N and R<=N:
        ret=max(ret,sum[R]-sum[L])
        if sum[R]-sum[L]<0:
            L=R
            R+=1
        else:
            R+=1
    return ret

def PrefixSum():
    for i in range(N):
        sum[i+1]=arr[i]+sum[i]

N=int(input())
arr=list(map(int,input().split()))
sum=[0]*(N+1)
PrefixSum()
print(TwoPointer())