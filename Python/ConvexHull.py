from collections import deque

class Dot:
    def __init__(self,x,y):
        self.x=x
        self.y=y

def CCW(a,b,c):
    return (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x)

def ConvexHull():
    for dot in arr:
        while len(CW)>=2 and CCW(CW[1],CW[0],dot)>=0:
            CW.popleft()
        CW.appendleft(dot)
        while len(ACW)>=2 and CCW(ACW[1],ACW[0],dot)<=0:
            ACW.popleft()
        ACW.appendleft(dot)
    return len(CW)+len(ACW)-2

N=int(input())
arr=[]
for _ in range(N):
    a,b=map(int,input().split())
    arr.append(Dot(a,b))
arr.sort(key=lambda dot: (dot.x,dot.y))
CW,ACW=deque(),deque()
print(ConvexHull())