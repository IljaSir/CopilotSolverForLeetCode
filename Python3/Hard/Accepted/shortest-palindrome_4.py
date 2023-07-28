class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        if not s:
            return s
        r = s[::-1]
        for i in range(len(s)):
            if s.startswith(r[i:]):
                return r[:i] + s