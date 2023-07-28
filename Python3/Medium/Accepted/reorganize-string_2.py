class Solution:
    def reorganizeString(self, s: str) -> str:
        
        if len(s) == 1:
            return s
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        if d[0][1] > (len(s)+1)//2:
            return ""
        res = [None] * len(s)
        i = 0
        for c, cnt in d:
            while cnt > 0:
                res[i] = c
                cnt -= 1
                i += 2
                if i >= len(s):
                    i = 1
        return "".join(res)