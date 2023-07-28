class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        for i, c in enumerate(s):
            if s[i+1:].find(c) >= 0:
                return c