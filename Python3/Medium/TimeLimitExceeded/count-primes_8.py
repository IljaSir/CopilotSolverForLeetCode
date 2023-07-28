class Solution:
    def countPrimes(self, n: int) -> int:
        
        if n < 3:
            return 0
        # 2 is the only even prime number
        primes = [2]
        # we can skip evens by adding 2
        for i in range(3, n, 2):
            # we only need to check up to the square root of n
            for p in primes:
                if p * p > i:
                    primes.append(i)
                    break
                if i % p == 0:
                    break
            else:
                primes.append(i)
        return len(primes)