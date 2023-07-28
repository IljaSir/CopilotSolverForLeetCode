class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        q = [(0, 0, 0)]
        res = 0
        visited = set()
        while q:
            tmp = []
            for i, j, t in q:
                if i == m - 1 and j == n - 1:
                    return t
                for x, y in ((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)):
                    if 0 <= x < m and 0 <= y < n and grid[x][y] <= t + 1 and (x, y) not in visited:
                        tmp.append((x, y, t + 1))
                        visited.add((x, y))
            q = tmp
        return -1