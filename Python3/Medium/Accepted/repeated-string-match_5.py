class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        for i in range(1, len(b)//len(a)+3):
            if b in a*i:
                return i
        return -1