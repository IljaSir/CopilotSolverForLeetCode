class Solution:
    def countAsterisks(self, s: str) -> int:
        
        n = len(s)
        i = 0
        count = 0
        while i < n:
            if s[i] == '*':
                count += 1
            elif s[i] == '|':
                i += 1
            i += 1
        return count