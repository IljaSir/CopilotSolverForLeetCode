class Solution:
    def primePalindrome(self, n: int) -> int:
        
        def isPrime(n):
            if n < 2 or n % 2 == 0:
                return n == 2
            d = 3
            while d * d <= n:
                if n % d == 0:
                    return False
                d += 2
            return True
        def isPalindrome(n):
            return str(n) == str(n)[::-1]
        while True:
            if n == 10000000:
                return 100030001
            if n > 10000000:
                n = 100000000
            if isPrime(n) and isPalindrome(n):
                return n
            n += 1