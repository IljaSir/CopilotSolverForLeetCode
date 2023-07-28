class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        m, n = len(heights), len(heights[0])
        pacific = set()
        atlantic = set()
        for i in range(m):
            pacific.add((i, 0))
            atlantic.add((i, n - 1))
        for j in range(n):
            pacific.add((0, j))
            atlantic.add((m - 1, j))
        def bfs(sea):
            while sea:
                i, j = sea.pop()
                for x, y in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
                    if 0 <= x < m and 0 <= y < n and (x, y) not in visited and heights[x][y] >= heights[i][j]:
                        visited.add((x, y))
                        sea.add((x, y))
        visited = set()
        bfs(pacific)
        pacific = visited
        visited = set()
        bfs(atlantic)
        atlantic = visited
        return list(pacific & atlantic)