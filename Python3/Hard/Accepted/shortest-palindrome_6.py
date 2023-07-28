class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        if not s:
            return s
        n = len(s)
        rev = s[::-1]
        for i in range(n):
            if s.startswith(rev[i:]):
                return rev[:i] + s