class Solution:
    def countAsterisks(self, s: str) -> int:
        
        return len([c for c in s if c == '*'])