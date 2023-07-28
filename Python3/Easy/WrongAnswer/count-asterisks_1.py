class Solution:
    def countAsterisks(self, s: str) -> int:
        
        count = 0
        for i in range(0, len(s)):
            if s[i] == '*':
                count += 1
        return count