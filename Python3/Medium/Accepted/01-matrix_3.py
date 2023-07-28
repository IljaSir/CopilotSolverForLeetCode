class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        q = collections.deque()
        m, n = len(mat), len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = float('inf')
        while q:
            i, j = q.popleft()
            for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and mat[ni][nj] > mat[i][j] + 1:
                    mat[ni][nj] = mat[i][j] + 1
                    q.append((ni, nj))
        return mat