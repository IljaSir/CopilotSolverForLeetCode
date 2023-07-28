class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            for j in range(1,m):
                matrix[i][j] += matrix[i][j-1]
        ans = 0
        for i in range(m):
            for j in range(i,m):
                d = {0:1}
                cur = 0
                for k in range(n):
                    cur += matrix[k][j] - (matrix[k][i-1] if i > 0 else 0)
                    ans += d.get(cur - target, 0)
                    d[cur] = d.get(cur, 0) + 1
        return ans