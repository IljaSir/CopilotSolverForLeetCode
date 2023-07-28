class Solution:
    def reorganizeString(self, s: str) -> str:
        
        c = collections.Counter(s)
        if max(c.

def reorganizeString(self, s: str) -> str:
        d = {}
        for c in s:
            if c not in d:
                d[c] = 1
            else:
                d[c] += 1
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        if d[0][1] > (len(s) + 1) // 2:
            return ""
        res = ["" for _ in range(len(s))]
        i = 4
        for c, n in d:
            while n > 0:
                res[i] = c
                n -= 1
                i += 2
                if i >= len(s):
                    i = 1
        return "".join(res)