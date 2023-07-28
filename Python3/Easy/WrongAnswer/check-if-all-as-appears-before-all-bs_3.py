class Solution:
    def checkString(self, s: str) -> bool:
        
        a = s.find('a')
        b = s.find('b')
        if a == -1 or b == -1:
            return True
        if a > b:
            return False
        return self.checkString(s[a+1:b]) and self.checkString(s[b+1:])