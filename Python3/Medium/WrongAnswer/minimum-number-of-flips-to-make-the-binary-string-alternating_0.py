class Solution:
    def minFlips(self, s: str) -> int:
        
        n = len(s)
        s = s + s
        res = n
        for c in '01':
            cnt = 0
            for i in range(n):
                if s[i] != c:
                    cnt += 1
                c = '1' if c == '0' else '0'
            res = min(res, cnt)
        return res