class Item:
    def __init__(self,weight,value):
        self.weight=weight
        self.value=value

def Knapsack():
    DP=[[0]*(M+1) for _ in range(N+1)]
    ret=0
    for i in range(N):
        w=arr[i].weight
        v=arr[i].value
        for j in range(M+1):
            if j<w:
                DP[i+1][j]=DP[i][j]
            else:
                DP[i+1][j]=max(DP[i][j],DP[i][j-w]+v)
    for i in range(M+1):
        ret=max(ret,DP[N][i])
    return ret

N,M=map(int,input().split())
arr=[]
for _ in range(N):
    a,b=map(int,input().split())
    arr.append(Item(a,b))
print(Knapsack())