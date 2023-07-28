class Solution:
    def mySqrt(self, x: int) -> int:
        
        if x == 0:
            return 0
        left = 1
        right = x
        while left < right:
            mid = left + (right - left) // 2
            if mid <= x // mid:
                left = mid + 1
            else:
                right = mid
        return left - 1