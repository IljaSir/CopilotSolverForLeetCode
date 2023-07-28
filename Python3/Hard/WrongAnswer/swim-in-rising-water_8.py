class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        # print(n)
        def check(t):
            queue = [(0,0)]
            visited = set()
            while queue:
                x,y = queue.pop(0)
                if (x,y) == (n-1,n-1):
                    return True
                for i,j in ((x-1,y),(x+1,y),(x,y-1),(x,y+1)):
                    if 0 <= i < n and 0 <= j < n and grid[i][j] <= t and (i,j) not in visited:
                        queue.append((i,j))
                        visited.add((i,j))
            return False
        l,r = 0,n*n
        while l < r:
            mid = (l+r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l