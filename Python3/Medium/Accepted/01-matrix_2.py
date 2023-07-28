class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        q = collections.deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = float('inf')
        while q:
            i, j = q.popleft()
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < len(mat) and 0 <= y < len(mat[0]) and mat[x][y] > mat[i][j] + 1:
                    mat[x][y] = mat[i][j] + 1
                    q.append((x, y))
        return mat