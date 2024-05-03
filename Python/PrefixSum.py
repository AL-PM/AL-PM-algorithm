INF=10**9+7

def PrefixSum():
    for i in range(0, N):
        sum[i+1]=arr[i]+sum[i]

N, M=map(int, input().split())
arr=list(map(int, input().split()))
sum=[0]*(N+1)
ans=-INF
PrefixSum()
for i in range(N-M+1):
    ans=max(ans,sum[i+M]-sum[i])
print(ans)