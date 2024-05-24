import sys
sys.setrecursionlimit(10**6)

def DFS(x,depth):
    visited[x]=depth
    for dx in arr[x]:
        if visited[dx]==-1:
            DFS(dx, depth+1)

N,M,R=map(int,input().split())
arr=[[] for _ in range(N+1)]
visited=[-1]*(N+1)
for _ in range(M):
    a,b=map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
DFS(R,0)
for i in range(1,N+1):
    print(visited[i])