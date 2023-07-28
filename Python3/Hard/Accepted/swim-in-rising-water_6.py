class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def bfs(t):
            q = [(0,0)]
            seen = set()
            while q:
                i,j = q.pop()
                if (i,j) in seen:
                    continue
                seen.add((i,j))
                for di,dj in [(0,1),(1,0),(0,-1),(-1,0)]:
                    ni,nj = i+di,j+dj
                    if 0<=ni<n and 0<=nj<n and grid[ni][nj]<=t:
                        q.append((ni,nj))
            return (n-1,n-1) in seen
        l,r = grid[0][0],n*n-1
        while l<r:
            m = (l+r)//2
            if bfs(m):
                r = m
            else:
                l = m+1
        return l