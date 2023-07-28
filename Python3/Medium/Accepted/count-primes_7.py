class Solution:
    def countPrimes(self, n: int) -> int:
        
        
        if n < 2:
            return 0
        if n == 2:
            return 0
        if n == 3:
            return 1
        
        prime = [True] * n
        prime[0] = False
        prime[1] = False
        prime[2] = True
        prime[3] = True
        
        for i in range(2, int(math.sqrt(n))+1):
            if prime[i]:
                for j in range(i*i, n, i):
                    prime[j] = False
        
        return sum(prime)