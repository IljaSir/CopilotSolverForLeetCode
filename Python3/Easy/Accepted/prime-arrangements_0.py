class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        
        def is_prime(n):
            if n < 2:
                return False
            for i in range(2, int(n ** 0.5) + 1):
                if n % i == 0:
                    return False
            return True
        primes, composites = 0, 0
        for i in range(1, n + 1):
            if is_prime(i):
                primes += 1
            else:
                composites += 1
        return (math.factorial(primes) * math.factorial(composites)) % (10 ** 9 + 7)