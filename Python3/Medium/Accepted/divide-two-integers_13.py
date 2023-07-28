class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1
        sign = 1
        if dividend < 0:
            sign *= -1
            dividend = -dividend
        if divisor < 0:
            sign *= -1
            divisor = -divisor
        res = 0
        while dividend >= divisor:
            temp = divisor
            multiple = 1
            while dividend >= temp:
                dividend -= temp
                res += multiple
                temp <<= 1
                multiple <<= 1
        return sign * res