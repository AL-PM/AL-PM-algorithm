# ConvexHull
---
## 알고리즘 설명

---
### 문제

2차원 평면에 $N$개의 점이 주어졌을 때, 이들 중 몇 개의 점을 골라 볼록 다각형을 만드는데, 나머지 모든 점을 내부에 포함하도록 할 수 있다. 이를 볼록 껍질이라 한다.

점의 집합이 주어졌을 때, 볼록 껍질을 이루는 점의 개수를 구하는 프로그램을 작성하라.

### 입력
첫째 줄에 점의 개수 $N$ $(3 ≤ N ≤ 10000)$이 주어진다.

둘째 줄부터 $N$개의 줄에 걸쳐 각 점의 좌표 $x$, $y$ $(-10000 ≤ x,y ≤ 10000)$가 빈 칸을 사이에 두고 주어진다.

주어지는 모든 점의 좌표는 다르며 입력으로 주어지는 다각형의 모든 점이 일직선을 이루는 경우는 없다.

### 출력
첫째 줄에 볼록 껍질을 이루는 점의 개수를 출력한다.

볼록 껍질의 변에 점이 여러 개 있는 경우에는 가장 양 끝 점만 개수에 포함한다.

---
### 예제 입력
```
8
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
```

### 예제 출력
```
5
```