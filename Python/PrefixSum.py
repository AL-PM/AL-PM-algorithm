INF=10**9+7

def PrefixSum():
    for i in range(1, N):
        sum[i]=arr[i-1]+sum[i-1]

N, M=map(int, input().split())
arr=list(map(int, input().split()))
sum=[0]*(N+1)
ans=-INF
PrefixSum()
for i in range(N-M+1):
    ans=max(ans,sum[i+M]-sum[i])
print(ans)