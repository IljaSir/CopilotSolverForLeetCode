class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(1, n):
                matrix[i][j] += matrix[i][j - 1]
        res = float('-inf')
        for i in range(n):
            for j in range(i, n):
                s = set()
                s.add(0)
                cur = 0
                for row in range(m):
                    cur += matrix[row][j] - (matrix[row][i - 1] if i > 0 else 0)
                    it = bisect.bisect_left(s, cur - k)
                    if it < len(s):
                        res = max(res, cur - s[it])
                    bisect.insort(s, cur)
        return res