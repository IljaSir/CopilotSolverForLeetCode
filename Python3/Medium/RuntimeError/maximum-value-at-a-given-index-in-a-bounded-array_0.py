class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        left = 1
        right = maxSum
        while left < right:
            mid = (left + right + 1) // 2
            if self.check(n, index, maxSum, mid):
                left = mid
            else:
                right = mid - 1
        return left