class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        d = {}
        for c in s:
            if c in d:
                return c
            d[c] = True
        return ''