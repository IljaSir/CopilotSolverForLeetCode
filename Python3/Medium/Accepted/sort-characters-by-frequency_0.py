class Solution:
    def frequencySort(self, s: str) -> str:
        
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        res = ""
        for k, v in d:
            res += k * v
        return res