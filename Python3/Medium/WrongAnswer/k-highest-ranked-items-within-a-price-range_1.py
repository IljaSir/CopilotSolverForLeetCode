class Solution:
    def highestRankedKItems(self, grid: List[List[int]], pricing: List[int], start: List[int], k: int) -> List[List[int]]:
        
        
        m, n = len(grid), len(grid[0])
        low, high = pricing
        row, col = start
        queue = [(0, row, col)]
        visited = set()
        ans = []
        while queue:
            dist, x, y = heapq.heappop(queue)
            if grid[x][y] > high:
                continue
            if grid[x][y] >= low:
                ans.append((dist, grid[x][y], x, y))
            if len(ans) == k:
                break
            for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] and (nx, ny) not in visited:
                    heapq.heappush(queue, (dist + 1, nx, ny))
                    visited.add((nx, ny))
        return sorted(ans, key=lambda x: (-x[0], x[1], x[2], x[3]))[:k]