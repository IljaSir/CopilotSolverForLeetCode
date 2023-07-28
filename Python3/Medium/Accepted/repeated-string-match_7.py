class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        n = len(a)
        m = len(b)
        if m % n == 0:
            q = m // n
        else:
            q = m // n + 1
        for i in range(2):
            if b in a * (q + i):
                return q + i
        return -1