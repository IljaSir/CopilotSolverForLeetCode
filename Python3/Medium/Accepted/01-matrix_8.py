class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        m, n = len(mat), len(mat[0])
        res = [[0 for _ in range(n)] for _ in range(m)]
        q = collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    res[i][j] = 10000
        while q:
            i, j = q.popleft()
            for x, y in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                if 0 <= i+x < m and 0 <= j+y < n:
                    if res[i+x][j+y] > res[i][j] + 1:
                        res[i+x][j+y] = res[i][j] + 1
                        q.append((i+x, j+y))
        return res