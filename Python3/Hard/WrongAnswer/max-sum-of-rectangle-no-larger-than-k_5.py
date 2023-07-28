class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m, n = len(matrix), len(matrix[0])
        res = float('-inf')
        for i in range(n):
            total = [0] * m
            for j in range(i, n):
                for r in range(m):
                    total[r] += matrix[r][j]
                maxTotal, acc = float('-inf'), 0
                for t in total:
                    acc += t
                    if acc <= k:
                        maxTotal = max(maxTotal, acc)
                    else:
                        cur = 0
                        for p in total:
                            cur += p
                            if cur > maxTotal and cur <= k:
                                maxTotal = cur
                res = max(res, maxTotal)
        return res