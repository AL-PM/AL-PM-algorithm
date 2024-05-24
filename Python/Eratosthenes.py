def Eratosthenes():
    arr[1]=1
    for i in range(2, int(N**0.5)+1):
        if arr[i]==0:
            for j in range(i*i,N+1,i):
                arr[j]=1

N=int(input())
arr=[0]*(N+1)
Eratosthenes()
for i in range(1,N+1):
    if arr[i]==0:
        print(i)