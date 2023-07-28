class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def check(t):
            seen = set()
            def dfs(x, y):
                if not 0 <= x < n or not 0 <= y < n or grid[x][y] > t or (x, y) in seen:
                    return False
                if x == y == n - 1:
                    return True
                seen.add((x, y))
                return dfs(x + 1, y) or dfs(x - 1, y) or dfs(x, y + 1) or dfs(x, y - 1)
            return dfs(0, 0)
        l, r = grid[0][0], n * n
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l