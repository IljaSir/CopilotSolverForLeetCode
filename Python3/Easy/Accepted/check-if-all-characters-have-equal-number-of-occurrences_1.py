class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        d = {}
        for i in s:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        return len(set(d.values())) == 1