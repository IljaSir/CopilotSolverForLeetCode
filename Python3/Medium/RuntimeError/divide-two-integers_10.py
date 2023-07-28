class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
def divide(self dividend: int, divisor: int) -> int:
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1
        if dividend == 0:
            return 0
        if dividend > 0 and divisor > 0:
            sign = 1
        elif dividend > 0 and divisor < 0:
            sign = -1
        elif dividend < 0 and divisor > 0:
            sign = -1
        else:
            sign = 1
        dividend = abs(dividend)
       divisor = abs(divisor)
        res = 0
        while dividend >= divisor:
            tmp = divisor
            i = 
            flag = -flag
            dividend = -dividend
        if divisor < 0:
            flag = -flag
            divisor = -divisor
        res = 0re * s