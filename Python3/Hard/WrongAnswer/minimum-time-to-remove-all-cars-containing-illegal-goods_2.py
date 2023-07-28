class Solution:
    def minimumTime(self, s: str) -> int:
        
        s = s.split('0')
        return len(s) - 1 + 2 * (len(s[0]) + len(s[-1]) > 0)