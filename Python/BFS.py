from collections import deque

def BFS(st):
    q=deque([st])
    visited[st]=0
    while q:
        x=q.popleft()
        for dx in arr[x]:
            if visited[dx]==-1:
                visited[dx]=visited[x]+1
                q.append(dx)

N, M, R=map(int,input().split())
arr=[[] for _ in range(N+1)]
visited=[-1]*(N+1)
for _ in range(M):
    a, b=map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
BFS(R)
for i in range(1, N+1):
    print(visited[i])