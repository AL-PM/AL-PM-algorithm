def Backtrack(depth):
    if depth==M:
        print(*arr)
        return
    for i in range(1, N+1):
        if not visited[i]:
            visited[i]=1
            arr.append(i)
            Backtrack(depth+1)
            visited[i]=0
            arr.pop()

N, M=map(int,input().split())
visited=[0]*(N+1)
arr=[]
Backtrack(0)