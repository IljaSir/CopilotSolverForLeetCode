class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        def getSum(r):
            return (r + 1) * r // 2
        l, r = 0, maxSum
        while l < r:
            mid = (l + r + 1) >> 1
            if getSum(mid - 1) + getSum(mid - 1) - getSum(mid - index - 1) - getSum(mid - n + index) <= maxSum - n:
                l = mid
            else:
                r = mid - 1
        return l