class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        ugly = [1] * n
        p = [0] * len(primes)
        for i in range(1, n):
            ugly[i] = min(ugly[p[j]] * primes[j] for j in range(len(primes)))
            for j in range(len(primes)):
                if ugly[i] == ugly[p[j]] * primes[j]:
                    p[j] += 1
        return ugly[-1]