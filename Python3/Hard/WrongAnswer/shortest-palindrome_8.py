class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        if not s or len(s) == 1:
            return s
        for i in range(len(s) // 2, 0, -1):
            if s[:i] == s[:i][::-1]:
                return s[i:][::-1] + s
            if s[-i:] == s[-i:][::-1]:
                return s[-i:][::-1] + s