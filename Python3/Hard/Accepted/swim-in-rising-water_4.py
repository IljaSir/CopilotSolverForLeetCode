class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def check(t):
            seen = set()
            def dfs(x,y):
                if x == n-1 and y == n-1:
                    return True
                seen.add((x,y))
                for x2,y2 in (x+1,y),(x-1,y),(x,y+1),(x,y-1):
                    if 0 <= x2 < n and 0 <= y2 < n and (x2,y2) not in seen and grid[x2][y2] <= t:
                        if dfs(x2,y2):
                            return True
                return False
            return dfs(0,0)
        lo,hi = grid[0][0],n*n-1
        while lo < hi:
            mi = (lo+hi)//2
            if check(mi):
                hi = mi
            else:
                lo = mi+1
        return lo