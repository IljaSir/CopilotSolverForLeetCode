class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if b in a:
            return 1
        elif b in a+a:
            return 2
        elif b in a+a+a:
            return 3
        else:
            return -1