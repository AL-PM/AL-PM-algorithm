import sys
sys.setrecursionlimit(10**6)

def DFS(x):
    visited[x]=1
    for y in v[x]:
        if match[y]==-1 or (not visited[match[y]] and DFS(match[y])):
            match[y]=x
            return 1
    return 0

def BipartiteMatching():
    ret=0
    for i in range(N):
        visited.clear()
        visited.extend([0]*1005)
        if DFS(i):
            ret+=1
    return ret

N,M=map(int,input().split())
match=[-1]*1005
visited=[0]*1005
v=[[] for _ in range(1005)]
for i in range(N):
    tmp=list(map(int,input().split()))[1:]
    v[i].extend(tmp)
print(BipartiteMatching())