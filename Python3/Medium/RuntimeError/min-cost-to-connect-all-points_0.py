class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        
        n = len(points)
        dist = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                dist[i][j] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
        res = 0
        seen = {0}
        heap = [(0, 0)]
        while len(seen) < n:
            d, i = heapq.heappop(heap)
            if i in seen: continue
            seen.add(i)
            res += d
            for j in range(n):
                if j not in seen:
                    heapq.heappush(heap, (dist[i][j], j))
        return res