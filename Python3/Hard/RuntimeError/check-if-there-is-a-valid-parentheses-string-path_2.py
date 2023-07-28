class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m, n = len(grid), len(grid[0])
        directions = {
            1: [(-1, 0), (1, 0)],
            2: [(0, -1), (0, 1)],
            3: [(-1, 0), (0, 1)],
            4: [(1, 0), (0, 1)],
            5: [(-1, 0), (0, -1)],
            6: [(1, 0), (0, -1)],
        }
        def get_neighbors(i, j):
            if grid[i][j] == '/':
                if i == 0:
                    return [(i, j + 1)]
                if i == m - 1:
                    return [(i, j - 1)]
                if j == 0:
                    return [(i + 1, j)]
                if j == n - 1:
                    return [(i - 1, j)]
            if grid[i][j] == '\\':
                if i == 0:
                    return [(i, j - 1)]
                if i == m - 1:
                    return [(i, j + 1)]
                if j == 0:
                    return [(i - 1, j)]
                if j == n - 1:
                    return [(i + 1, j)]
            if grid[i][j] == ' ':
                return []
            return directions[int(grid[i][j])]
        q = [(0, 0)]
        visited = set()
        while q:
            i, j = q.pop()
            if i == m - 1 and j == n - 1:
                return True
            for di, dj in get_neighbors(i, j):
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and (ni, nj) not in visited:
                    q.append((ni, nj))
                    visited.add((ni, nj))
        return False