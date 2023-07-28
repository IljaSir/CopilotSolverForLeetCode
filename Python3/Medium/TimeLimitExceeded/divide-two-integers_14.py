class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == -2**31 and divisor == -1:
            return 2**31-1
        if dividend == 0:
            return 0
        if dividend < 0 and divisor < 0:
            dividend = -dividend
            divisor = -divisor
        if dividend < 0:
            return -self.divide(-dividend, divisor)
        if divisor < 0:
            return -self.divide(dividend, -divisor)
        res = 0
        while dividend >= divisor:
            dividend -= divisor
            res += 1
        return res