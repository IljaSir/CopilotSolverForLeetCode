class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        
        def is_nice(s):
            for c in s:
                if c.islower() and c.upper() not in s or c.isupper() and c.lower() not in s:
                    return False
            return True

        for i in range(len(s), 0, -1):
            for j in range(len(s) - i + 1):
                if is_nice(s[j:j + i]):
                    return s[j:j + i]
        return ""