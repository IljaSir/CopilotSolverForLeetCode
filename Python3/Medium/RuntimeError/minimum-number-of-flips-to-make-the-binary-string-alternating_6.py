class Solution:
    def minFlips(self, s: str) -> int:
        
        s = s + s
        n = len(s)
        res = n
        for i in range(n):
            cnt = 0
            for j in range(i, i + n):
                if s[j] != '01'[j % 2]:
                    cnt += 1
            res = min(res, cnt)
        return res