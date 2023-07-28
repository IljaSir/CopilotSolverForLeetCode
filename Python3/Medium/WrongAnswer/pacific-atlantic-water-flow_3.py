class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        if not heights:
            return []
        m, n = len(heights), len(heights[0])
        pacific = set()
        atlantic = set()
        for i in range(m):
            pacific.add((i, 0))
            atlantic.add((i, n-1))
        for i in range(n):
            pacific.add((0, i))
            atlantic.add((m-1, i))
        def dfs(i, j, visited):
            visited.add((i, j))
            for x, y in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):
                if 0 <= x < m and 0 <= y < n and (x, y) not in visited and heights[x][y] >= heights[i][j]:
                    dfs(x, y, visited)
        dfs(0, 0, pacific)
        dfs(m-1, n-1, atlantic)
        return pacific & atlantic