class Solution:
    def minFlips(self, s: str) -> int:
        
        s = s + s
        n = len(s)
        res = n
        for i in range(n):
            res = min(res, sum(s[i+j] != '01'[j%2] for j in range(n)))
        return res