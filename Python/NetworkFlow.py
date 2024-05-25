from collections import deque

INF=10**9+7

def EdmondsKarp(st,ed):
    ret=0
    while True:
        visited=[-1]*(N+1)
        q=deque()
        q.append(st)
        visited[st]=st
        while q:
            x=q.popleft()
            for dx in arr[x]:
                if visited[dx]==-1 and capacity[x][dx]>flow[x][dx]:
                    q.append(dx)
                    visited[dx]=x
        if visited[ed]==-1:
            break
        mn=INF
        i=ed
        while i!=st:
            j=visited[i]
            mn=min(mn,capacity[j][i]-flow[j][i])
            i=j
        i=ed
        while i!=st:
            j=visited[i]
            flow[j][i]+=mn
            flow[i][j]-=mn
            i=j
        ret+=mn
    return ret

N,M,S,E=map(int, input().split())
capacity=[[0]*(N+1) for _ in range(N+1)]
flow=[[0]*(N+1) for _ in range(N+1)]
arr=[[] for _ in range(N+1)]
for _ in range(M):
    a,b,c=map(int, input().split())
    capacity[a][b]+=c
    capacity[b][a]+=c
    arr[a].append(b)
    arr[b].append(a)
print(EdmondsKarp(S,E))