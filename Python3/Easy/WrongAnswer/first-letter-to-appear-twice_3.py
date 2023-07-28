class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        for i in range(len(s)):
            if s.count(s[i]) > 1:
                return s[i]