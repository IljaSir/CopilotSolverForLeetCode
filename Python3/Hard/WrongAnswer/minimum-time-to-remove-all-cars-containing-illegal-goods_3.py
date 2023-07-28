class Solution:
    def minimumTime(self, s: str) -> int:
        
        s = s.split('1')
        return len(s) + sum(len(x) for x in s) - 1