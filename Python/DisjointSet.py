def Find(x):
    if x==arr[x]:
        return x
    arr[x]=Find(arr[x])
    return arr[x]

def Union(x, y):
    arr[Find(x)]=Find(y)

N, M=map(int, input().split())
arr=[i for i in range(1005)]
for i in range(1005):
    arr[i]=i
for _ in range(M):
    x, a, b=map(int, input().split())
    if x:
        if Find(a)==Find(b):
            print("Yes")
        else:
            print("No")
    else:
        Union(a, b)