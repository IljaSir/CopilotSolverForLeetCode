class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == 0:
            return 0
        if divisor == 1:
            return dividend
        if divisor == -1:
            if dividend > -2**31:
                return -dividend
            else:
                return 2**31 - 1
        is_neg = (dividend < 0) ^ (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        quotient = 0
        while dividend >= divisor:
            temp, i = divisor, 1
            while dividend >= temp:
                dividend -= temp
                quotient += i
                i <<= 1
                temp <<= 1
        if is_neg:
            quotient = -quotient
        if quotient > 2**31 - 1:
            return 2**31 - 1
        return quotient