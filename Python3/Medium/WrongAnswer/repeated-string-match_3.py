class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if b in a:
            return 1
        elif b in a*2:
            return 2
        elif b in a*3:
            return 3
        return -1