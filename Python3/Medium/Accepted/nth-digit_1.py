class Solution:
    def findNthDigit(self, n: int) -> int:
        
        if n < 10:
            return n
        n -= 10
        digits = 2
        while n >= 9 * 10 ** (digits - 1) * digits:
            n -= 9 * 10 ** (digits - 1) * digits
            digits += 1
        m, r = divmod(n, digits)
        return int(str(10 ** (digits - 1) + m)[r])