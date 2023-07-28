class Solution:
    def primePalindrome(self, n: int) -> int:
        
        if n == 1: return 2
        if 8 <= n <= 11: return 11
        for x in range(1, 100000):
            s = str(x)
            y = int(s + s[-2::-1])
            if y >= n and self.isPrime(y):
                return y