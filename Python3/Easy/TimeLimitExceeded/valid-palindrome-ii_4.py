class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def isPalindrome(s):
            return s == s[::-1]
        for i in range(len(s)):
            if isPalindrome(s[:i] + s[i+1:]):
                return True
        return False