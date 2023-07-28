class Solution:
    def checkString(self, s: str) -> bool:
        
        a = s.find('a')
        b = s.find('b')
        return a < b