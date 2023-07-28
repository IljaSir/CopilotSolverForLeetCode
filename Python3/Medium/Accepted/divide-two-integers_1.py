class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1
        if dividend == -2**31 and divisor == 1:
            return -2**31
        if dividend == 2**31-1 and divisor == 1:
            return 2**31-1
        if dividend == 2**31-1 and divisor == -1:
            return -2**31+1
        if dividend == 0:
            return 0
        flag = 1
        if dividend < 0:
            flag = -flag
            dividend = -dividend
        if divisor < 0:
            flag = -flag
            divisor = -divisor
        res = 0
        while dividend >= divisor:
            temp = divisor
            i = 1
            while dividend >= temp:
                dividend -= temp
                res += i
                temp = temp << 1
                i = i << 1
        return res if flag == 1 else -res