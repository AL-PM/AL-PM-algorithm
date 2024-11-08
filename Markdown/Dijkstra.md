# Dijkstra
---
## 알고리즘 설명

---
### 문제
정점이 $N$개, 간선이 $M$개인 그래프가 주어졌을 때, 시작점 $R$에서 다른 모든 정점까지의 거리를 구하라.

### 입력
첫째줄에 정점의 수 $N$ $(1 ≤ N ≤ 1000)$, 간선의 수 $M$ $(0 ≤ M ≤ 2500)$, 시작 정점 $R$ $(1 ≤ R ≤ N)$이 주어진다.

다음 $M$개 줄에 간선 정보 $u$, $v$, $w$ $(1 ≤ u < v ≤ N, u ≠ v, 1 ≤ w ≤ 10000)$가 주어지며 이는 정점 $u$와 정점 $v$간의 가중치 $w$인 양방향 간선을 나타낸다. 

주어지는 모든 간선 $(u, v, w)$ 쌍의 값은 서로 다르다.

### 출력
첫째 줄부터 $N$개의 줄에 정수를 한 개씩 출력한다. $i$번째 줄에는 정점 $R$에서 $i$까지의 거리를 출력한다.

이때 시작 정점 $R$까지의 거리는 0이고 방문 되지 않는 정점까지의 거리는 -1로 출력하자.

---
### 예제 입력
```
5 5 1
1 3 2
2 4 3
4 1 4
1 2 7
2 3 1
```

### 예제 출력
```
0
3
2
4
-1
```