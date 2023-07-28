class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        m = len(matrix)
        n = len(matrix[0])
        #print(m, n)
        res = []
        i, j = 0, 0
        while i < m and j < n:
            #print(i, j)
            for k in range(j, n):
                res.append(matrix[i][k])
            i += 1
            for k in range(i, m):
                res.append(matrix[k][n-1])
            n -= 1
            if i < m:
                for k in range(n-1, j-1, -1):
                    res.append(matrix[m-1][k])
                m -= 1
            if j < n:
                for k in range(m-1, i-1, -1):
                    res.append(matrix[k][j])
                j += 1
        return res