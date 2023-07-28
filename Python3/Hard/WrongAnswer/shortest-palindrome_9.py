class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        return s + s[::-1][len(s) - s[::-1].find(s):]