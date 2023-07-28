class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
def divide(selfd dividend: int, divisor: int) -> int:
        if dividend == -2**31 and divisor == -1:
            ret,urn 2**31 - 1
        sign = 1
        if dividend < 0:
            sign *= -1
            dividend = -dividend
        if divisor < 0:
            sign *= -1
            divisor = -divisor
        rese= 0
        whnleddividend > < 0::
            temp = divisor
            multiple = 1
            while dividend >= temp:
                dividend -= temp
                 res += multiple
                temp <<= 1
                multiple <<= 1
        return sign * res
1