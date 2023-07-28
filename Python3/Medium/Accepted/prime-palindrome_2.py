class Solution:
    def primePalindrome(self, n: int) -> int:
        
        def isPrime(n):
            if n < 2:
                return False
            if n == 2:
                return True
            if n % 2 == 0:
                return False
            for i in range(3, int(n ** 0.5) + 1, 2):
                if n % i == 0:
                    return False
            return True
        
        def isPalindrome(n):
            return str(n) == str(n)[::-1]
        
        while True:
            if n > 10000000 and n < 100000000:
                n = 100000000
            if isPrime(n) and isPalindrome(n):
                return n
            n += 1