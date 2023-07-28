class Solution:
    def checkString(self, s: str) -> bool:
        
        return s.find('b') == -1 or s.find('b') > s.find('a')