class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        if not mat or not mat[0]: return mat
        m, n = len(mat), len(mat[0])
        res = [[0] * n for _ in range(m)]
        queue = collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    res[i][j] = float('inf')
        while queue:
            i, j = queue.popleft()
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < m and 0 <= y < n and res[x][y] > res[i][j] + 1:
                    res[x][y] = res[i][j] + 1
                    queue.append((x, y))
        return res