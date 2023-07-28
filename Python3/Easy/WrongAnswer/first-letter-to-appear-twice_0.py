class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        d = {}
        for i in s:
            d[i] = d.get(i, 0) + 1
        for i in s:
            if d[i] > 1:
                return i