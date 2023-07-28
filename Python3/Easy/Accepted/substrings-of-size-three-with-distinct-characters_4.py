class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        
        result = 0
        for i in range(0, len(s) - 2):
            if len(set(s[i:i+3])) == 3:
                result += 1
        return result