class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        return len(set(d.values())) == 1