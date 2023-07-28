class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        
        def maxSubArray(nums, k):
            res = float("-inf")
            preSum = 0
            preSumSet = {0}
            for num in nums:
                preSum += num
                it = bisect.bisect_left(preSumSet, preSum - k)
                if it != len(preSumSet):
                    res = max(res, preSum - preSumSet[it])
                bisect.insort(preSumSet, preSum)
            return res
        m, n = len(matrix), len(matrix[0])
        res = float("-inf")
        for i in range(m):
            total = [0] * n
            for j in range(i, m):
                for c in range(n):
                    total[c] += matrix[j][c]
                res = max(res, maxSubArray(total, k))
        return res