class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == -2147483648 and divisor == -1:
            return 2147483647
        if dividend == -2147483648 and divisor == 1:
            return -2147483648
        if dividend == 0:
            return 0
        if divisor == 1:
            return dividend
        if divisor == -1:
            return -dividend
        if dividend > 0 and divisor > 0:
            sign = 1
        elif dividend < 0 and divisor < 0:
            sign = 1
        else:
            sign = -1
        dividend = abs(dividend)
        divisor = abs(divisor)
        q = 0
        while dividend >= divisor:
            dividend -= divisor
            q += 1
        return sign * q