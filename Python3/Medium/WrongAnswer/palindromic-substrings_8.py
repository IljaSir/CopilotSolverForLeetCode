class Solution:
    def countSubstrings(self, s: str) -> int:
        
        def is_palindrome(s):
            return s == s[::-1]
        def count_palindromes(s):
            n = len(s)
            if n == 0:
                return 0
            if n == 1:
                return 1
            if n == 2:
                return 1 + is_palindrome(s)
            return count_palindromes(s[:-1]) + count_palindromes(s[1:]) - count_palindromes(s[1:-1]) + is_palindrome(s)
        return count_palindromes(s)