class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        ugly = [1]
        idx = [0] * len(primes)
        while n > 1:
            ugly.append(min(ugly[idx[i]] * primes[i] for i in range(len(primes))))
            for i in range(len(primes)):
                if ugly[-1] == ugly[idx[i]] * primes[i]:
                    idx[i] += 1
            n -= 1
        return ugly[-1]