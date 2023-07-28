class Solution:
    def frequencySort(self, s: str) -> str:
        
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        return ''.join(sorted(s, key=lambda x: -d[x]))