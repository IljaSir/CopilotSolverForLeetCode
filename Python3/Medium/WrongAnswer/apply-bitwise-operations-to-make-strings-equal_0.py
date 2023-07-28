class Solution:
    def makeStringsEqual(self, s: str, target: str) -> bool:
        
        return s.count('0') == target.count('0') and s.count('1') == target.count('1')