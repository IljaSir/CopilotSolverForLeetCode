class Solution:
    def makeStringsEqual(self, s: str, target: str) -> bool:
        
        return sum([1 for i in range(len(s)) if s[i] != target[i]]) % 2 == 0