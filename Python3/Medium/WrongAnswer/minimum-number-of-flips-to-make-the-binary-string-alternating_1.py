class Solution:
    def minFlips(self, s: str) -> int:
        
        n = len(s)
        s = s + s
        a, b = 0, 0
        for i in range(n):
            if (i % 2 == 0):
                if (s[i] == '0'):
                    a += 1
                else:
                    b += 1
            else:
                if (s[i] == '0'):
                    b += 1
                else:
                    a += 1
        return min(a, b)