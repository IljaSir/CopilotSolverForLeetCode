class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        def bfs(time):
            queue = [(0, 0)]
            visited = set()
            while queue:
                new_queue = []
                for i, j in queue:
                    if (i, j) in visited:
                        continue
                    visited.add((i, j))
                    if i == m - 1 and j == n - 1:
                        return True
                    for x, y in (i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1):
                        if 0 <= x < m and 0 <= y < n and grid[x][y] <= time:
                            new_queue.append((x, y))
                queue = new_queue
            return False
        left, right = 0, m * n
        while left < right:
            mid = (left + right) // 2
            if bfs(mid):
                right = mid
            else:
                left = mid + 1
        return left