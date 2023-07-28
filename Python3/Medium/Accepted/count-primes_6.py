class Solution:
    def countPrimes(self, n: int) -> int:
        
        if n < 3:
            return 0
        res = 1
        primes = [True] * n
        primes[0] = primes[1] = False
        for i in range(3, n, 2):
            if primes[i]:
                res += 1
                for j in range(i * i, n, i):
                    primes[j] = False
        return res