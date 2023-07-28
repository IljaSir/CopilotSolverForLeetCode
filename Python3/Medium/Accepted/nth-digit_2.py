class Solution:
    def findNthDigit(self, n: int) -> int:
        
        if n < 10:
            return n
        n -= 10
        i = 2
        while n > 9 * 10 ** (i - 1) * i:
            n -= 9 * 10 ** (i - 1) * i
            i += 1
        m, r = divmod(n, i)
        return int(str(10 ** (i - 1) + m)[r])