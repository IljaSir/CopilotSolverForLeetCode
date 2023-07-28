class Solution:
    def reorganizeString(self, s: str) -> str:
        
        from collections import Counter
        c = Counter(s)
        mx = max(c.values())
        if mx > (len(s) + 1) // 2:
            return ""
        c = sorted(c.items(), key=lambda x: -x[1])
        res = [""] * len(s)
        i = 0
        for k, v in c:
            while v:
                res[i] = k
                v -= 1
                i += 2
                if i >= len(s):
                    i = 1
        return "".join(res)