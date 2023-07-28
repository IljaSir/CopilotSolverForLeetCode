class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) == 0:
            return ""
        if len(s) == 1:
            return s
        start = 0
        end = 0
        for i in range(len(s)):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i + 1)
            length = max(len1, len2)
            if length > end - start:
                start = i - ((length - 1) // 2)
                end = i + (length // 2)
        return s[start:end + 1]