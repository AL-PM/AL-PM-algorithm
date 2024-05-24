import sys

INF=10**9+7

class Edge:
    def __init__(self,st,ed,dst):
        self.st=st
        self.ed=ed
        self.dst=dst

def BellmanFord():
    for i in range(1, N+1):
        if visited[i]==INF:
            visited[i]=0
            for _ in range(N):
                for j in arr:
                    if visited[j.st]==INF:
                        continue
                    visited[j.ed]=min(visited[j.ed], visited[j.st]+j.dst)
            for j in arr:
                if visited[j.st]==INF:
                    continue
                if visited[j.ed]>visited[j.st]+j.dst:
                    print("Yes")
                    return
    print("No")

N,M=map(int, input().split())
visited=[INF]*(N+1)
arr=[]
for _ in range(M):
    a,b,c=map(int,input().split())
    arr.append(Edge(a,b,c))
BellmanFord()