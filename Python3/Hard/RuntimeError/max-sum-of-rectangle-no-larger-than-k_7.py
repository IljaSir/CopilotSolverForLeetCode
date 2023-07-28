class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        result = float('-inf')
        for i in range(m):
            sums = [0] * n
            for j in range(i, m):
                for c in range(n):
                    sums[c] += matrix[j][c]
                result = max(result, self.maxSumSubarray(sums, k))
        return result