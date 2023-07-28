class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        
        def is_nice(s):
            return all(c.lower() in s and c.upper() in s for c in s)
        for i in range(len(s), 0, -1):
            for j in range(len(s) - i + 1):
                if is_nice(s[j:j+i]):
                    return s[j:j+i]
        return ""