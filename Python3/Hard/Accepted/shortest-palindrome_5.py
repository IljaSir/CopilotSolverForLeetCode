class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        if s == s[::-1]:
            return s
        for i in range(len(s)):
            if s[:len(s)-i] == (s[:len(s)-i])[::-1]:
                return s[len(s)-i:][::-1] + s