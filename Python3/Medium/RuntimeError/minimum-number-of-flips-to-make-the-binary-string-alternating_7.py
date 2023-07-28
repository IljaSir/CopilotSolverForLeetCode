class Solution:
    def minFlips(self, s: str) -> int:
        
        n = len(s)
        s += s
        res = n
        for i in range(n):
            res = min(res, sum(s[i+j] != '01'[i+j%2] for j in range(n)))
        return res