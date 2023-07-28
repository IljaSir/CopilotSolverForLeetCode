class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        def canReach(grid, t):
            seen = set()
            n = len(grid)
            @lru_cache(None)
            def dfs(r, c):
                if r == n-1 and c == n-1:
                    return True
                if r < 0 or r >= n or c < 0 or c >= n or (r, c) in seen or grid[r][c] > t:
                    return False
                seen.add((r, c))
                return any(dfs(r+dr, c+dc) for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)])
            return dfs(0, 0)
        n = len(grid)
        lo, hi = grid[0][0], n*n-1
        while lo < hi:
            mi = (lo + hi) // 2
            if canReach(grid, mi):
                hi = mi
            else:
                lo = mi + 1
        return lo