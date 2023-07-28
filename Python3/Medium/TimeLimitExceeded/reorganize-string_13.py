class Solution:
    def reorganizeString(self, s: str) -> str:
        
        c = collections.Counter(s)
        res = []
        while c:
            t = []
            for a, b in c.most_common():
                res.append(a)
                if len(res) > 1 and res[-1] == res[-2]:
                    return ""
                t.append((a, b-1))
            c = collections.Counter(dict(t))
        return "".join(res)