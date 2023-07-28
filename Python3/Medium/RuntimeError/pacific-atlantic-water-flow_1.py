class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        if not heights or not heights[0]:
            return []
        m, n = len(heights), len(heights[0])
        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]
        for i in range(m):
            self.dfs(heights, pacific, i, 0, heights[i][0])
            self.dfs(heights, atlantic, i, n - 1, heights[i][n - 1])
        for j in range(n):
            self.dfs(heights, pacific, 0, j, heights[0][j])
            self.dfs(heights, atlantic, m - 1, j, heights[m - 1][j])
        res = []
        for i in range(m):
            for j in range(n):
                if pacific[i][j] and atlantic[i][j]:
                    res.append([i, j])
        return res