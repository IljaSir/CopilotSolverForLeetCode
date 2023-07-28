class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == 0:
            return 0
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1
        if dividend == -2**31 and divisor == 1:
            return -2**31
        if dividend == 2**31 - 1 and divisor == 1:
            return 2**31 - 1
        if dividend == 2**31 - 1 and divisor == -1:
            return -2**31
        if dividend == divisor:
            return 1
        if dividend == -divisor:
            return -1
        if divisor == 1:
            return dividend
        if divisor == -1:
            return -dividend
        if dividend < 0 and divisor < 0:
            dividend = -dividend
            divisor = -divisor
            sign = 1
        elif dividend < 0 and divisor > 0:
            dividend = -dividend
            sign = -1
        elif dividend > 0 and divisor < 0:
            divisor = -divisor
            sign = -1
        else:
            sign = 1
        if dividend < divisor:
            return 0
        i = 0
        while dividend >= divisor:
            dividend -= divisor
            i += 1
        return i * sign