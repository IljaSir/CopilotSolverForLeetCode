class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if b in a:
            return 1
        if len(a) > len(b):
            if b in a + a:
                return 2
            else:
                return -1
        else:
            if b in (a * 2):
                return 2
            if b in (a * 3):
                return 3
            if b in (a * 4):
                return 4
            return -1