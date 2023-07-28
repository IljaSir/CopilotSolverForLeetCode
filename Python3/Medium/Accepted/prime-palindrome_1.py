class Solution:
    def primePalindrome(self, n: int) -> int:
        
        def is_prime(n):
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
        def is_palindrome(n):
            return str(n) == str(n)[::-1]
        while True:
            if is_prime(n) and is_palindrome(n):
                return n
            n += 1
            if 10 ** 7 < n < 10 ** 8:
                n = 10 ** 8