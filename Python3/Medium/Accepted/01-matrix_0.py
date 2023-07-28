class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        m, n = len(mat), len(mat[0])
        q = collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1
        while q:
            x, y = q.popleft()
            for dx, dy in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and mat[nx][ny] == -1:
                    mat[nx][ny] = mat[x][y] + 1
                    q.append((nx, ny))
        return mat