class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        if m > n:
            return self.maxSumSubmatrix([*zip(*matrix)], k)
        res = float('-inf')
        for i in range(m):
            total = [0] * n
            for j in range(i, m):
                for c in range(n):
                    total[c] += matrix[j][c]
                set_, cur = {0}, 0
                for v in total:
                    cur += v
                    it = bisect.bisect_left(set_, cur - k)
                    if it != len(set_):
                        res = max(res, cur - set_[it])
                    bisect.insort(set_, cur)
        return res