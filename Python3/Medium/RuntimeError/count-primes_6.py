class Solution:
    def countPrimes(self, n: int) -> int:
        
        if n < 3:
            return 0
        res = 0
        for i in range(2, n):
            if self.isPrime(i):
                res += 1
        return res