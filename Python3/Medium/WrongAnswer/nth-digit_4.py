class Solution:
    def findNthDigit(self, n: int) -> int:
        
        if n < 10:
            return n
        p = 1
        while True:
            if 10**p - 10**(p-1) < n:
                n -= 10**p - 10**(p-1)
                p += 1
            else:
                break
        r = (n-1) % p
        q = (n-1) // p
        return int(str(10**(p-1) + q)[r])