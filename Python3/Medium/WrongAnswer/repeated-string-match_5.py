class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        if b in a:
            return 1
        if len(b) > len(a):
            if b in a*2:
                return 2
            if b in a*3:
                return 3
            return -1
        if len(b) == len(a):
            if b in a*2:
                return 2
            return -1
        if len(b) < len(a):
            if b in a:
                return 1
            if b in a*2:
                return 2
            if b in a*3:
                return 3
            return -1