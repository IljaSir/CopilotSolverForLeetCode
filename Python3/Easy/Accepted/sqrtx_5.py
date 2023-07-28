class Solution:
    def mySqrt(self, x: int) -> int:
        
        if x <= 1:
            return x
        left = 1
        right = x
        while left < right:
            mid = (left + right) // 2
            if mid * mid <= x < (mid + 1) * (mid + 1):
                return mid
            if x < mid * mid:
                right = mid
            else:
                left = mid