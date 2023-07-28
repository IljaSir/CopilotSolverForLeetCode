class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        heap = [(grid[0][0], 0, 0)]
        visited = set()
        while heap:
            t, x, y = heapq.heappop(heap)
            if (x, y) == (n-1, n-1):
                return t
            visited.add((x, y))
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited:
                    heapq.heappush(heap, (max(t, grid[nx][ny]), nx, ny))