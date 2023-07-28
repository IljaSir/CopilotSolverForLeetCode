class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        m = len(grid[0])
        queue = [(0, 0, grid[0][0])]
        visited = set()
        while queue:
            time, x, y = heapq.heappop(queue)
            if x == n - 1 and y == m - 1:
                return time
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and (nx, ny) not in visited:
                    heapq.heappush(queue, (max(time, grid[nx][ny]), nx, ny))
                    visited.add((nx, ny))
        return -1