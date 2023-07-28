class Solution:
    def checkString(self, s: str) -> bool:
        
        a = 0
        b = 0
        for i in s:
            if i == 'a':
                a += 1
            elif i == 'b':
                b += 1
            if b > 0 and a == 0:
                return False
        return True