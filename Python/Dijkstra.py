import heapq

INF=10**9+7

class Edge:
    def __init__(self,idx,dst):
        self.idx=idx
        self.dst=dst
    def __lt__(self,other):
        return self.dst<other.dst

def Dijkstra(st):
    pq=[]
    heapq.heappush(pq,Edge(st,0))
    visited[st]=0
    while pq:
        top=heapq.heappop(pq)
        x,curr=top.idx,top.dst
        if curr>visited[x]:
            continue
        for edge in arr[x]:
            dx,next=edge.idx,edge.dst
            if visited[dx]>curr+next:
                visited[dx]=curr+next
                heapq.heappush(pq,Edge(dx,curr+next))

N,M,R=map(int,input().split())
arr=[[] for _ in range(N+1)]
visited=[INF]*(N+1)
for _ in range(M):
    a,b,c=map(int,input().split())
    arr[a].append(Edge(b,c))
    arr[b].append(Edge(a,c))
Dijkstra(R)
for i in range(1,N+1):
    if visited[i]!=INF:
        print(visited[i])
    else:
        print(-1)