class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m, n = len(matrix), len(matrix[0])
        res = float('-inf')
        for i in range(m):
            total = [0] * n
            for j in range(i, m):
                for c in range(n):
                    total[c] += matrix[j][c]
                res = max(res, self.maxSumSubarray(total, k))
        return res