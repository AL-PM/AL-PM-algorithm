class Dot:
    def __init__(self, x, y):
        self.x=x
        self.y=y
    def __gt__(self, other):
        if self.x!=other.x:
            return self.x>other.x
        return self.y>other.y

def CCW(a,b,c):
    ret=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x)
    if ret>0:
        return 1
    elif ret<0:
        return -1
    return 0

def LineIntersection(a,b,c,d):
    ab=CCW(a,b,c)*CCW(a,b,d)
    cd=CCW(c,d,a)*CCW(c,d,b)
    if ab==0 and cd==0:
        if a>b:
            a,b=b,a
        if c>d:
            c,d=d,c
        return not (c>b or a>d)
    return ab<=0 and cd<=0

arr=[]
for _ in range(2):
    a,b,c,d=map(int, input().split())
    arr.append(Dot(a,b))
    arr.append(Dot(c,d))
if LineIntersection(arr[0],arr[1],arr[2],arr[3]):
    print(1)
else:
    print(0)