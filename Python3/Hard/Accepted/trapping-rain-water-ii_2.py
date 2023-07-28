class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        
        from heapq import heappush, heappop
        m, n = len(heightMap), len(heightMap[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        heap = []
        for i in range(m):
            heappush(heap, (heightMap[i][0], i, 0))
            heappush(heap, (heightMap[i][n-1], i, n-1))
            visited[i][0] = True
            visited[i][n-1] = True
        for j in range(1, n-1):
            heappush(heap, (heightMap[0][j], 0, j))
            heappush(heap, (heightMap[m-1][j], m-1, j))
            visited[0][j] = True
            visited[m-1][j] = True
        res = 0
        while heap:
            h, i, j = heappop(heap)
            for di, dj in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and not visited[ni][nj]:
                    visited[ni][nj] = True
                    res += max(0, h - heightMap[ni][nj])
                    heappush(heap, (max(h, heightMap[ni][nj]), ni, nj))
        return res