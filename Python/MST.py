import heapq

class Edge:
    def __init__(self,x,y,dst):
        self.x=x
        self.y=y
        self.dst=dst
    def __lt__(self,other):
        return self.dst<other.dst

def Find(x):
    if x==arr[x]:
        return x
    arr[x]=Find(arr[x])
    return arr[x]

def Union(x, y):
    arr[Find(x)]=Find(y)

def Kruskal():
    ret=0
    while pq:
        top=heapq.heappop(pq)
        x,y,curr=top.x,top.y,top.dst
        if Find(x)==Find(y):
            continue
        Union(x,y)
        ret+=curr
    return ret

N,M=map(int,input().split())
arr=[i for i in range(N+1)]
pq=[]
for _ in range(M):
    a,b,c=map(int,input().split())
    heapq.heappush(pq,Edge(a,b,c))
print(Kruskal())