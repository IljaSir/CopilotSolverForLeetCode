class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        return min([s[i] for i in range(len(s)) if s[i] in s[:i]])