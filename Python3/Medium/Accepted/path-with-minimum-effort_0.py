class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        def check(mid):
            visited = set()
            def dfs(i, j):
                if i == m-1 and j == n-1:
                    return True
                visited.add((i, j))
                for x, y in dirs:
                    nx, ny = i+x, j+y
                    if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited and abs(heights[nx][ny] - heights[i][j]) <= mid and dfs(nx, ny):
                        return True
                return False
            return dfs(0, 0)
        l, r = 0, 10**6
        while l < r:
            mid = l + (r - l) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l