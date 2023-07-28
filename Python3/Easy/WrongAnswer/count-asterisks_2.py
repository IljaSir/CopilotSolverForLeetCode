class Solution:
    def countAsterisks(self, s: str) -> int:
        
        l = len(s)
        if l == 0:
            return 0
        i = 1
        count = 0
        while i < l:
            if s[i] == '*':
                count += 1
            elif s[i] == '|':
                i += 1
            i += 1
        return count