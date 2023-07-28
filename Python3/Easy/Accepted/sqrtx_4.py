class Solution:
    def mySqrt(self, x: int) -> int:
        
        if x == 0:
            return 0
        if x == 1:
            return 1
        start = 1
        end = x
        while start <= end:
            mid = (start + end) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                start = mid + 1
            else:
                end = mid - 1
        return end