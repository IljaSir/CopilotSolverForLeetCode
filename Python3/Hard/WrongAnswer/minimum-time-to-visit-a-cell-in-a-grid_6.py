class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        # BFS
        # Time  complexity: O(N * M)
        # Space complexity: O(N * M)
        N, M = len(grid), len(grid[0])
        q = [(0, 0, grid[0][0])]
        seen = set()
        while q:
            t, i, j = heapq.heappop(q)
            if (i, j) in seen: continue
            seen.add((i, j))
            if i == j == N - 1:
                return t
            for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < N and 0 <= nj < M:
                    heapq.heappush(q, (max(t, grid[ni][nj]), ni, nj))
        return -1