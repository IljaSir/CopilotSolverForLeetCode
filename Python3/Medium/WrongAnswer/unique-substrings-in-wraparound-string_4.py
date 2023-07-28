class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        
        d = {}
        for i in range(len(s)):
            d[s[i]] = 1
        for i in range(1, len(s)):
            if ord(s[i]) - ord(s[i-1]) == 1 or ord(s[i]) - ord(s[i-1]) == -25:
                d[s[i]] = max(d[s[i]], d[s[i-1]]+1)
        return sum(d.values())