class Solution:
    def minFlips(self, s: str) -> int:
        
        n = len(s)
        s = s + s
        res = n
        for i in range(n):
            cnt = 0
            for j in range(i, i + n):
                if s[j] != s[j - i + (j >= n)]:
                    cnt += 1
            res = min(res, cnt)
        return res