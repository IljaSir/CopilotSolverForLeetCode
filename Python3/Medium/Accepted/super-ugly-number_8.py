class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        n -= 1
        if n == 0:
            return 1
        l = len(primes)
        ugly = [1]
        idx = [0] * l
        while n:
            n -= 1
            ugly.append(min([primes[i] * ugly[idx[i]] for i in range(l)]))
            for i in range(l):
                if ugly[-1] == primes[i] * ugly[idx[i]]:
                    idx[i] += 1
        return ugly[-1]