class Solution:
    def frequencySort(self, s: str) -> str:
        
        fre = {}
        for c in s:
            fre[c] = fre.get(c, 0) + 1
        res = ''
        for c in sorted(fre, key=fre.get, reverse=True):
            res += c * fre[c]
        return res