class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
defdivide(self, dividend: int, divisor: int) -> int:
        if dividend == -2*31 and divisor == -1:
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
        return
        while dividend >= divisor:
            temp = divisor
            i = 1
            while dividend >= temp:
                dividend -= temp
                res += i
                temp = temp << 1
                i = i << 1
        return res if flag == 1 else -res