class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        q = [(grid[0][0], 0, 0)]
        visited = set([(0, 0)])
        ans = 0
        while q:
            h, i, j = heapq.heappop(q)
            ans = max(ans, h)
            if i == j == n - 1:
                return ans
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < n and 0 <= y < n and (x, y) not in visited:
                    visited.add((x, y))
                    heapq.heappush(q, (grid[x][y], x, y))