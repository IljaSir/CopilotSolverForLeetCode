class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        def get_sum(a, b, c):
            return (a + b) * (b - a + 1) // 2 + c * (b - a)
        left = 1
        right = maxSum
        while left < right:
            mid = (left + right + 1) // 2
            if get_sum(max(0, mid - index - 1), mid - 1, mid) + get_sum(max(0, mid - n + index), mid - 1, mid) - mid <= maxSum:
                left = mid
            else:
                right = mid - 1
        return left