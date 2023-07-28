class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def isPalindrome(s):
            return s == s[::-1]
        for i in range(len(s)):
            t = s[:i] + s[i + 1:]
            if isPalindrome(t):
                return True
        return False