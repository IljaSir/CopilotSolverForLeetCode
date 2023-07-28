class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        
        if not s:
            return ""
        if len(s) == 1:
            return ""
        if len(s) == 2:
            if s[0].lower() == s[1].lower():
                return s
            else:
                return ""
        for i in range(len(s)):
            if s[i].lower() not in s:
                return max(self.longestNiceSubstring(s[:i]), self.longestNiceSubstring(s[i+1:]), key=len)
            if s[i].upper() not in s:
                return max(self.longestNiceSubstring(s[:i]), self.longestNiceSubstring(s[i+1:]), key=len)
        return s