import sys
sys.setrecursionlimit(10**6)

def query(n,l,r,st,ed):
    if l>ed or r<st:
        return 0
    if l>=st and r<=ed:
        return seg_tree[n]
    mid=(l+r)//2
    return query(n*2,l,mid,st,ed)+query(n*2+1,mid+1,r,st,ed)

def update(n,l,r,pos,x):
    if l>pos or r<pos:
        return seg_tree[n]
    if l==r:
        seg_tree[n]=x
        return x
    mid=(l+r)//2
    seg_tree[n]=update(n*2,l,mid,pos,x)+update(n*2+1,mid+1,r,pos,x)
    return seg_tree[n]

def init(n,l,r):
    if l==r:
        seg_tree[n]=arr[l]
        return arr[l]
    mid=(l+r)//2
    seg_tree[n]=init(n*2,l,mid)+init(n*2+1,mid+1,r)
    return seg_tree[n]

N,M=map(int,input().split())
arr=[0]+list(map(int, input().split()))
seg_tree=[0]*(4*N)
init(1,1,N)
for _ in range(M):
    x,a,b=map(int,input().split())
    if x:
        print(query(1,1,N,a,b))
    else:
        update(1,1,N,a,b)