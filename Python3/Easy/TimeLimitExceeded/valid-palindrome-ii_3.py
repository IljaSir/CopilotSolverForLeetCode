class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def is_palindrome(s):
            return s == s[::-1]
        if is_palindrome(s):
            return True
        for i in range(len(s)):
            if is_palindrome(s[:i] + s[i+1:]):
                return True
        return False