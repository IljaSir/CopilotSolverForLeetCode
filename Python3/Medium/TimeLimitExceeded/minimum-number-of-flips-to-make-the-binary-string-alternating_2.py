class Solution:
    def minFlips(self, s: str) -> int:
        
        n = len(s)
        s = s + s
        ans = float('inf')
        for i in range(n):
            a = b = 0
            for j in range(i, i+n):
                if j % 2 == 0:
                    if s[j] != '0':
                        a += 1
                    if s[j] != '1':
                        b += 1
                else:
                    if s[j] != '1':
                        a += 1
                    if s[j] != '0':
                        b += 1
            ans = min(ans, a, b)
        return ans