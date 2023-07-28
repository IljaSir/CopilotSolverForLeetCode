class Solution:
    def checkString(self, s: str) -> bool:
        
        a = 0
        b = 0
        for i in range(len(s)):
            if s[i] == 'a':
                a = i
            elif s[i] == 'b':
                b = i
            if a > b:
                return False
        return True