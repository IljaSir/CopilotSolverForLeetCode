class Solution:
    def reorganizeString(self, s: str) -> str:
        
        if len(s) == 1:
            return s
        s = list(s)
        d = {}
        for c in s:
            if c not in d:
                d[c] = 1
            else:
                d[c] += 1
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        if d[0][1] > (len(s)+1)//2:
            return ""
        res = []
        while d:
            res.append(d[0][0])
            d[0] = (d[0][0], d[0][1]-1)
            if d[0][1] == 0:
                d.pop(0)
            d.sort(key=lambda x: x[1], reverse=True)
        return "".join(res)