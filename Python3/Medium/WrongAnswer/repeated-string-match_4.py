class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if b in a:
            return 1
        if b in a+a:
            return 2
        if b in a+a+a:
            return 3
        return -1