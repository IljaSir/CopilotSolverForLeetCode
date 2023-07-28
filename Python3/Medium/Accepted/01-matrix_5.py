class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        m, n = len(mat), len(mat[0])
        queue = collections.deque([(i, j) for i in range(m) for j in range(n) if mat[i][j] == 0])
        dist = [[0] * n for _ in range(m)]
        while queue:
            i, j = queue.popleft()
            for x, y in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):
                if 0 <= x < m and 0 <= y < n and dist[x][y] == 0 and mat[x][y] == 1:
                    dist[x][y] = dist[i][j] + 1
                    queue.append((x, y))
        return dist