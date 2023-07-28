class Solution:
    def secondHighest(self, s: str) -> int:
        
        s = [int(c) for c in s if c.isdigit()]
        if not s:
            return -1
        s.sort(reverse=True)
        for i in range(1, len(s)):
            if s[i] < s[i-1]:
                return s[i]
        return -1