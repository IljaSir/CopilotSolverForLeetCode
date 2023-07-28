class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        m, n, res = len(matrix), len(matrix[0]), float('-inf')
        for i in range(m):
            sums = [0] * n
            for j in range(i, m):
                for c in range(n):
                    sums[c] += matrix[j][c]
                set_ = {0}
                cur_sum = 0
                for s in sums:
                    cur_sum += s
                    it = bisect.bisect_left(set_, cur_sum - k)
                    if it != len(set_):
                        res = max(res, cur_sum - set_[it])
                    bisect.insort(set_, cur_sum)
        return res