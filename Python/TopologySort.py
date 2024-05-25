from collections import deque

def TopologySort():
    q=deque()
    for i in range(1,N+1):
        if indegree[i]==0:
            q.append(i)
    for i in range(N):
        if not q:
            print("-1")
            return
        x=q.popleft()
        ans.append(x)
        for dx in arr[x]:
            indegree[dx]-=1
            if indegree[dx]==0:
                q.append(dx)
    print(*ans)

N,M=map(int, input().split())
indegree=[0]*(N+1)
arr=[[] for _ in range(N+1)]
ans=[]
for _ in range(M):
    inputs=list(map(int, input().split()))
    for i in range(1,len(inputs)-1):
        a,b=inputs[i],inputs[i+1]
        arr[a].append(b)
        indegree[b]+=1
TopologySort()