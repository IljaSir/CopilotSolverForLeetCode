class Solution:
    def reorganizeString(self, s: str) -> str:
        
        c = collections.Counter(s)
        res = ""
        while c:
            for k, v in c.most_common():
                res += k
                c[k] -= 1
                if not c[k]:
                    del c[k]
                if len(res) > 1 and res[-1] == res[-2]:
                    return ""
        return res