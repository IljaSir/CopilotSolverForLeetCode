class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m,n = len(matrix), len(matrix[0])
        res = float('-inf')
        for i in range(m):
            rowsum = [0]*n
            for j in range(i,m):
                for c in range(n):
                    rowsum[c] += matrix[j][c]
                res = max(res, self.maxSubArray(rowsum, k))
        return res