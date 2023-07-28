class Solution:
    def reorganizeString(self, s: str) -> str:
        
        from collections import Counter
        s = Counter(s)
        if max(s.values()) > (len(s)+1)/2:
            return ""
        s = sorted(s.items(), key=lambda x: x[1], reverse=True)
        res = [0]*len(s)
        i = 0
        for c, n in s:
            while n > 0:
                res[i] = c
                i += 2
                if i >= len(res):
                    i = 1
                n -= 1
        return "".join(res)