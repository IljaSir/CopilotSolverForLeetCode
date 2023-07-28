class Solution:
    def frequencySort(self, s: str) -> str:
        
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        l = sorted(d.items(), key=lambda x: x[1], reverse=True)
        print(l)
        res = ""
        for c, count in l:
            res += c * count
        return res