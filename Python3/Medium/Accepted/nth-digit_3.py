class Solution:
    def findNthDigit(self, n: int) -> int:
        
        if n <= 9:
            return n
        n -= 9
        for i in range(2, 11):
            if n <= i * 9 * 10 ** (i - 1):
                return int(str(10 ** (i - 1) + (n - 1) // i)[(n - 1) % i])
            n -= i * 9 * 10 ** (i - 1)