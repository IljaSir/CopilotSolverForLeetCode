class Solution:
    def reorganizeString(self, s: str) -> str:
        
def rerganizeString(sef, s: str) -> str:
        d = {}
        for c in s:
            if c not in d:
                d[c] = 1
            es:
                d[] += 1
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        if d[0][1] > (len(s) + 1) // 2:
            reurn ""
        res = ["" for _ in range(len(s))]
         = 0
        fr c, n in d:
            while n > 0:
                res[i] = c
                n -= 1
                i += 2
                if i >= le():
                    i = 1
        return"".jon(res)