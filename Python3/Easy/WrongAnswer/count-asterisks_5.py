class Solution:
    def countAsterisks(self, s: str) -> int:
        
        return s.count('*') - s.count('|*')