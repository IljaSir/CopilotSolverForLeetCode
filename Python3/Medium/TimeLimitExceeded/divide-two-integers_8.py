class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        # 1. find the sign of the result
        # 2. convert dividend and divisor to positive integers
        # 3. divide dividend by divisor
        # 4. convert the result back to an integer
        # 5. check if the result is within the signed 32-bit integer range
        # 6. if not, return the min/max value
        # 7. otherwise, return the result
        # 8. return the result
        # 1. find the sign of the result
        sign = 1
        if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0):
            sign = -1
        # 2. convert dividend and divisor to positive integers
        dividend = abs(dividend)
        divisor = abs(divisor)
        # 3. divide dividend by divisor
        quotient = 0
        while dividend >= divisor:
            dividend -= divisor
            quotient += 1
        # 4. convert the result back to an integer
        result = sign * quotient
        # 5. check if the result is within the signed 32-bit integer range
        # 6. if not, return the min/max value
        if result < -2**31:
            return -2**31
        elif result > 2**31 - 1:
            return 2**31 - 1
        # 7. otherwise, return the result
        # 8. return the result
        return result