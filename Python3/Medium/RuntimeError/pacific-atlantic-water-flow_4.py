class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        m, n = len(heights), len(heights[0])
        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]
        queue = collections.deque()
        for i in range(m):
            queue.append((i, 0))
            queue.append((i, n - 1))
            pacific[i][0] = True
            pacific[i][n - 1] = True
        for j in range(n):
            queue.append((0, j))
            queue.append((m - 1, j))
            pacific[0][j] = True
            pacific[m - 1][j] = True
        while queue:
            i, j = queue.popleft()
            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and not pacific[ni][nj] and heights[ni][nj] >= heights[i][j]:
                    queue.append((ni, nj))
                    pacific[ni][nj] = True
        for i in range(m):
            queue.append((i, 0))
            queue.append((i, n - 1))
            atlantic[i][0] = True
            atlantic[i][n - 1] = True
        for j in range(n):
            queue.append((0, j))
            queue.append((m - 1, j))
            atlantic[0][j] = True
            atlantic[m - 1][j] = True
        while queue:
            i, j = queue.popleft()
            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and not atlantic[ni][nj] and heights[ni][nj] >= heights[i][j]:
                    queue.append((ni, nj))
                    atlantic[ni][nj] = True
        ans = []
        for i in range(m):
            for j in range(n):
                if pacific